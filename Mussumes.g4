grammar Mussumes;

@header{
    import datastructures.Symbol;
    import datastructures.Variable;
    import datastructures.SymbolTable;
    import exceptions.SemanticException;
    import ast.Program;
    import ast.AbstractCommand;
    import java.util.ArrayList;
    import ast.CommandLeitura;
    import ast.CommandEscrita;
    import ast.CommandBloco;
    import ast.CommandDecisao;
    import ast.CommandEnquanto;
    import ast.CommandAtribuicao;
}

@members{
    private int _tipo;
    private String _varName;
    private String _varValue;
    private SymbolTable symbolTable = new SymbolTable();
    private Symbol symbol;
    private Program program = new Program();
    private ArrayList<AbstractCommand> curThread = new ArrayList<AbstractCommand>();

    private String _readID;
    private String _writeID;
    private String _exprID;
    private String _exprContent;
    private String _exprDecision;
    private ArrayList<AbstractCommand> listaTrue;
    private ArrayList<AbstractCommand> listaFalse;

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

    public void adicionaID(Symbol symbol) {
        String name = symbol.getName();
        if (RESERVED_WORDS.contains(name.toLowerCase())) {
            throw new SemanticException("Nome reservadis: " + name);
        }
        if (symbolTable.exists(name)){
            throw new SemanticException("Esse "+name+" já existis, cumpadis!");
        }
        symbolTable.add(symbol);
    }

    public Variable verificaID(String id) {
        if(!symbolTable.exists(id)) {
            throw new SemanticException("Esse "+id+" num existis, cumpadis!");
        }
        return (Variable) symbolTable.get(id);
    }

    public void verificaNum(String value, int tipo) {
        try {
            if (tipo == Variable.INT) {
                Integer.parseInt(value);
            } else if (tipo == Variable.FLOAT) {
                Float.parseFloat(value);
            } else {
                throw new SemanticException("Tipus inválidis: " + value);
            }
        } catch (NumberFormatException e) {
            throw new SemanticException("Valor numéricus inválidis: " + value);
        }
    }

    public void verificaCond(int tipo) {
        if (tipo != Variable.BOOLEAN) {
            throw new SemanticException("Expressão de condição deve ser boolean, cumpadis!");
        }
    }

    public void exibeComandos(){
        for (AbstractCommand c: program.getCommands()){
            System.out.println(c);
        }
    }

    public void generateCode(){
        program.generateTarget();
    }
}


/* -----------------------------
 * Regras sintáticas
 * -----------------------------
 */

prog        : 'iniciavis' decl bloco 'fimis'
                { program.setCommands(curThread); }
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
cmdleitura  : 'levis'
        AP
        ID {
            Variable var = verificaID(_input.LT(-1).getText());
            _readID = _input.LT(-1).getText();
            var.setInitialized(true);
        }
        FP
        SC {
            CommandLeitura cmd = new CommandLeitura(_readID); 
            curThread.add(cmd);
        };
cmdescrita  : 'escrevis' 
        AP e=expr_or_bool
        ID {
            verificaID(_input.LT(-1).getText());
            _writeID = _input.LT(-1).getText();
        }
        FP
        SC {
            CommandEscrita cmd = new CommandEscrita(_writeID);
            curThread.add(cmd);
        };
cmdattrib   : ID {Variable var = verificaID(_input.LT(-1).getText());_varName = _input.LT(-1).getText();}
              ATTR
              e=expr_or_bool {
                if (var.getType() == Variable.INT) {
                    if ($e.tipoExpr != Variable.INT) {
                        throw new SemanticException("Tipus incompatívis pra variavis "+ _varName +", cumpadis!");
                    }
                }
                if (var.getType() == Variable.FLOAT) {
                    if ($e.tipoExpr != Variable.INT && $e.tipoExpr != Variable.FLOAT) {
                        throw new SemanticException("Tipus incompatívis pra variavis "+ _varName +", cumpadis!");
                    }
                }
                if (var.getType() == Variable.TEXT) {
                    if ($e.tipoExpr != Variable.TEXT) {
                        throw new SemanticException("Tipus incompatívis pra variavis "+ _varName +", cumpadis!");
                    }
                }
                if (var.getType() == Variable.BOOLEAN) {
                    if ($e.tipoExpr != Variable.BOOLEAN) {
                        throw new SemanticException("Tipus incompatívis pra variavis "+ _varName +", cumpadis!");
                    }
                }
                var.setInitialized(true);
             } SC;
cmdselecao  : 'si' AP cond=expr_or_bool {verificaCond($cond.tipoExpr);} FP 'entaovis' ACH (cmd)+ FCH
            ('elsivis' AP cond2=expr_or_bool {verificaCond($cond2.tipoExpr);} FP 'entaovis' ACH (cmd)+ FCH)?
            ('senaovis' ACH (cmd)+ FCH)?;
cmdrepeticao
    : 'fazis' ACH (cmd)+ FCH 'enquantis' AP cond=boolexpr { verificaCond($cond.tipoExpr);} FP
    | 'enquantis' AP cond=boolexpr { verificaCond($cond.tipoExpr);} FP ACH (cmd)+ FCH;
cmdfor
    : 'foris' AP 
        init=cmdattrib
        step=cmdattrib
        cond=boolexpr {verificaCond($cond.tipoExpr);}
      FP
      ACH (cmd)+ FCH
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