package com.example.mailgnderme;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    EditText icerik;
    EditText konu;
    EditText adres;
    Button btn;
    String icerikText, konuText, adresText;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tanimla();
        bilgiAl();
        mailUygulamasınıGorveGonder();
    }

    public void tanimla() {
        icerik = findViewById(R.id.mailIcerik);
        konu = findViewById(R.id.mailKonu);
        adres = findViewById(R.id.mailHesabı);
        btn = findViewById(R.id.mailAt);
    }

    public void bilgiAl() {

        icerikText = icerik.getText().toString();
        konuText = konu.getText().toString();
        adresText = adres.getText().toString();
    }

    public void mailUygulamasınıGorveGonder() {
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                bilgiAl();

                try {
                    Intent intent = new Intent(Intent.ACTION_SEND);
                    intent.setType("message/rfc822");
                    intent.putExtra(Intent.EXTRA_EMAIL, adresText);
                    intent.putExtra(Intent.EXTRA_SUBJECT, konuText);
                    intent.putExtra(Intent.EXTRA_TEXT, adresText);
                    startActivity(Intent.createChooser(intent,"Mail Gönderiniz..."));

                } catch (Exception e) {
                    System.out.println("" + e);

                }


            }
        });


    }


}
