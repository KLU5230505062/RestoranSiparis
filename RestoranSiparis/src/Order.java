import java.util.ArrayList;

public class Order {
    private int orderId;
    private ArrayList<MenuItem> items = new ArrayList<>();

    public Order(int orderId){
        this.orderId = orderId;
    }

    public int getOrderId(){ return orderId; }

    public void addItem(MenuItem m){
        items.add(m);
    }

    public void removeItemByIndex(int index){
        if(index >= 0 && index < items.size()){
            items.remove(index);
        }
    }

    public ArrayList<MenuItem> getItems(){
        return items;
    }

    public double total(){
        double sum = 0;
        for(MenuItem m : items){
            sum += m.getPrice();
        }
        return sum;
    }
}
