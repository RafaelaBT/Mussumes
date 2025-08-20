package ast;

import java.util.ArrayList;
import java.util.List;

public class CommandDecisao extends AbstractCommand {
    private final String condition;
    private final List<AbstractCommand> trueList = new ArrayList<>();
    private final List<AbstractCommand> falseList = new ArrayList<>();

    public CommandDecisao(String condition) {
        this.condition = condition;
    }

    public void addTrueCommand(AbstractCommand cmd) {
        trueList.add(cmd);
    }

    public void addFalseCommand(AbstractCommand cmd) {
        falseList.add(cmd);
    }

    @Override
    public String generateJavaCode() {
        StringBuilder sb = new StringBuilder();
        sb.append("if (" + condition + ") {\n");
        for (AbstractCommand c : trueList) {
            sb.append(" ").append(c.generateJavaCode()).append("\n");
        }
        sb.append("}");
        if (!falseList.isEmpty()) {
            sb.append(" else {\n");
            for (AbstractCommand c : falseList) {
                sb.append(" ").append(c.generateJavaCode()).append("\n");
            }
            sb.append("}");
        }
        return sb.toString();
    }
}