# 🍭 CandyReport BungeeCord
Minecraft BungeeCord proxy'niz için CandyReport sunucular arası bildirim sistemi.

---
Bu plugin sadece proxy'ler arası yetkililere rapor bildirimlerini göndermek için vardır. **BU RAPOR PLUGINI DEĞİLDİR**
[Bkz. CandyReport](https://github.com/HeliosAy/CandyReport)
## ✨ Özellikler

### 🎯 Temel Özellikler
- Cross-server notifications - Sunucular arası rapor bildirimleri
- Plugin message forwarding - Otomatik mesaj yönlendirme
- Zero configuration - Kurulum sonrası otomatik çalışır
- No database needed - Sadece mesaj yönlendirme

---

## 📦 Kurulum

1. **Ana CandyReport'u yükleyin** - Önce [CandyReport](https://github.com/HeliosAy/CandyReport)'u tüm Spigot sunucularınıza yükleyin
2. Plugin dosyasını BungeeCord `plugins/` klasörüne koyun
3. BungeeCord'u yeniden başlatın
4. Spigot sunucularınızda `config.yml` içinde `bungeecord.enabled: true` yapın
5. Tüm sunucuları yeniden başlatın

---

## ⚙️ Yapılandırma

### Yapılandırma Gerekmez!
Bu plugin otomatik olarak çalışır ve herhangi bir yapılandırma dosyası gerektirmez.


### Spigot [CandyReport Plugin](https://github.com/HeliosAy/CandyReport) Sunucu Ayarları
Her Spigot sunucunuzda CandyReport `config.yml`:

```yaml
# config.yml (Spigot sunucularında)
bungeecord:
  enabled: true  # Bu önemli!

server-name: "Survival"  # Her sunucu için farklı isim

# Diğer ayarlar aynı MySQL veritabanını göstermeli
database:
  host: "localhost"
  port: 3306
  name: "candyreport"
  username: "root"
  password: ""
  ssl: false
```
---

## ⚠️ Dikkat Edilmesi Gerekenler

### ✅ Doğru Kullanımlar
- Önce ana CandyReport pluginini tüm Spigot sunucularına yükleyin
- Tüm sunucularda aynı MySQL veritabanını kullanın
- Her sunucuya farklı `server-name` verin

### ❌ Yanlış Kullanımlar
- Sadece BungeeCord pluginini yüklemek (ana plugin gerekli!)
- Farklı MySQL veritabanları kullanmak
- Spigot config.yml dosyasından BungeeCord ayarını açmayı unutmak
- Aynı sunucu ismini birden fazla sunucuda kullanmak (Önerilmez)

---

### Nasıl Çalışır?

1. **Oyuncu rapor oluşturur** (Sunucu A'da)
2. **CandyReport mesaj gönderir** (BungeeCord'a)
3. **Bu plugin mesajı yakalar** ve tüm sunuculara yönlendirir
4. **Tüm sunuculardaki yetkililer** bildirim alır

### Network Topology
```
Oyuncu HeliosAy Raporlandı
       ↓
   Spigot A ────────► BungeeCord Proxy ────────► Diğer Tüm Sunucular
       ↓                                              ↓
   Yetkili A                                    Yetkili B,C,D...
   (Local Server Bildirim)                                      (All-Servers)
```

---

## 🔧 Hata Giderimi

### Bildirimler Gelmiyorsa
- BungeeCord loglarını kontrol edin
- Spigot sunucularında `bungeecord.enabled: true` olduğundan emin olun
- Tüm sunucuların aynı MySQL veritabanını kullandığını kontrol edin

### Plugin Çalışmıyorsa
- Ana CandyReport plugininin yüklü olup olmadığını kontrol edin
- Server loglarında hata mesajları olup olmadığına bakın

---

## 📄 Lisans

Bu proje MIT lisansı altında lisanslanmıştır.

---

## 🔗 İlgili Linkler

- **Ana Plugin**: [CandyReport](https://github.com/HeliosAy/CandyReport)
- **CandyReportBungee | Hatalar**: [GitHub Issues](https://github.com/HeliosAy/CandyReportBungee/issues)

---

🙏 Teşekkürler

---

*Not: Bu plugin sadece ana CandyReport ile birlikte çalışır ve sunucular arası iletişim için tasarlanmıştır...*