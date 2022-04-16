3. SINIF BAHAR DÖNEMÝ
BÝLÝÞÝM TEKNOLOJÝLERÝ UYGULAMASI PROJE RAPORU
DÖNEM ÝÇÝ YAPILAN ÇALIÞMALARIN ÖZETÝ

          Android Studio uygulamasýnýn en yeni sürümü olan 3.4.1 sürümünü indirildi. Türkçe karakter hatasý verdiði için proje yapým aþamasýnda sorun yaþamamak için bu sürümü silip 3.2.0 sürümünü yeniden indirildi. Android Studio ile ilgili bilmem gereken þeylerle ilgili kýsa bir konu tekrarý yapýldý. Zaten proje yapým aþamasýnda detaylý bir þekilde öðrenildi. Veri tabaný ile de ilgilenmem gerekeceði için ayrý bir program kurmam gerekiyor mu diye araþtýrýlma yapýldý. Programýn içinde veri tabaný baðlantýsý yapýlabiliyormuþ. Bu benim için büyük bir kolaylýk saðladý. Araþtýrmalar tamamladýktan sonra proje yapým aþamasýna geçildi.
          Ýlk olarak yaptýðým proje de sürekli hata alýndý ve yöntem deðiþtirildi. Ücretsiz olan firebase’i kullanmaya karar verildi. Yaptýðým projeye en baþýndan tekrar baþlanýldý. Biraz ilerleme kaydettikten sonra uzun bir süre bu projemde de hata almaya devam edince ilk denenen proje tekrar geçildi. Yapýlan proje 3 aþamadan oluþuyor: Veri tabaný, sayfalar arasý geçiþ ve sayfa düzenlemeleri. Veritabani adýnda bir java class oluþturuldu. Bu classta kiþi ekleme, silme, listeleme ve üye kontrol iþlemleri yapýldý. MainActivity.java kýsmýndan, Veritabani.java kýsmýna baðlantý oluþturuldu. Mail ve þifreyi String’e çevirip Veritabani’ndaki verim fonksiyonuna gönderildi. Yonetici ve Kullanici adýnda 2 tane Empty Class oluþturuldu. MainActivity.java’nýn, activitiy_main.xml kýsmýnda 2 tane textView, 2 tane editText ve 1 tane button oluþturuldu. MainActivity.java kýsmýndan girilen mail ve þifre yöneticiye 

ait ise Yonetici.java, kullanýcýya ait ise Kullanici.java’ya yönlendirildi. KitapVeritabani adýnda bir java class oluþturuldu. Yonetici.java’nýn activity_yonetici.xml kýsmýnda 3 tane editText, 3 tane textView, 1 tane Button ve 1 tane kitaplar adýnda ListView oluþturuldu. Yonetici.java’da yöneticinin kaydettiði kitaplar KitapVeritabani’na kaydedildi. Kaydettiðim kitaplarý görebilmek için de ListView’i eklenildi. Bu sayede kaydedilen kitaplarýn hepsi bu sayfada sýralandý. Kullanici.java kýsmýnýn, activity_kullanici.xml kýsmýnda ise 3 tane textView, 2 tane editText ve 1 tane Button oluþturuldu. Kullanici.java kýsmýnda kullanýcý kitap adý veya yazar adý ile arama yapýldý. Kitap varsa eðer kitap ile birlikte alt kýsmýnda yorumlar gözükecek. Kitap yoksa eðer ekrana ‘Böyle bir kitap bulunmadý!’ yazýsý bastýrýldý. Kullanici.java sayfasýndan arama yapýldýðýnda KitapVeritabani.java sayfasýna yönlendirildi. Kitap bulunduysa eðer kullanýcý yorum yapabilmesi için direk YorumSayfasi.java kýsmýna yönlendirildi. activity_yorumsayfasi.xml’de 2 tane textView, 1 tane editText, 1 tane ListView ve 1 tane de Button kullanýldý. YorumVeritabani.java oluþturuldu. Kitap adý ve yorum YorumVeritabani’nda tutuldu.
          Böylece projenin büyük bir kýsmý tamamlanmýþ oldu. Eksikleri olduðu halde projeden büyük verim alýndý.



            
          Mail adresi veya þifre eksik ya da yanlýþ girildiðinde ekranda kiþinin görmesi için böyle bir yazý bastýrýldý.
              
          MainActivity.java ile baðlantý kurduðumuz Veritabani.java’nýn mail ve þifre giriþi ile yönetici giriþi olduðu için Yonetici.java sayfasýna yönlendirildi. Yönlendirilmede Yonetici.java sayfasý açýlacak ve orada yönetici kitap adý, yazarý ve sayfa sayýsýný sisteme kaydetti. Kaydedilen kitaplar liste þeklinde sayfanýn altý kýsmýnda sýrayla çýkarýldý.
               Yonetici.java sayfasýdýr. Ekleme ve listelenmiþ hali gösterildi.
                

          MainActivity.java’nýn Veritabani.java ile kurduðu baðlantýda kullanýcý giriþ yaptýðý için Kullanici.java sayfasýna yönlendirildi. Burada kullanýcýn aradýðý kitap var mý yok mu kontrol edildi.

                                               
PROJENÝN AMACI ve ÖNEMÝ

Projenin Amacý: Geliþen teknolojide insanlarýn kitaplar hakkýnda daha hýzlý bir þekilde bilgiye ulaþmasý ve  uygulamaya giriþ yapmýþ kullanýcýlarýn yorumlar sayesinde insanlarýn o kitabý alýp almamak konusunda karar vermesini saðlamak amaçlanmýþtýr. Android tabanlý bu sistemde insanlara her zaman bu araþtýrmayý yapmakta zorlanmayacaklardýr.

Projenin Önemi: Bu proje sayesinde insanlar daha çabuk fikir sahibi olabilecek. Bazen kitaplarýn dýþýný beðenip aldýktan sonra okuyup piþmanlýk duyuyoruz. En azýndan kitabý almadan önce daha çok fikir sahibi olmak için, kitabý okumuþ olan insanlarýn yaptýðý yorumlara göz atarak o kitap hakkýnda kiþinin alýp almama konusundaki fikirlerini hýzlandýrmýþ oluyoruz. Daha çabuk karar vermiþ oluyorlar. Bu sayede okuyanlar hem fikirlerini beyan edip hem de okumak isteyenlere yardýmcý olmuþ oluyorlar. 
















