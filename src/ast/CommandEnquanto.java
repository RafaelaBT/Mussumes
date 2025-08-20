package ast;

import java.util.ArrayList;
import java.util.List;

public class CommandEnquanto extends AbstractCommand {
    private final String condition;
    private final List<AbstractCommand> body = new ArrayList<>();

    public CommandEnquanto(String condition) {
        this.condition = condition;
    }

    public void addCommand(AbstractCommand cmd) {
        body.add(cmd);
    }

    @Override
    public String generateJavaCode() {
        StringBuilder sb = new StringBuilder();
        sb.append("while (" + condition + ") {\n");
        for (AbstractCommand c : body) {
            sb.append(" ").append(c.generateJavaCode()).append("\n");
        }
        sb.append("}");
        return sb.toString();
    }
}