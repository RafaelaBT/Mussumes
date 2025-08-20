package ast;

public class CommandEscrita extends AbstractCommand {
    private final String exprText;
    public CommandEscrita(String exprText) { this.exprText = exprText; }
    @Override public String generateJavaCode() { return "System.out.println(" + exprText + ");"; }
    @Override public String toString() { return "print(" + exprText + ")"; }
}