/**
 * My QueueUnderflowException
 * @author Joshua Schlesinger-Guevara
 */
public class QueueUnderflowException extends Exception {
    public QueueUnderflowException() {}
    public QueueUnderflowException(String message) {
        super(message);
    }
}
