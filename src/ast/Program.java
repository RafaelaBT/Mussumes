package ast;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

import datastructures.Symbol;
import datastructures.SymbolTable;
import datastructures.Variable;

public class Program {
    private SymbolTable symbolTable;
    private ArrayList<AbstractCommand> commands;
    private String programName = "MussumProgram";

    public void generateTarget() {
        StringBuilder sb = new StringBuilder();
        sb.append("import java.util.*;\n");
        sb.append("public class ").append(programName).append(" {\n");
        sb.append("  private static final Scanner _keyb = new Scanner(System.in);\n");
        sb.append("  public static void main(String[] args) throws Exception {\n");

        // declarações por tipo
        if (symbolTable != null) {
            String ints   = joinNamesByType(Variable.INT);
            String floats = joinNamesByType(Variable.FLOAT);
            String texts  = joinNamesByType(Variable.TEXT);
            String bools  = joinNamesByType(Variable.BOOLEAN);

            if (!ints.isEmpty())   sb.append("    int ").append(ints).append(";\n");
            if (!floats.isEmpty()) sb.append("    float ").append(floats).append(";\n");
            if (!texts.isEmpty())  sb.append("    String ").append(texts).append(";\n");
            if (!bools.isEmpty())  sb.append("    boolean ").append(bools).append(";\n");
        }

        // corpo
        if (commands != null) {
            for (AbstractCommand c : commands) {
                String line = c.generateJavaCode();
                if (line != null && !line.isBlank()) {
                    sb.append("    ").append(line).append("\n");
                }
            }
        }

        sb.append("  }\n");
        sb.append("}\n");

        try {
            Path out = Paths.get(programName + ".java");
            Files.writeString(out, sb.toString());
            System.out.println("Arquivo gerado: " + out.toAbsolutePath());
        } catch (Exception e) {
            throw new RuntimeException("Falha ao gravar código gerado", e);
        }
    }

    private String joinNamesByType(int type) {
        if (symbolTable == null) return "";
        java.util.List<String> names = new java.util.ArrayList<>();
        for (Symbol s : symbolTable.allSymbols()) {
            if (s instanceof Variable) {
                Variable v = (Variable) s;
                if (v.getType() == type) names.add(v.getName());
            }
        }
        return String.join(", ", names);
    }

    public SymbolTable getSymbolTable() { return symbolTable; }
    public void setSymbolTable(SymbolTable symbolTable) { this.symbolTable = symbolTable; }
    public ArrayList<AbstractCommand> getCommands() { return commands; }
    public void setCommands(ArrayList<AbstractCommand> commands) { this.commands = commands; }
    public String getProgramName() { return programName; }
    public void setProgramName(String programName) { this.programName = programName; }
}
