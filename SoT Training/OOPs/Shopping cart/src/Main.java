import java.util.Optional;

public class Main {
    public static void main(String[] args) {
        ShoppingCart cart=new ShoppingCart();

        Product book= Catalogue.getProduct("book");
        Product pen= Catalogue.getProduct("pen");
        Product subscription= Catalogue.getProduct("subscription");

        cart.addLineItem(new LineItem(book,1));
        cart.addLineItem(new LineItem(pen,2));
        cart.addLineItem(new LineItem(subscription,1));
        System.out.println(cart);
        System.out.println(cart.getTotalCost());

        Customer johnDoe = new Customer("John Doe", 5420793615183044L);
        Optional<Order> order = johnDoe.checkout(cart);
        System.out.println(order);
    }
}