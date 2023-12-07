import java.util.ArrayList;
import java.util.List;

public class ShoppingCart {
    private List<LineItem> lineItems=new ArrayList<>();
    public void addLineItem(LineItem lineItem) {lineItems.add(lineItem);}
        public int getTotalCost(){
        return lineItems.stream()
                .mapToInt(LineItem::getPrice)
                .sum();
    }

    @Override
    public String toString() {
        return "ShoppingCart{" +
                "lineItems=" + lineItems +
                '}';
    }


}
