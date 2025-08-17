package datastructures;

public class Variable extends Symbol{
    // Tipos de variável
    public static final int INT      = 0;
    public static final int FLOAT    = 1;
    public static final int TEXT     = 2;
    public static final int BOOLEAN  = 3;

    // Tipo da variável
    private int type;

    // Valor da variável
    private String value;

    /**
     * Construtor da classe Variable
     * @param name nome da variável
     * @param type tipo da variável
     * @param value valor da variável
     */
    public Variable(String name, int type, String value) {
        super(name);
        this.type = type;
        this.value = value;
    }

    /**
     * Método para obter o tipo da variável
     * @return tipo da variável
     */
    public int getType() {
        return type;
    }

    /**
     * Método para definir o tipo da variável
     * @param type tipo da variável
     */
    public void setType(int type) {
        this.type = type;
    }

    /**
     * Método para obter o valor da variável
     * @return valor da variável
     */
    public String getValue() {
        return value;
    }

    /**
     * Método para definir o valor da variável
     * @param value valor da variável
     */
    public void setValue(String value) {
        this.value = value;
    }

    /**
     * Método para obter a representação em string da variável
     * @return representação em string da variável
     */
    @Override
    public String toString() {
        return "Variable [name=" + name + ", type=" + type + ", value=" + value + "]";
    }

}
