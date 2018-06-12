package dessert.component;


import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public abstract class AbstractDessert implements Dessert {

    private String productName;

    @Override
    public String getProductName() {
        return null;
    }

    @Override
    public String setProductName() {
        return null;
    }


}
