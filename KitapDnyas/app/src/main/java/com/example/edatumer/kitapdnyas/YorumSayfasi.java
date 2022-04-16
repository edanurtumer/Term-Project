package com.example.edatumer.kitapdnyas;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import java.util.List;

public class YorumSayfasi extends AppCompatActivity {

    Button button;
    EditText editText1;
    ListView listView;
    String kitapAdi;

    public void buton_click(){
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                KitapVeritabanı YorumVeritabanı=new KitapVeritabanı(YorumSayfasi.this);//KitapVeritabanı sayfasının bağlantısı
                //YorumVeritabanı.veriEkle(editText1.getText().toString());//edittext teki verileri get ile alıp stringe çevirdik
                List<String> vBilgiler =YorumVeritabanı.veriListele();//eklenen bilgileri
                ArrayAdapter<String> adapter1=new ArrayAdapter<String>(YorumSayfasi.this,android.R.layout.activity_list_item,android.R.id.text1,vBilgiler);
                listView.setAdapter(adapter1);
            }


        });
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_yorum_sayfasi);
        button=findViewById(R.id.button4);
        editText1=findViewById(R.id.editText9);
        listView = (ListView) findViewById(R.id.kitaplar);
        YorumVeritabanı yorumVeritabanı=new YorumVeritabanı(YorumSayfasi.this);//YorumVeritabanı sayfasının bağlantısı
        buton_click();
    }
}
