package com.example.edatumer.kitapdnyas;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

public class KitapVeritabanı extends SQLiteOpenHelper {

    private static final String TABLE_NAME = "KITAPLAR"; //Tablo Adı
    private static final String DATABASE_NAME = "KITAP";  //Veritabanı Adı
    private static final int DATABASE_VERSION = 1;
    private static final String KITAP_AD = "KitapAdi";
    private static final String KITAP_SAYFA_SAYISI = "SayfaSayisi";
    private static final String KITAP_YAZARI= "Yazari";
    private SQLiteOpenHelper dbHelper;
    private SQLiteOpenHelper v1;

    public KitapVeritabanı(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    ; //Kurucu metot ile veritabanımızı oluşturduk.
    SQLiteDatabase sqLiteDatabase;

    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL("CREATE TABLE " + TABLE_NAME + " (id INTEGER PRIMARY KEY AUTOINCREMENT," + KITAP_AD + " TEXT," + KITAP_SAYFA_SAYISI + " TEXT," + KITAP_YAZARI + " TEXT);"); //Burada çalışma anında veritabanımızın içine tabloyu oluşturduk ve değerleri belirledik.
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE İF EXİST " + TABLE_NAME);
        this.onCreate(db);//onCreate fonksiyonu çağrılarak oluşturduğumuz veritabanı tablosunda güncelleme yaptık.
    }

    public void veriEkle(String ad, String yazar, String sayfa) {
        SQLiteDatabase db = this.getWritableDatabase();//SQLiteDatabase sınıfında yazılabilir bağlantı açıyoruz.
        ContentValues cv = new ContentValues();//contentValues sınıfından bir nesne oluşturuyoruz.ContentValues değerleri tutmamızı sağlıyor.
        cv.put(KITAP_AD, ad.trim());//Ad alıyoruz.
        cv.put(KITAP_SAYFA_SAYISI , sayfa.trim());//mail alıyoruz.
        cv.put(KITAP_YAZARI, yazar.trim());//sifre alıyoruz.
        long r = db.insert(TABLE_NAME, null, cv);//Tabloya ekleme yaptığımız fonksiyon.
        if (r > -1)
            Log.i("tag", "İşlem Başarılı");//ekleme olması durumunda bu çıktıyı verir.
        else
            Log.e("tag", "İşlem Başarısız");//ekleme olmaması durumunda bu çıktıyı verir.
        db.close();//Veritabanı kapatma işlemi
    }

    public void veriSil(String ad) {
        SQLiteDatabase db = this.getWritableDatabase();//SQLiteDatabase sınıfında yazılabilir bağlantı açıyoruz.
        db.delete(TABLE_NAME, KITAP_AD + "=?", new String[]{String.valueOf(ad)});//personel maili girilerek veri silme işlemi yapıyoruz.
        db.close();//veritabanı kapatma işlemi
    }

    public List<String> veriListele() {
        List<String> veriler = new ArrayList<String>();//String türünde bir liste oluşturduk.
        SQLiteDatabase db = this.getWritableDatabase();//SQLiteDatabase sınıfında yazılabilir bağlantı açıyoruz.
        String[] sutunlar = {KITAP_AD, KITAP_YAZARI, KITAP_SAYFA_SAYISI};
        Cursor cr = db.query(TABLE_NAME, sutunlar, null, null, null, null, null);//query fonksiyonu ile aldığımız parametreler yoluyla komutu kendi içerisinde yapılandırıyoruz.
        while (cr.moveToNext()) {
            veriler.add("KITAP ADI: :"+cr.getString(0) + "\nKITABIN YAZARI :" + cr.getString(1) + "\nSAYFA SAYISI : " + cr.getString(2));

        }
        return veriler;
    }
    public String  Arama(String ad, String yazar){
        String[] kolonlar = {"kitapadı","sayfa","yazarad"};
        SQLiteDatabase db = this.getWritableDatabase();//SQLiteDatabase sınıfında yazılabilir bağlantı açıyoruz.
        Cursor c = db.query(TABLE_NAME, kolonlar, null, null, null, null, null);
        c.moveToFirst();
        String kitapadi1 ="";
        String yazarad1="";
        String sayfa1="";

        do {
            kitapadi1 = c.getString(0);
            sayfa1 = c.getString(1);
            yazarad1 = c.getString(2);

            if (kitapadi1.equals(ad) & yazarad1.equals(yazar)) {
                return sayfa1;
            }

        }while(c.moveToNext());



        return "yok";
    }



}

