package com.example.reproductor;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void genero1(View view) {
        Intent genero1 = new Intent(this,Genero1.class);
        startActivity(genero1);
    }

    public void genero2(View view) {
        Intent genero2 = new Intent(this,Genero2.class);
        startActivity(genero2);
    }

    public void genero3(View view) {
        Intent genero3 = new Intent(this,Genero3.class);
        startActivity(genero3);
    }

    public void genero4(View view) {
        Intent genero4 = new Intent(this,Genero4.class);
        startActivity(genero4);
    }

    public void genero5(View view) {
        Intent genero5 = new Intent(this,Genero5.class);
        startActivity(genero5);
    }
}