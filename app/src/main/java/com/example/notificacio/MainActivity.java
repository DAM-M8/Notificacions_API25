package com.example.notificacio;

import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

/* Exemple de notificació per API 25 o inferior */
public class MainActivity extends AppCompatActivity {

    public static final int MY_PERMISSIONS_REQUEST_READ_PHONE_STATE = 999;  //Els identificadors dels permisos son arbitraris
    public static final int MY_PERMISSIONS_REQUEST_READ_CALL_LOG = 990;  //Els identificadors dels permisos son arbitraris

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        //SolÂ·licitem tots els permisos necessaris en temps d'execucio. Aquest fet es imprescindible per garantir la compatibilitat amb l'API 28 i posteriors
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if (getApplicationContext().checkSelfPermission(Manifest.permission.READ_PHONE_STATE)
                != PackageManager.PERMISSION_GRANTED) {
            // Es pregunta a l'usuari el permis
            ActivityCompat.requestPermissions(this,
                    new String[]{Manifest.permission.READ_PHONE_STATE},
                    MY_PERMISSIONS_REQUEST_READ_PHONE_STATE);
        }
        if (getApplicationContext().checkSelfPermission(Manifest.permission.READ_CALL_LOG)
                != PackageManager.PERMISSION_GRANTED) {
            // Es pregunta a l'usuari el permis
            ActivityCompat.requestPermissions(this,
                    new String[]{Manifest.permission.READ_CALL_LOG},
                    MY_PERMISSIONS_REQUEST_READ_CALL_LOG);
        }
    }

}