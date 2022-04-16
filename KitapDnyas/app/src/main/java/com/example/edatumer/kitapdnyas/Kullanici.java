package com.example.edatumer.kitapdnyas;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Kullanici extends AppCompatActivity {
    Button button;
    EditText editText1,editText2;
    TextView textView1;
    public void buton_click(){
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               /* textView1.setText("Böyle bir kitap bulunamadı!");
                KitapVeritabanı kitapVeritabanı=new KitapVeritabanı(Kullanici.this);
                String sayfasayisi;
                sayfasayisi=kitapVeritabanı.Arama(editText1.getText().toString(),editText2.getText().toString());
                if(sayfasayisi.equals("yok")){
                    textView1.setText("Böyle bir kitap bulunamadı!");
                }
                else {

                }*/
                Intent intent=new Intent(getApplicationContext(),YorumSayfasi.class);
                startActivity(intent);
            }
        });
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kullanici);
        button=findViewById(R.id.button3);
        editText1=findViewById(R.id.editText2);
        editText2=findViewById(R.id.editText7);
        textView1=findViewById(R.id.textView8);
        buton_click();

    }
}
