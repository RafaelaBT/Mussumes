grammar Mussumes;

@header{
    import datastructures.Symbol;
    import datastructures.Variable;
    import datastructures.SymbolTable;
    import exceptions.SemanticException;
    import ast.Program;
    import ast.AbstractCommand;
    import java.util.ArrayList;
    import java.util.Stack;
    import ast.CommandLeitura;
    import ast.CommandEscrita;
    import ast.CommandBloco;
    import ast.CommandDecisao;
    import ast.CommandEnquanto;
    import ast.CommandAtribuicao;
    import org.antlr.v4.runtime.ParserRuleContext;
    import org.antlr.v4.runtime.misc.Interval;
}

@parser::members {
    private int _tipo;
    private String _varName;
    private String _varValue;
    private datastructures.SymbolTable symbolTable = new datastructures.SymbolTable();
    private datastructures.Symbol symbol;
    private ast.Program program = new ast.Program();
    private java.util.ArrayList<ast.AbstractCommand> curThread = new java.util.ArrayList<ast.AbstractCommand>();

    private String _readID;
    private String _writeID;
    private String _exprID;
    private String _exprContent;
    private String _exprDecision;
    private java.util.ArrayList<ast.AbstractCommand> listaTrue;
    private java.util.ArrayList<ast.AbstractCommand> listaFalse;

    private String _forInitId, _forInitExpr, _forStepId, _forStepExpr;

    private java.util.Stack<java.util.ArrayList<ast.AbstractCommand>> stack = new java.util.Stack<>();

    private ast.CommandDecisao _ifRoot;
    private ast.CommandDecisao _ifCurrent;

    private static final java.util.Set<String> RESERVED_WORDS = new java.util.HashSet<String>() {{
        add("iniciavis");
        add("fimis");
        add("interis");
        add("floatis");
        add("letris");
        add("levis");
        add("escrevis");
        add("si");
        add("entaovis");
        add("elsivis");
        add("senaovis");
        add("verdadis");
        add("verdaderis");
        add("falsis");
        add("fazis");
        add("enquantis");
    }};

    public void adicionaID(datastructures.Symbol symbol) {
        String name = symbol.getName();
        if (RESERVED_WORDS.contains(name.toLowerCase())) {
            throw new exceptions.SemanticException("Nome reservadis: " + name);
        }
        if (symbolTable.exists(name)){
            throw new exceptions.SemanticException("Esse "+name+" já existis, cumpadis!");
        }
        symbolTable.add(symbol);
    }

    public datastructures.Variable verificaID(String id) {
        if(!symbolTable.exists(id)) {
            throw new exceptions.SemanticException("Esse "+id+" num existis, cumpadis!");
        }
        return (datastructures.Variable) symbolTable.get(id);
    }

    public void verificaNum(String value, int tipo) {
        try {
            if (tipo == datastructures.Variable.INT) {
                Integer.parseInt(value);
            } else if (tipo == datastructures.Variable.FLOAT) {
                Float.parseFloat(value);
            } else {
                throw new exceptions.SemanticException("Tipus inválidis: " + value);
            }
        } catch (NumberFormatException e) {
            throw new exceptions.SemanticException("Valor numéricus inválidis: " + value);
        }
    }

    public void verificaCond(int tipo) {
        if (tipo != datastructures.Variable.BOOLEAN) {
            throw new exceptions.SemanticException("Expressão de condição deve ser boolean, cumpadis!");
        }
    }

    public void exibeComandos(){
        for (ast.AbstractCommand c: program.getCommands()){
            System.out.println(c);
        }
    }

    public void generateCode(){
        program.generateTarget();
    }

    private String textOf(org.antlr.v4.runtime.ParserRuleContext ctx){
        return _input.getText(ctx.getSourceInterval());
    }

    private String normalizeExpr(String s){
        if (s == null) return null;
        s = s.replaceAll("\\bverdaderis\\b", "true");
        s = s.replaceAll("\\bfalsis\\b", "false");
        return s;
    }

    private String addFloatSuffixIfNeeded(String s){
        if (s == null) return null;
        return s.replaceAll("(\\d+\\.\\d+)(?![fF])", "$1f");
    }
}
/* -----------------------------
 * Regras sintáticas
 * -----------------------------
 */

prog        : 'iniciavis' decl bloco 'fimis'
                {
                    program.setSymbolTable(symbolTable);
                    program.setProgramName("MussumProgram");
                    program.setCommands(curThread);
                }
            ;


decl        : (declaravar)*;
declaravar  : tipo ID {
                _varName  = _input.LT(-1).getText();
                symbol    = new Variable(_varName, _tipo, null);
                adicionaID(symbol);
            } (VIR ID {
                _varName  = _input.LT(-1).getText();
                symbol    = new Variable(_varName, _tipo, null);
                adicionaID(symbol);
            })* SC;
tipo        : 'interis'  {_tipo = Variable.INT;}
            | 'floatis'  {_tipo = Variable.FLOAT;}
            | 'letris'   {_tipo = Variable.TEXT;}
            | 'verdadis' {_tipo = Variable.BOOLEAN;}; 

bloco       : (cmd)+;
cmd         : cmdleitura
            | cmdescrita
            | cmdattrib
            | cmdselecao
            | cmdrepeticao
            | cmdfor;
cmdleitura  : 'levis' AP id=ID
                {
                    Variable var = verificaID($id.text);
                    _readID = $id.text;
                    var.setInitialized(true);
                }
                FP SC
                {
                    curThread.add(new CommandLeitura(_readID, verificaID(_readID).getType()));
                }
            ;
cmdescrita  : 'escrevis' AP e=expr_or_bool FP SC
                {
                String exprText = normalizeExpr( textOf($e.ctx) );
                curThread.add(new CommandEscrita(exprText));
                }
            ;
cmdattrib   : ID { Variable var = verificaID(_input.LT(-1).getText()); _varName = _input.LT(-1).getText(); }
                ATTR
                e=expr_or_bool
                {
                if (var.getType() == Variable.INT) {
                    if ($e.tipoExpr != Variable.INT) {
                        throw new SemanticException("Tipus incompatívis pra variavis "+ _varName +", cumpadis!");
                    }
                } else if (var.getType() == Variable.FLOAT) {
                    if ($e.tipoExpr != Variable.INT && $e.tipoExpr != Variable.FLOAT) {
                        throw new SemanticException("Tipus incompatívis pra variavis "+ _varName +", cumpadis!");
                    }
                } else if (var.getType() == Variable.TEXT) {
                    if ($e.tipoExpr != Variable.TEXT) {
                        throw new SemanticException("Tipus incompatívis pra variavis "+ _varName +", cumpadis!");
                    }
                } else if (var.getType() == Variable.BOOLEAN) {
                    if ($e.tipoExpr != Variable.BOOLEAN) {
                        throw new SemanticException("Tipus incompatívis pra variavis "+ _varName +", cumpadis!");
                    }
                }
                var.setInitialized(true);

                String exprText = normalizeExpr( textOf($e.ctx) );
                if (var.getType() == Variable.FLOAT) {
                    exprText = addFloatSuffixIfNeeded(exprText);
                }
                curThread.add(new CommandAtribuicao(_varName, exprText));
                }
                SC
            ;
cmdselecao  : 'si' AP c1=boolexpr FP 'entaovis' ACH
                {
                    verificaCond($c1.tipoExpr);
                    String cond1 = addFloatSuffixIfNeeded( normalizeExpr( textOf($c1.ctx) ) );
                    stack.push(curThread);
                    curThread = new ArrayList<AbstractCommand>();
                }
                (cmd)+
                FCH
                {
                    ArrayList<AbstractCommand> then1 = curThread;
                    curThread = stack.pop();

                    _ifRoot = new CommandDecisao(cond1);
                    for (AbstractCommand c : then1) _ifRoot.addTrueCommand(c);
                    _ifCurrent = _ifRoot;
                }
                ( 'elsivis' AP cN=boolexpr FP 'entaovis' ACH
                    {
                        verificaCond($cN.tipoExpr);
                        String condN = addFloatSuffixIfNeeded( normalizeExpr( textOf($cN.ctx) ) );
                        stack.push(curThread);
                        curThread = new ArrayList<AbstractCommand>();
                        _exprDecision = condN;
                    }
                    (cmd)+
                FCH
                    {
                    ArrayList<AbstractCommand> thenN = curThread;
                    curThread = stack.pop();

                    CommandDecisao next = new CommandDecisao(_exprDecision);
                    for (AbstractCommand c: thenN) next.addTrueCommand(c);
                    _ifCurrent.addFalseCommand(next);
                    _ifCurrent = next;
                    }
                )*
                ( 'senaovis' ACH
                    { stack.push(curThread); curThread = new ArrayList<AbstractCommand>(); }
                    (cmd)+
                FCH
                    {
                    ArrayList<AbstractCommand> elseList = curThread;
                    curThread = stack.pop();
                    for (AbstractCommand c: elseList) _ifCurrent.addFalseCommand(c);
                    }
                )?
                {
                    curThread.add(_ifRoot);
                    _ifRoot = null; _ifCurrent = null;
                }
            ;
cmdrepeticao: 'enquantis' AP c=boolexpr FP ACH
                {
                    verificaCond($c.tipoExpr);
                    String condText = addFloatSuffixIfNeeded( normalizeExpr( textOf($c.ctx) ) );
                    stack.push(curThread);
                    curThread = new ArrayList<AbstractCommand>();
                    _exprDecision = condText;
                }
                (cmd)+
                FCH
                {
                    ArrayList<AbstractCommand> corpo = curThread;
                    curThread = stack.pop();

                    CommandEnquanto loop = new CommandEnquanto(_exprDecision);
                    for (AbstractCommand c: corpo) loop.addCommand(c);
                    curThread.add(loop);
                }

            | 'fazis' ACH
                { stack.push(curThread); curThread = new ArrayList<AbstractCommand>(); }
                (cmd)+
                FCH 'enquantis' AP c2=boolexpr FP
                {
                    verificaCond($c2.tipoExpr);
                    String cond2 = addFloatSuffixIfNeeded( normalizeExpr( textOf($c2.ctx) ) );

                    ArrayList<AbstractCommand> corpo = curThread;
                    curThread = stack.pop();

                    // do-while(cond) -> while(true){ corpo; if(!(cond)) break; }
                    CommandEnquanto loop = new CommandEnquanto("true");
                    for (AbstractCommand c: corpo) loop.addCommand(c);
                    CommandDecisao breaker = new CommandDecisao("!("+cond2+")");
                    breaker.addTrueCommand(new AbstractCommand(){ public String generateJavaCode(){ return "break;"; }});
                    loop.addCommand(breaker);
                    curThread.add(loop);
                }
            ;
cmdfor      : 'foris' AP
                idInit=ID
                {
                    Variable v1 = verificaID($idInit.text);
                    String id1 = $idInit.text;
                }
                ATTR eInit=expr_or_bool SC
                {
                    if (v1.getType() == Variable.INT && $eInit.tipoExpr != Variable.INT)
                        throw new SemanticException("Tipus incompatívis pra variavis "+ id1 +", cumpadis!");
                    if (v1.getType() == Variable.FLOAT && !($eInit.tipoExpr == Variable.INT || $eInit.tipoExpr == Variable.FLOAT))
                        throw new SemanticException("Tipus incompatívis pra variavis "+ id1 +", cumpadis!");
                    if (v1.getType() == Variable.TEXT && $eInit.tipoExpr != Variable.TEXT)
                        throw new SemanticException("Tipus incompatívis pra variavis "+ id1 +", cumpadis!");
                    if (v1.getType() == Variable.BOOLEAN && $eInit.tipoExpr != Variable.BOOLEAN)
                        throw new SemanticException("Tipus incompatívis pra variavis "+ id1 +", cumpadis!");

                    String initExpr = normalizeExpr( textOf($eInit.ctx) );
                    if (v1.getType() == Variable.FLOAT) {
                        initExpr = addFloatSuffixIfNeeded(initExpr);
                    }
                    v1.setInitialized(true);
                    _forInitId = id1; _forInitExpr = initExpr;
                }

                idStep=ID
                {
                    Variable v2 = verificaID($idStep.text);
                    String id2 = $idStep.text;
                }
                ATTR eStep=expr_or_bool SC
                {
                    if (v2.getType() == Variable.INT && $eStep.tipoExpr != Variable.INT)
                        throw new SemanticException("Tipus incompatívis pra variavis "+ id2 +", cumpadis!");
                    if (v2.getType() == Variable.FLOAT && !($eStep.tipoExpr == Variable.INT || $eStep.tipoExpr == Variable.FLOAT))
                        throw new SemanticException("Tipus incompatívis pra variavis "+ id2 +", cumpadis!");
                    if (v2.getType() == Variable.TEXT && $eStep.tipoExpr != Variable.TEXT)
                        throw new SemanticException("Tipus incompatívis pra variavis "+ id2 +", cumpadis!");
                    if (v2.getType() == Variable.BOOLEAN && $eStep.tipoExpr != Variable.BOOLEAN)
                        throw new SemanticException("Tipus incompatívis pra variavis "+ id2 +", cumpadis!");

                    String stepExpr = normalizeExpr( textOf($eStep.ctx) );
                    if (v2.getType() == Variable.FLOAT) {
                        stepExpr = addFloatSuffixIfNeeded(stepExpr);
                    }
                    _forStepId = id2; _forStepExpr = stepExpr;
                }

                cond=boolexpr
                {
                    verificaCond($cond.tipoExpr);
                    String condText = addFloatSuffixIfNeeded( normalizeExpr( textOf($cond.ctx) ) );
                    _exprDecision = condText;
                }
                FP
                ACH
                { stack.push(curThread); curThread = new ArrayList<AbstractCommand>(); }
                (cmd)+
                FCH
                {
                    ArrayList<AbstractCommand> corpo = curThread;
                    curThread = stack.pop();

                    // init;
                    curThread.add(new CommandAtribuicao(_forInitId, _forInitExpr));

                    // while(cond){ corpo; step; }
                    CommandEnquanto loop = new CommandEnquanto(_exprDecision);
                    for (AbstractCommand c: corpo) loop.addCommand(c);
                    loop.addCommand(new CommandAtribuicao(_forStepId, _forStepExpr));
                    curThread.add(loop);
                }
            ;


/* -----------------------------
 * Expressões com precedência
 * -----------------------------
 */

expr_or_bool returns [int tipoExpr]
            : b=boolexpr {$tipoExpr = $b.tipoExpr;}
            | e=expr     {$tipoExpr = $e.tipoExpr;};

expr returns [int tipoExpr]
            : t1 = termo {$tipoExpr = $t1.tipoTermo;}
            (('+'|'-') t2 = termo {
                if ($tipoExpr == Variable.FLOAT || $t2.tipoTermo == Variable.FLOAT)
                    $tipoExpr = Variable.FLOAT;
            })*;

termo returns [int tipoTermo]
            : f1=fator {$tipoTermo = $f1.tipoFator;}
              (('*'|'/') f2=fator {
                if ($tipoTermo == Variable.FLOAT || $f2.tipoFator == Variable.FLOAT)
                $tipoTermo = Variable.FLOAT;
              })*;
            
fator returns [int tipoFator] 
            : ID    { Variable var = verificaID(_input.LT(-1).getText());
                      if (!var.isInitialized()) {
                        throw new SemanticException("Variavis " + var.getName() + " não inicializadis, cumpadis!");
                      }
                      $tipoFator = var.getType(); }
            | INT   { _varValue = _input.LT(-1).getText();
                      verificaNum(_varValue, Variable.INT);
                      $tipoFator = Variable.INT; }
            | FLOAT { _varValue = _input.LT(-1).getText();
                      verificaNum(_varValue, Variable.FLOAT);
                      $tipoFator = Variable.FLOAT; }
            | STRING { $tipoFator = Variable.TEXT; }
            | TRUE { $tipoFator = Variable.BOOLEAN; }
            | FALSE { $tipoFator = Variable.BOOLEAN; }
            | AP e=expr_or_bool FP { $tipoFator = $e.tipoExpr; };

/* -----------------------------
 * Expressões booleanas
 * -----------------------------
 */

boolexpr returns [int tipoExpr]
            : b1=booltermo { $tipoExpr = $b1.tipoTermo; }
              ( '||' b2=booltermo { $tipoExpr = Variable.BOOLEAN; } )*;

booltermo returns [int tipoTermo]
            : f1=boolfator { $tipoTermo = $f1.tipoFator; }
              ( '&&' f2=boolfator { $tipoTermo = Variable.BOOLEAN; } )*;

boolfator returns [int tipoFator]
            : '!' f=boolfator { $tipoFator = Variable.BOOLEAN; }
            | c=comparison { $tipoFator = $c.tipoFator;}
            | ID { Variable var = verificaID(_input.LT(-1).getText());
                      if (!var.isInitialized()) {
                        throw new SemanticException("Variavis " + var.getName() + " não inicializadis, cumpadis!");
                      }
                      $tipoFator = var.getType(); }
            | TRUE { $tipoFator = Variable.BOOLEAN; }
            | FALSE { $tipoFator = Variable.BOOLEAN; }
            | AP b=boolexpr FP { $tipoFator = $b.tipoExpr; };

comparison returns [int tipoFator]
    : left=expr op=OPREL right=expr {
        if (!((($left.tipoExpr == Variable.INT || $left.tipoExpr == Variable.FLOAT) &&
               ($right.tipoExpr == Variable.INT || $right.tipoExpr == Variable.FLOAT)) ||
              ($left.tipoExpr == $right.tipoExpr))) {
            throw new SemanticException("Tipos incompatíveis na comparação, cumpadis!");
        }
        $tipoFator = Variable.BOOLEAN;
      };

/* -----------------------------
 * Regras léxicas
 * -----------------------------
 */

VIR         : ',';
AP          : '(';
FP          : ')';
ACH         : '{';
FCH         : '}';
SC          : ';';
ATTR        : '=';
OPREL       : '>' | '<' | '==' | '>=' | '<=' | '<>';
WS          : (' ' | '\t' | '\n' | '\r') -> skip;
COMMENT     : '//' ~[\r\n]* -> skip ;

TRUE        : 'verdaderis';
FALSE       : 'falsis';
ID          : [a-zA-Z] [a-zA-Z0-9]*;
FLOAT       : ('0'..'9')+ '.' ('0'..'9')+;
INT         : ('0'..'9')+;
STRING      : '"' (~["\r\n])* '"' ;