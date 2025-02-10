package ChoppingSystem;

import java.util.ArrayList;
import java.util.List;

public class Customer extends User {
    private List<BillingInformation> billingInfos = new ArrayList<>();
    private ShoppingCart shoppingCart = new ShoppingCart();
}