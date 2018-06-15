package dessert.component;


import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

@NoArgsConstructor
@Setter
@Getter
public abstract class AbstractDessert implements Dessert {

    private String productName;

    public AbstractDessert(final String productName){
        this.productName = productName;
    }

    @Override
    public String getProductName() {
        return productName;
    }

    @Override
    public String setProductName(final String productName) {
        this.productName = productName;
        return productName;
    }


}
