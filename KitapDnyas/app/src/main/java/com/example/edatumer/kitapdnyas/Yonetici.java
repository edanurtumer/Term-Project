package com.example.edatumer.kitapdnyas;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import java.util.List;

public class Yonetici extends AppCompatActivity {
    Button button;
    EditText editText1,editText2,editText3;
    ListView listView;
    public void buton_click(){
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                KitapVeritabanı kitapVeritabanı=new KitapVeritabanı(Yonetici.this);//KitapVeritabanı sayfasının bağlantısı
                kitapVeritabanı.veriEkle(editText1.getText().toString(),editText2.getText().toString(),editText3.getText().toString());//edittext teki verileri get ile alıp stringe çevirdik
               List<String> vBilgiler =kitapVeritabanı.veriListele();//eklenen bilgileri
                ArrayAdapter<String> adapter1=new ArrayAdapter<String>(Yonetici.this,android.R.layout.activity_list_item,android.R.id.text1,vBilgiler);
                listView.setAdapter(adapter1);
            }


        });
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_yonetici);
        button=findViewById(R.id.button2);
        editText1=findViewById(R.id.editText3);
        editText2=findViewById(R.id.editText4);
        editText3=findViewById(R.id.editText5);
        listView = (ListView) findViewById(R.id.kitaplar);
        KitapVeritabanı kitapVeritabanı=new KitapVeritabanı(Yonetici.this);//KitapVeritabanı sayfasının bağlantısı
        //kitapVeritabanı.veriSil("");//KitapVeritabanı dosyasındaki kitap silme işleme
        buton_click();
    }
}
