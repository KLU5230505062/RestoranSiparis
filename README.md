# 🍽️ Restoran Sipariş Sistemi

Bu proje **Nesneye Yönelik Programlama (Java)** dersi için hazırlanmış basit bir **restoran sipariş sistemi** uygulamasıdır.  
Uygulama **Java Swing GUI** ile geliştirilmiştir.

---

## 🚀 Özellikler
- Menüde hazır ürünler bulunur (Çorba, Kebap, Pizza, Kola, Tatlı).
- Kullanıcı:
  - **Yeni Sipariş** başlatabilir.
  - Menüden ürün seçip **siparişe ekleyebilir**.
  - Siparişten ürün **silebilir**.
  - Tüm siparişleri ve **toplam fiyatlarını görebilir**.
  - Menüye yeni ürün ekleyebilir (ad + fiyat).
- **Çıkış butonu** ile program sonlandırılır.

---

## 📂 Proje Yapısı
- MenuItem.java → Menüdeki ürünleri tanımlar (id, ad, fiyat).
- Order.java → Bir siparişi ve içindeki ürünleri tutar.
- RestaurantSystem.java → Restoran menüsünü ve sipariş listesini yönetir.
- RestaurantGUI.java → Kullanıcı arayüzünü içerir (butonlar, listeler, çıktı alanı).

---

## 🖥️ Ekran Görünümü
GUI açıldığında:
- **Sol tarafta** menü listesi,
- **Sağ tarafta** sipariş listesi,
- **Üstte** işlem butonları,
- **Altta** bilgi/çıktı alanı bulunur.

---

## ⚙️ Çalıştırma
1. IntelliJ IDEA veya başka bir IDE’de projeyi açın.  
2. RestaurantGUI.java dosyasını çalıştırın.  
3. Arayüz üzerinden işlemleri yapabilirsiniz.  

---

## 📝 Not
- Kod nesneye yönelik programlama ilkeleri (sınıflar, nesneler, listeler) kullanılarak yazılmıştır.  
- Uygulama temel bir restoran otomasyonu mantığını göstermektedir.  
