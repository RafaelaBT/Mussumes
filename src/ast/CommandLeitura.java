package ast;

public class CommandLeitura extends AbstractCommand {
    private final String id;

    public CommandLeitura(String id) {
        this.id = id;
    }

    @Override
    public String generateJavaCode() {
        // Usa um Scanner compartilhado chamado _keyb (criado no Program.generateTarget)
        return id + " = _keyb.nextLine();";
    }
}