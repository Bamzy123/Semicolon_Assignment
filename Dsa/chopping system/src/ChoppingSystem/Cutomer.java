package ChoppingSystem;

import java.util.ArrayList;
import java.util.List;

public class Cutomer extends User {
    private List<BillingInformation> billingInfos = new ArrayList<>();
    private ShoppingCart shoppingCart = new ShoppingCart();
}
