import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ShopRepositoryTest {
    @Test
    public void deletingProduct() {
        ShopRepository repository = new ShopRepository();
        Product product1 = new Product(14, "молоко", 80);
        Product product2 = new Product(80, "джинсы", 2_500);
        Product product3 = new Product(35, "колбаса", 850);

        repository.add(product1);
        repository.add(product2);
        repository.add(product3);
        repository.remove(35);

        Product[] actual = repository.findAll();
        Product[] expected = {product1, product2};

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void deletingNotExistingProduct() {
        ShopRepository repository = new ShopRepository();
        Product product1 = new Product(14, "молоко", 80);
        Product product2 = new Product(80, "джинсы", 2_500);
        Product product3 = new Product(35, "колбаса", 850);

        repository.add(product1);
        repository.add(product2);
        repository.add(product3);

        Assertions.assertThrows(NotFoundException.class, () -> repository.remove(103));
    }

    @Test
    public void addendumRepeatProduct() {
        ShopRepository repository = new ShopRepository();
        Product product1 = new Product(14, "молоко", 80);
        Product product2 = new Product(60, "джинсы", 2_500);
        Product product3 = new Product(35, "колбаса", 850);
        Product product4 = new Product(35, "мясо", 250);

        repository.add(product1);
        repository.add(product2);
        repository.add(product3);

        Assertions.assertThrows(AlreadyExistsException.class, () -> repository.add(product4));
    }

    @Test
    public void addendumProduct() {
        ShopRepository repository = new ShopRepository();
        Product product1 = new Product(14, "молоко", 80);
        Product product2 = new Product(60, "джинсы", 2_500);
        Product product3 = new Product(35, "колбаса", 850);
        Product product4 = new Product(45, "мясо", 250);

        repository.add(product1);
        repository.add(product2);
        repository.add(product3);
        repository.add(product4);

        Product[] actual = repository.findAll();
        Product[] expected = {product1, product2, product3, product4};

        Assertions.assertArrayEquals(expected, actual);
    }
}
