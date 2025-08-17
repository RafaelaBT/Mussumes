package datastructures;

/**
 * Classe que representa um símbolo na tabela de símbolos
 */
public class Symbol {
    // Nome do símbolo
    protected String name;

    /**
     * Construtor da classe Symbol
     * @param name
     */
    public Symbol(String name) {
        this.name = name;
    }

    /**
     * Método para obter o nome do símbolo
     * @return nome do símbolo
     */
    public String getName() {
        return name;
    }

    /**
     * Método para definir o nome do símbolo
     * @param name nome do símbolo
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Método para obter a representação em string do símbolo
     * @return representação em string do símbolo
     */
    @Override
    public String toString() {
        return "Symbol [name=" + name + "]";
    }
}
