package com.example.jelit.ti3a_19_uts;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;

import com.example.jelit.ti3a_19_uts.adapters.KotaAdapter;

import java.util.ArrayList;

public class ViewKotaActivity extends AppCompatActivity {

    RecyclerView rv;
    RecyclerView.LayoutManager lm;
    KotaAdapter rvKotaAdapter;
    Button btnTambah;

    Cursor cursor;
    DataKotaHelper dataKotaHelper;

    ArrayList<String> dataset;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_viewkota);

        rv = findViewById(R.id.rv);
        btnTambah = findViewById(R.id.btnTambah);
        dataKotaHelper = new DataKotaHelper(this);

        lm = new LinearLayoutManager(this);

        rv.setLayoutManager(lm);

        btnTambah.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(ViewKotaActivity.this,CekKotaActivity.class);
                startActivity(i);
            }
        });
        refreshList();
    }

    public void refreshList(){
        SQLiteDatabase db = dataKotaHelper.getReadableDatabase();
        dataset = new ArrayList<String>();

        cursor = db.rawQuery("SELECT * FROM kota",null);
        cursor.moveToFirst();
        for (int cc=0; cc < cursor.getCount(); cc++){
            cursor.moveToPosition(cc);
            dataset.add(cursor.getString(0).toString());
        }

        rvKotaAdapter = new KotaAdapter(dataset);

        rv.setAdapter(rvKotaAdapter);
    }
}
