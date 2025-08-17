grammar Mussumes;

@header{
    import datastructures.Symbol;
    import datastructures.Variable;
    import datastructures.SymbolTable;
    import exceptions.SemanticException;
    import java.util.ArrayList;
}

@members{
    private int _tipo;
    private String _varName;
    private String _varValue;
    private SymbolTable symbolTable = new SymbolTable();
    private Symbol symbol;

    public void adicionaID(String id) {
        if (symbolTable.exists(_varName)){
            throw new SemanticException("Esse "+_varName+" já existis, cumpadis!");
        }
        symbolTable.add(symbol);
        System.out.println("Variavis "+ symbol.getName() +" adicionadus!");
    }

    public void verificaID(String id) {
        if(!symbolTable.exists(id)) {
            throw new SemanticException("Esse "+id+" num existis, cumpadis!");
        }
    }
}

prog        : 'iniciavis' decl bloco 'fimis' SC;

decl        : (declaravar)+;
declaravar  : tipo ID {
                _varName  = _input.LT(-1).getText();
                symbol    = new Variable(_varName, _tipo, null);
                adicionaID(_varName);
            } (VIR ID {
                _varName  = _input.LT(-1).getText();
                symbol    = new Variable(_varName, _tipo, null);
                adicionaID(_varName);
            })* SC;
tipo        : 'numeris' {_tipo = Variable.NUMBER;}
            | 'letris'  {_tipo = Variable.TEXT;}; 

bloco       : (cmd)+;
cmd         : cmdleitura
            | cmdescrita
            | cmdattrib;
cmdleitura  : 'levis' AP ID {verificaID(_input.LT(-1).getText());} FP SC;
cmdescrita  : 'escrevis' AP ID {verificaID(_input.LT(-1).getText());} FP SC;
cmdattrib   : ID {verificaID(_input.LT(-1).getText());} ATTR expr SC;

expr        : termo ( OP termo)*;
termo       : ID {verificaID(_input.LT(-1).getText());} | NUMBER;

VIR         : ',';
AP          : '(';
FP          : ')';
SC          : ';';
OP          : '+' | '-' | '*' | '/';
ATTR        : '=';
WS          : (' ' | '\t' | '\n' | '\r') -> skip;

ID          : [a-zA-Z] [a-zA-Z0-9]*;
NUMBER      : ('0'..'9')+ ('.' ('0'..'9')+)?;