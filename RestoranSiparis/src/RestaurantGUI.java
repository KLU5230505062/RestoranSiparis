import javax.swing.*;
import java.awt.*;

public class RestaurantGUI extends JFrame {
    private RestaurantSystem rs = new RestaurantSystem();
    private Order currentOrder;

    private JTextArea cikti;
    private JList<String> menuList;
    private JList<String> orderList;
    private DefaultListModel<String> menuModel;
    private DefaultListModel<String> orderModel;

    public RestaurantGUI() {
        setTitle("Restoran Sipariş Sistemi");
        setSize(700,500);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Menü listesi
        menuModel = new DefaultListModel<>();
        for(MenuItem m : rs.getMenu()){
            menuModel.addElement(m.toString());
        }
        menuList = new JList<>(menuModel);

        // Sipariş listesi
        orderModel = new DefaultListModel<>();
        orderList = new JList<>(orderModel);

        JPanel centerPanel = new JPanel(new GridLayout(1,2));
        centerPanel.add(new JScrollPane(menuList));   // solda menü
        centerPanel.add(new JScrollPane(orderList));  // sağda sipariş
        add(centerPanel, BorderLayout.CENTER);

        // Çıktı alanı
        cikti = new JTextArea();
        cikti.setEditable(false);
        add(new JScrollPane(cikti), BorderLayout.SOUTH);

        // Butonlar
        JPanel panel = new JPanel();
        JButton btnYeni = new JButton("Yeni Sipariş");
        JButton btnEkle = new JButton("Ürün Ekle");
        JButton btnSil = new JButton("Ürün Sil");
        JButton btnGoster = new JButton("Siparişleri Göster");
        JButton btnMenuEkle = new JButton("Menüye Ürün");
        JButton btnCikis = new JButton("Çıkış");

        panel.add(btnYeni);
        panel.add(btnEkle);
        panel.add(btnSil);
        panel.add(btnGoster);
        panel.add(btnMenuEkle);
        panel.add(btnCikis);
        add(panel, BorderLayout.NORTH);

        // === Buton olayları ===

        // Yeni sipariş
        btnYeni.addActionListener(e -> {
            currentOrder = rs.createOrder();
            orderModel.clear();
            cikti.setText("Yeni sipariş oluşturuldu: #" + currentOrder.getOrderId() + "\n");
        });

        // Ürün ekle
        btnEkle.addActionListener(e -> {
            if(currentOrder == null){
                cikti.setText("Önce sipariş oluştur!\n");
            } else {
                int secilen = menuList.getSelectedIndex();
                if(secilen == -1){
                    cikti.setText("Menüden ürün seç!\n");
                } else {
                    MenuItem m = rs.getMenu().get(secilen);
                    currentOrder.addItem(m);
                    orderModel.addElement(m.toString());
                    cikti.append("Eklendi: " + m.getName() + "\n");
                }
            }
        });

        // Ürün sil
        btnSil.addActionListener(e -> {
            if(currentOrder == null){
                cikti.setText("Önce sipariş oluştur!\n");
                return;
            }
            int secilen = orderList.getSelectedIndex();
            if(secilen != -1){
                String satir = orderModel.get(secilen);
                orderModel.remove(secilen);
                currentOrder.removeItemByIndex(secilen);
                cikti.append("Silindi: " + satir + "\n");
            } else {
                cikti.setText("Siparişten ürün seç!\n");
            }
        });

        // Siparişleri göster
        btnGoster.addActionListener(e -> {
            cikti.setText("");
            if(rs.getOrders().isEmpty()){
                cikti.setText("Henüz sipariş yok!\n");
                return;
            }
            for(Order o : rs.getOrders()){
                cikti.append("=== Sipariş #" + o.getOrderId() + " ===\n");
                if(o.getItems().isEmpty()){
                    cikti.append("Bu sipariş boş.\n\n");
                } else {
                    for(MenuItem m : o.getItems()){
                        cikti.append(" - " + m.getName() + " " + m.getPrice() + " TL\n");
                    }
                    cikti.append("Toplam: " + o.total() + " TL\n\n");
                }
            }
        });

        // Menüye ürün ekle
        btnMenuEkle.addActionListener(e -> {
            String ad = JOptionPane.showInputDialog("Ürün adı:");
            String fiyatStr = JOptionPane.showInputDialog("Fiyat:");
            if(ad != null && fiyatStr != null){
                try {
                    double fiyat = Double.parseDouble(fiyatStr);
                    int id = rs.getMenu().size()+1;
                    MenuItem yeni = new MenuItem(id, ad, fiyat);
                    rs.getMenu().add(yeni);
                    menuModel.addElement(yeni.toString());
                    cikti.setText("Menüye eklendi: " + ad + "\n");
                } catch(Exception ex){
                    cikti.setText("Hatalı fiyat girdin!\n");
                }
            }
        });

        // Çıkış
        btnCikis.addActionListener(e -> System.exit(0));
    }

    public static void main(String[] args) {
        new RestaurantGUI().setVisible(true);
    }
}
