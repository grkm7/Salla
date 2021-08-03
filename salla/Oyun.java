package com.info.salla;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Random;

public class Oyun extends AppCompatActivity {
    private ImageView imageViewYon;
    private TextView textViewSonuc;
    private EditText editTextNumber;
    private Button button2;
    private int rastgelesayi;
    private int hak;
    private int hak2;
    private int aralik;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_oyun);

        imageViewYon=findViewById(R.id.imageViewYon);
        textViewSonuc=findViewById(R.id.textViewSonuc);
        editTextNumber=findViewById(R.id.editTextNumber);
        button2=findViewById(R.id.button2);
        aralik=getIntent().getIntExtra("aralık",0);
        hak = getIntent().getIntExtra("hak",0);

        hak2=hak;

        Random rastgele = new Random();
        rastgelesayi = rastgele.nextInt(aralik+1);
        Log.e("mesaj",String.valueOf(rastgelesayi));
        textViewSonuc.setText(hak2+" Hakkınız Kaldı");

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                hak2 = hak2-1;
                Intent sonuc = new Intent(Oyun.this,Sonuc.class);


                int tahmin = Integer.parseInt(editTextNumber.getText().toString());

                if(tahmin==rastgelesayi){
                    sonuc.putExtra("sonuc",true);
                    sonuc.putExtra("hak",hak);
                    sonuc.putExtra("dogrusayi",rastgelesayi);
                    sonuc.putExtra("aralık",aralik);
                    startActivity(sonuc);
                    finish();
                    return;
                }
                if(tahmin<rastgelesayi){

                    textViewSonuc.setText(hak2+" Hakkınız Kaldı");
                    imageViewYon.setImageResource(R.drawable.resim1);
                    imageViewYon.setVisibility(view.VISIBLE);

                }
                if(tahmin>rastgelesayi){
                    textViewSonuc.setText(hak2+" Hakkınız Kaldı");
                    imageViewYon.setImageResource(R.drawable.resim2);
                    imageViewYon.setVisibility(view.VISIBLE);


                }
                if(hak2==0){
                    sonuc.putExtra("sonuc",false);
                    sonuc.putExtra("hak",hak);
                    sonuc.putExtra("dogrusayi",rastgelesayi);
                    sonuc.putExtra("aralık",aralik);
                    startActivity(sonuc);
                    finish();
                    return;

                }
                editTextNumber.setText("");






            }
        });

    }
}