import java.util.HashMap;
import java.util.Map;
public class Catalogue {

    public final static int SHIPPING_RATE = 5;
    private static Map<String, Product> productMap;

    static {
        productMap = new HashMap<>();
        productMap.put("book", new Product("book", 100, ProductType.PHYSICAL,50));
        productMap.put("pen", new Product("pen", 10, ProductType.PHYSICAL,10));
        productMap.put("subscription",new Product("subscription",500,ProductType.DIGITAL,0));
    }

    public static Product getProduct(String productName){
        return productMap.get(productName);
    }
}
