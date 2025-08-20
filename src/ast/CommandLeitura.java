package ast;

public class CommandLeitura extends AbstractCommand {
    private final String id;
    private final int type; // 0=int, 1=float, 2=text, 3=boolean

    public CommandLeitura(String id, int type) {
        this.id = id;
        this.type = type;
    }

    @Override
    public String generateJavaCode() {
        switch (type) {
            case datastructures.Variable.INT:
                return id + " = Integer.parseInt(_keyb.nextLine());";
            case datastructures.Variable.FLOAT:
                return id + " = Float.parseFloat(_keyb.nextLine());";
            case datastructures.Variable.BOOLEAN:
                return id + " = Boolean.parseBoolean(_keyb.nextLine());";
            case datastructures.Variable.TEXT:
            default:
                return id + " = _keyb.nextLine();";
        }
    }
}
