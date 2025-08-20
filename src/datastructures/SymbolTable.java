package datastructures;

import java.util.HashMap;

/**
 * Classe que representa uma tabela de símbolos
 */
public class SymbolTable {
    // Mapa que armazena os símbolos
    private HashMap<String, Symbol> map;

    /**
     * Construtor da classe SymbolTable
     */
    public SymbolTable() {
        this.map = new HashMap<String, Symbol>();
    }
    
    public java.util.Collection<Symbol> allSymbols() {
        return map.values();
    }

    /**
     * Método para adicionar um símbolo à tabela de símbolos
     * @param symbol símbolo a ser adicionado
     */
    public void add(Symbol symbol) {
        map.put(symbol.getName(), symbol);
    }

    /**
     * Método para verificar se um símbolo existe na tabela de símbolos
     * @param symbolName nome do símbolo a ser verificado
     * @return true se o símbolo existir, false caso contrário
     */
    public boolean exists(String symbolName) {
        return map.get(symbolName) != null;
    }

    /**
     * Método para obter um símbolo da tabela de símbolos
     * @param symbolName nome do símbolo a ser obtido
     * @return o símbolo correspondente, ou null se não existir
     */
    public Symbol get(String symbolName) {
        return map.get(symbolName);
    }
}
