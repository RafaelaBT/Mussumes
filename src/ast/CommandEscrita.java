package ast;

public class CommandEscrita extends AbstractCommand {
    private final String expr;

    public CommandEscrita(String expr) {
        this.expr = expr;
    }

    @Override
    public String generateJavaCode() {
        return "System.out.println(" + expr + ");";
    }
}