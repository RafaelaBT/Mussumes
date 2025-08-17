package exceptions;

/**
 * Classe que representa uma exceção semântica
 */
public class SemanticException extends RuntimeException{

    public SemanticException(String message) {
        super(message);
    }
}
