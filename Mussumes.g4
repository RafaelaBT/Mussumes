grammar Mussumes;

prog        : 'iniciavis' bloco 'fimis' SC;
bloco       : (cmd)+;

cmd         : cmdleitura {System.out.println("Comandus levis usadus!");} 
            | cmdescrita {System.out.println("Comandus escrevis usadus!");} 
            | cmdattrib  {System.out.println("Comandus atributis (=) usadus!");} ;
cmdleitura  : 'levis' AP ID {System.out.println("ID="+_input.LT(-1).getText());} FP SC;
cmdescrita  : 'escrevis' AP ID FP SC;
cmdattrib   : ID ATTR expr SC;

expr        : termo ( OP termo)*;
termo       : ID | NUMBER;

AP          : '(';
FP          : ')';
SC          : ';';
OP          : '+' | '-' | '*' | '/';
ATTR        : '=';
WS          : (' ' | '\t' | '\n' | '\r') -> skip;

ID          : [a-zA-Z] [a-zA-Z0-9]*;
NUMBER      : ('0'..'9')+ ('.' ('0'..'9')+)?;