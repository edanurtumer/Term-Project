package com.example.edatumer.kitapdnyas;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

public class YorumVeritabanı extends SQLiteOpenHelper {
    private static final String TABLE_NAME = "YORUMLAR"; //Tablo Adı
    private static final String DATABASE_NAME = "YORUM";  //Veritabanı Adı
    private static final int DATABASE_VERSION = 1;
    private static final String KITAP_AD = "KitapAdi";
    private static final String YORUM= "Yorum";
    private SQLiteOpenHelper dbHelper;
    private SQLiteOpenHelper v1;

    public YorumVeritabanı(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    ; //Kurucu metot ile veritabanımızı oluşturduk.
    SQLiteDatabase sqLiteDatabase;

    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL("CREATE TABLE " + TABLE_NAME + " (id INTEGER PRIMARY KEY AUTOINCREMENT," + KITAP_AD + " TEXT," + YORUM +"TEXT);"); //Burada çalışma anında veritabanımızın içine tabloyu oluşturduk ve değerleri belirledik.
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE İF EXİST " + TABLE_NAME);
        this.onCreate(db);//onCreate fonksiyonu çağrılarak oluşturduğumuz veritabanı tablosunda güncelleme yaptık.
    }

    public void veriEkle(String kitapAdi,String yorum) {
        SQLiteDatabase db = this.getWritableDatabase();//SQLiteDatabase sınıfında yazılabilir bağlantı açıyoruz.
        ContentValues cv = new ContentValues();//contentValues sınıfından bir nesne oluşturuyoruz.ContentValues değerleri tutmamızı sağlıyor.
        cv.put(KITAP_AD, kitapAdi.trim());
        cv.put(YORUM, yorum.trim());
        long r = db.insert(TABLE_NAME, null, cv);//Tabloya ekleme yaptığımız fonksiyon.
        if (r > -1)
            Log.i("tag", "İşlem Başarılı");//ekleme olması durumunda bu çıktıyı verir.
        else
            Log.e("tag", "İşlem Başarısız");//ekleme olmaması durumunda bu çıktıyı verir.
        db.close();//Veritabanı kapatma işlemi
    }

    public List<String> veriListele() {
        List<String> veriler = new ArrayList<String>();//String türünde bir liste oluşturduk.
        SQLiteDatabase db = this.getWritableDatabase();//SQLiteDatabase sınıfında yazılabilir bağlantı açıyoruz.
        String[] sutunlar = {KITAP_AD,YORUM};
        Cursor cr = db.query(TABLE_NAME, sutunlar, null, null, null, null, null);//query fonksiyonu ile aldığımız parametreler yoluyla komutu kendi içerisinde yapılandırıyoruz.
        while (cr.moveToNext()) {
            veriler.add("YORUM: "+cr.getString(0));

        }
        return veriler;
    }

}
