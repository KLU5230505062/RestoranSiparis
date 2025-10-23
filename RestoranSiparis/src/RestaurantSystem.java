import java.util.ArrayList;

public class RestaurantSystem {
    private ArrayList<MenuItem> menu = new ArrayList<>();
    private ArrayList<Order> orders = new ArrayList<>();
    private int nextOrderId = 1;

    public RestaurantSystem(){
        // Menüye ürünleri ekleyelim (fiyatları yüksek yaptık)
        menu.add(new MenuItem(1, "Çorba", 80));
        menu.add(new MenuItem(2, "Kebap", 250));
        menu.add(new MenuItem(3, "Pizza", 320));
        menu.add(new MenuItem(4, "Kola", 60));
        menu.add(new MenuItem(5, "Tatlı", 150));
    }

    public ArrayList<MenuItem> getMenu(){ return menu; }
    public ArrayList<Order> getOrders(){ return orders; }

    public Order createOrder(){
        Order o = new Order(nextOrderId++);
        orders.add(o);
        return o;
    }
}
