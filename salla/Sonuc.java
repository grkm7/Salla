package com.info.salla;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class Sonuc extends AppCompatActivity {
    private Button button3;
    private TextView TextViewSonuc2;
    private boolean sonuc;
    private int hak;
    private int dogrusayi;
    private int aralik;
    private ImageView imageViewSonuc;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sonuc);

        imageViewSonuc = findViewById(R.id.imageViewSonuc);
        button3= findViewById(R.id.button3);
        TextViewSonuc2= findViewById(R.id.textViewSonuc2);

        aralik=getIntent().getIntExtra("aralık",0);
        dogrusayi=getIntent().getIntExtra("dogrusayi",0);
        hak = getIntent().getIntExtra("hak",0);
        sonuc=getIntent().getBooleanExtra("sonuc",false);
        if(sonuc){
            TextViewSonuc2.setText("Bildin , Doğru Sayı: "+dogrusayi);
            imageViewSonuc.setImageResource(R.drawable.tik1);
        }else{
            imageViewSonuc.setImageResource(R.drawable.carpi);
            TextViewSonuc2.setText("Bilemedin , Doğru Sayı: "+dogrusayi);

        }
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                Intent tekrar = new Intent(Sonuc.this,Oyun.class);
                tekrar.putExtra("hak",hak);
                tekrar.putExtra("aralık",aralik);
                startActivity(tekrar);

                finish();
            }
        });


    }
}