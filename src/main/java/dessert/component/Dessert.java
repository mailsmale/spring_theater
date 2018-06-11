package dessert.component;

public interface Dessert {

    boolean inStock = false;

    default String eat(){
        return String.format("eating %s", this.getClass().getSimpleName().toLowerCase());
    }
}
