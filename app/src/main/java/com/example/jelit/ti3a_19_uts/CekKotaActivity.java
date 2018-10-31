package com.example.jelit.ti3a_19_uts;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class CekKotaActivity extends AppCompatActivity {

    DataKotaHelper dataKotaHelper;
    Cursor cursor;
    EditText edtNama;
    Button btnInput,btnLihat;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cekkota);

        edtNama = findViewById(R.id.edtNama);
        btnInput = findViewById(R.id.btnInput);
        btnLihat = findViewById(R.id.btnLihat);
        dataKotaHelper = new DataKotaHelper(this);

        btnInput.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String nama = edtNama.getText().toString();
                SQLiteDatabase db = dataKotaHelper.getWritableDatabase();
                db.execSQL("insert into kota (nama) values ('"+nama+"')");
                Toast.makeText(CekKotaActivity.this,"Input Berhasil dengan nama = "+nama,Toast.LENGTH_LONG).show();
            }
        });
        btnLihat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(CekKotaActivity.this,ViewKotaActivity.class);
                startActivity(i);
            }
        });
    }
}
