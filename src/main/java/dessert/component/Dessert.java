package dessert.component;

public interface Dessert {

    String getProductName();
    String setProductName(final String productName);

    default String eat() {
        return String.format("eating %s", this.getClass().getSimpleName().toLowerCase());
    }
}
