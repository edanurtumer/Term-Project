package com.example.edatumer.kitapdnyas;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

//KULLANICI_SIFRE
public class Veritabanı extends SQLiteOpenHelper {

    private static final String TABLE_NAME = "KISILER"; //Tablo Adı
    private static final String DATABASE_NAME = "GIRIS";  //Veritabanı Adı
    private static final int DATABASE_VERSION = 1;
    private static final String KULLANICI_AD = "Ad";
    private static final String KULLANICI_SOYAD = "Soyad";
    private static final String KULLANICI_MAIL = "Mail";
    private static final String KULLANICI_SIFRE = "Sifre";
    private static final String KULLANICI_YETKI = "Yetki";
    private SQLiteOpenHelper dbHelper;
    private SQLiteOpenHelper v1;

    public Veritabanı(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    ; //Kurucu metot ile veritabanımızı oluşturduk.
    SQLiteDatabase sqLiteDatabase;

    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL("CREATE TABLE " + TABLE_NAME + " (id INTEGER PRIMARY KEY AUTOINCREMENT," + KULLANICI_AD + " TEXT," + KULLANICI_SOYAD + " TEXT," + KULLANICI_MAIL + " TEXT," + KULLANICI_SIFRE + " TEXT," + KULLANICI_YETKI + " TEXT);"); //Burada çalışma anında veritabanımızın içine tabloyu oluşturduk ve değerleri belirledik.
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE İF EXİST " + TABLE_NAME);
        this.onCreate(db);//onCreate fonksiyonu çağrılarak oluşturduğumuz veritabanı tablosunda güncelleme yaptık.
    }

    public void veriEkle(String ad, String soyad, String mail, String sifre,String yetki) {
        SQLiteDatabase db = this.getWritableDatabase();//SQLiteDatabase sınıfında yazılabilir bağlantı açıyoruz.
        ContentValues cv = new ContentValues();//contentValues sınıfından bir nesne oluşturuyoruz.ContentValues değerleri tutmamızı sağlıyor.
        cv.put(KULLANICI_AD, ad.trim());//Ad alıyoruz.
        cv.put(KULLANICI_SOYAD, soyad.trim());//Soyad alıyoruz.
        cv.put(KULLANICI_MAIL, mail.trim());//mail alıyoruz.
        cv.put(KULLANICI_SIFRE, sifre.trim());//sifre alıyoruz.
        cv.put(KULLANICI_YETKI, yetki.trim());//yönetici mi çalışan mı onu alıyoruz.
        long r = db.insert(TABLE_NAME, null, cv);//Tabloya ekleme yaptığımız fonksiyon.
        if (r > -1)
            Log.i("tag", "İşlem Başarılı");//ekleme olması durumunda bu çıktıyı verir.
        else
            Log.e("tag", "İşlem Başarısız");//ekleme olmaması durumunda bu çıktıyı verir.
        db.close();//Veritabanı kapatma işlemi
    }

    public void veriSil(String mail) {
        SQLiteDatabase db = this.getWritableDatabase();//SQLiteDatabase sınıfında yazılabilir bağlantı açıyoruz.
        db.delete(TABLE_NAME, KULLANICI_MAIL + "=?", new String[]{String.valueOf(mail)});//personel maili girilerek veri silme işlemi yapıyoruz.
        db.close();//veritabanı kapatma işlemi
    }

    public List<String> veriListele() {
        List<String> veriler = new ArrayList<String>();//String türünde bir liste oluşturduk.
        SQLiteDatabase db = this.getWritableDatabase();//SQLiteDatabase sınıfında yazılabilir bağlantı açıyoruz.
        String[] sutunlar = {KULLANICI_AD, KULLANICI_SOYAD, KULLANICI_MAIL, KULLANICI_SIFRE,KULLANICI_YETKI};
        Cursor cr = db.query(TABLE_NAME, sutunlar, null, null, null, null, null);//query fonksiyonu ile aldığımız parametreler yoluyla komutu kendi içerisinde yapılandırıyoruz.
        while (cr.moveToNext()) {//sırasıyla verileri listelememizi sağlıyor.
            veriler.add("AD/SOYAD :"+cr.getString(0) + "    " + cr.getString(1) + "\nMAIL : " + cr.getString(2) + "\nŞİFRE : " + cr.getString(3)+ "\nDURUM :" + cr.getString(4));
            //if(cr.getString(2)==mail & cr.getString(3)==sifre) return 1;
        }
        return veriler;
    }


    public String verim(String mail,String sifre) {
        int i=0;
        String[] kolonlar = {"ad","soyad","mail", "sifre","yetki"};
        String [] ekle = new String[30];

        SQLiteDatabase db = this.getWritableDatabase();//SQLiteDatabase sınıfında yazılabilir bağlantı açıyoruz.
        Cursor c = db.query(TABLE_NAME, kolonlar, null, null, null, null, null);
        c.moveToFirst();
        String sifre1 ="";
        String mail1="";
        String yetki="";

        do {
            mail1 = c.getString(2);
            sifre1 = c.getString(3);
            yetki = c.getString(4);
            if (sifre1.equals(sifre) & mail1.equals(mail)) {
                return yetki;
            }

        }while(c.moveToNext());
        return "yetkisiz";
    }
}

