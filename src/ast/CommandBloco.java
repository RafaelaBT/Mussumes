package ast;

import java.util.ArrayList;
import java.util.List;

public class CommandBloco extends AbstractCommand {
    private final List<AbstractCommand> commands = new ArrayList<>();

    public void add(AbstractCommand cmd) {
        commands.add(cmd);
    }

    public List<AbstractCommand> getCommands() {
        return commands;
    }

    @Override
    public String generateJavaCode() {
        StringBuilder sb = new StringBuilder();
        for (AbstractCommand c : commands) {
            sb.append(c.generateJavaCode()).append("\n");
        }
        return sb.toString();
    }
}