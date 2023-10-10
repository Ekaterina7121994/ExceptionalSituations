public class NotFoundException extends RuntimeException {
    public NotFoundException(int id) {
        super("Товара c id  " + id + "  не найдено");
    }
}


