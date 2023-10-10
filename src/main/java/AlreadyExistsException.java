public class AlreadyExistsException extends RuntimeException {
    public AlreadyExistsException(int id) {
        super("Товара c id  " + id + "  уже существует");
    }
}
