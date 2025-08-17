package ast;

import java.util.ArrayList;

import datastructures.SymbolTable;

public class Program {
    private SymbolTable symbolTable;
	private ArrayList<AbstractCommand> commands;
	private String programName;

    public void generateTarget() {
    
    }

    public SymbolTable getSymbolTable() {
        return symbolTable;
    }
    public void setSymbolTable(SymbolTable symbolTable) {
        this.symbolTable = symbolTable;
    }
    public ArrayList<AbstractCommand> getCommands() {
        return commands;
    }
    public void setCommands(ArrayList<AbstractCommand> commands) {
        this.commands = commands;
    }
    public String getProgramName() {
        return programName;
    }
    public void setProgramName(String programName) {
        this.programName = programName;
    }

    
}
