package com.example.edatumer.kitapdnyas;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button btn;
    EditText edt1, edt2;

    public void init() {
        edt1 = (EditText) findViewById(R.id.editText);
        edt2 = (EditText) findViewById(R.id.editText6);
        btn = (Button) findViewById(R.id.button);
    }
    public void buton_click(){
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Veritabanı veritabanı = new Veritabanı(MainActivity.this);//Veritabanı dosyası bağlantısı

                String sonuc;
                sonuc = veritabanı.verim(edt1.getText().toString(), edt2.getText().toString());//mail ve şifreyi sitringe çevirip veritabanıdaki verim fonksiyonuna gider

                if(sonuc.equals("Y")){
                    Intent intent=new Intent(getApplicationContext(),Yonetici.class);
                    startActivity(intent);
                }
                else if(sonuc.equals("K")){
                    Intent intent=new Intent(getApplicationContext(),Kullanici.class);//activity sayfalar arası geçiş
                    startActivity(intent);
                }
                else{
                    Toast.makeText(getApplicationContext(), "HATALI VEYA EKSİK BİLGİ GİRDİNİZ\nLÜTFEN TEKRAR DENEYİNİZ!", Toast.LENGTH_LONG).show();//eksik bilgi yada yanlış bilgide hata mesajı verir
                }

            }
        });
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Veritabanı veritabanı=new Veritabanı(MainActivity.this);
       /* veritabanı.veriEkle("Edanur","Tumer","edanurtumer98@gmail.com","sifre","Y");
         veritabanı.veriEkle("Yonetici","YONETİCİ","yonetici","sifrey","Y");*/
        init();
        buton_click();
    }


}