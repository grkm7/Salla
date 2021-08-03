package com.info.salla;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.PopupMenu;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private Button button1;
    private Button buttonzorluk;
    private int hak=7;
    private SeekBar seekbar;
    private TextView textseekbar;
    private int aralik=100;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textseekbar = findViewById(R.id.textseekbar);
        seekbar = findViewById(R.id.seekBar);
        buttonzorluk = findViewById(R.id.buttonzorluk);
        button1=findViewById(R.id.button1);

        seekbar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                textseekbar.setText("Aralık 0 - "+i);
                aralik=i;
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {


            }
        });

        buttonzorluk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                PopupMenu popup = new PopupMenu(MainActivity.this,buttonzorluk);
                popup.getMenuInflater().inflate(R.menu.menuzorluk,popup.getMenu());

                popup.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem item) {
                        switch (item.getItemId()){
                            case R.id.action_kolay:
                                hak=7;
                                return true;
                            case R.id.action_orta:
                                hak=5;
                                return true;
                            case R.id.action_zor:
                                hak=3;
                                return true;
                            default:

                                return false;
                        }
                    }
                });
                popup.show();
            }
        });



        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.e("hak:",String.valueOf(hak));
                Intent oyun = new Intent(MainActivity.this,Oyun.class);
                oyun.putExtra("hak",hak);
                oyun.putExtra("aralık",aralik);
                startActivity(oyun);
            }
        });
    }
}