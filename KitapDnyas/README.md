3. SINIF BAHAR D�NEM�
B�L���M TEKNOLOJ�LER� UYGULAMASI PROJE RAPORU
D�NEM ��� YAPILAN �ALI�MALARIN �ZET�

          Android Studio uygulamas�n�n en yeni s�r�m� olan 3.4.1 s�r�m�n� indirildi. T�rk�e karakter hatas� verdi�i i�in proje yap�m a�amas�nda sorun ya�amamak i�in bu s�r�m� silip 3.2.0 s�r�m�n� yeniden indirildi. Android Studio ile ilgili bilmem gereken �eylerle ilgili k�sa bir konu tekrar� yap�ld�. Zaten proje yap�m a�amas�nda detayl� bir �ekilde ��renildi. Veri taban� ile de ilgilenmem gerekece�i i�in ayr� bir program kurmam gerekiyor mu diye ara�t�r�lma yap�ld�. Program�n i�inde veri taban� ba�lant�s� yap�labiliyormu�. Bu benim i�in b�y�k bir kolayl�k sa�lad�. Ara�t�rmalar tamamlad�ktan sonra proje yap�m a�amas�na ge�ildi.
          �lk olarak yapt���m proje de s�rekli hata al�nd� ve y�ntem de�i�tirildi. �cretsiz olan firebase�i kullanmaya karar verildi. Yapt���m projeye en ba��ndan tekrar ba�lan�ld�. Biraz ilerleme kaydettikten sonra uzun bir s�re bu projemde de hata almaya devam edince ilk denenen proje tekrar ge�ildi. Yap�lan proje 3 a�amadan olu�uyor: Veri taban�, sayfalar aras� ge�i� ve sayfa d�zenlemeleri. Veritabani ad�nda bir java class olu�turuldu. Bu classta ki�i ekleme, silme, listeleme ve �ye kontrol i�lemleri yap�ld�. MainActivity.java k�sm�ndan, Veritabani.java k�sm�na ba�lant� olu�turuldu. Mail ve �ifreyi String�e �evirip Veritabani�ndaki verim fonksiyonuna g�nderildi. Yonetici ve Kullanici ad�nda 2 tane Empty Class olu�turuldu. MainActivity.java�n�n, activitiy_main.xml k�sm�nda 2 tane textView, 2 tane editText ve 1 tane button olu�turuldu. MainActivity.java k�sm�ndan girilen mail ve �ifre y�neticiye 

ait ise Yonetici.java, kullan�c�ya ait ise Kullanici.java�ya y�nlendirildi. KitapVeritabani ad�nda bir java class olu�turuldu. Yonetici.java�n�n activity_yonetici.xml k�sm�nda 3 tane editText, 3 tane textView, 1 tane Button ve 1 tane kitaplar ad�nda ListView olu�turuldu. Yonetici.java�da y�neticinin kaydetti�i kitaplar KitapVeritabani�na kaydedildi. Kaydetti�im kitaplar� g�rebilmek i�in de ListView�i eklenildi. Bu sayede kaydedilen kitaplar�n hepsi bu sayfada s�raland�. Kullanici.java k�sm�n�n, activity_kullanici.xml k�sm�nda ise 3 tane textView, 2 tane editText ve 1 tane Button olu�turuldu. Kullanici.java k�sm�nda kullan�c� kitap ad� veya yazar ad� ile arama yap�ld�. Kitap varsa e�er kitap ile birlikte alt k�sm�nda yorumlar g�z�kecek. Kitap yoksa e�er ekrana �B�yle bir kitap bulunmad�!� yaz�s� bast�r�ld�. Kullanici.java sayfas�ndan arama yap�ld���nda KitapVeritabani.java sayfas�na y�nlendirildi. Kitap bulunduysa e�er kullan�c� yorum yapabilmesi i�in direk YorumSayfasi.java k�sm�na y�nlendirildi. activity_yorumsayfasi.xml�de 2 tane textView, 1 tane editText, 1 tane ListView ve 1 tane de Button kullan�ld�. YorumVeritabani.java olu�turuldu. Kitap ad� ve yorum YorumVeritabani�nda tutuldu.
          B�ylece projenin b�y�k bir k�sm� tamamlanm�� oldu. Eksikleri oldu�u halde projeden b�y�k verim al�nd�.



            
          Mail adresi veya �ifre eksik ya da yanl�� girildi�inde ekranda ki�inin g�rmesi i�in b�yle bir yaz� bast�r�ld�.
              
          MainActivity.java ile ba�lant� kurdu�umuz Veritabani.java�n�n mail ve �ifre giri�i ile y�netici giri�i oldu�u i�in Yonetici.java sayfas�na y�nlendirildi. Y�nlendirilmede Yonetici.java sayfas� a��lacak ve orada y�netici kitap ad�, yazar� ve sayfa say�s�n� sisteme kaydetti. Kaydedilen kitaplar liste �eklinde sayfan�n alt� k�sm�nda s�rayla ��kar�ld�.
               Yonetici.java sayfas�d�r. Ekleme ve listelenmi� hali g�sterildi.
                

          MainActivity.java�n�n Veritabani.java ile kurdu�u ba�lant�da kullan�c� giri� yapt��� i�in Kullanici.java sayfas�na y�nlendirildi. Burada kullan�c�n arad��� kitap var m� yok mu kontrol edildi.

                                               
PROJEN�N AMACI ve �NEM�

Projenin Amac�: Geli�en teknolojide insanlar�n kitaplar hakk�nda daha h�zl� bir �ekilde bilgiye ula�mas� ve  uygulamaya giri� yapm�� kullan�c�lar�n yorumlar sayesinde insanlar�n o kitab� al�p almamak konusunda karar vermesini sa�lamak ama�lanm��t�r. Android tabanl� bu sistemde insanlara her zaman bu ara�t�rmay� yapmakta zorlanmayacaklard�r.

Projenin �nemi: Bu proje sayesinde insanlar daha �abuk fikir sahibi olabilecek. Bazen kitaplar�n d���n� be�enip ald�ktan sonra okuyup pi�manl�k duyuyoruz. En az�ndan kitab� almadan �nce daha �ok fikir sahibi olmak i�in, kitab� okumu� olan insanlar�n yapt��� yorumlara g�z atarak o kitap hakk�nda ki�inin al�p almama konusundaki fikirlerini h�zland�rm�� oluyoruz. Daha �abuk karar vermi� oluyorlar. Bu sayede okuyanlar hem fikirlerini beyan edip hem de okumak isteyenlere yard�mc� olmu� oluyorlar. 
















