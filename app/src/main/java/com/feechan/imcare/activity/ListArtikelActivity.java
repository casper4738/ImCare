package com.feechan.imcare.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.MenuItem;

import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.feechan.imcare.R;
import com.feechan.imcare.adapter.ArtikelListAdapter;
import com.feechan.imcare.adapter.PenyakitListAdapter;
import com.feechan.imcare.entity.Artikel;
import com.feechan.imcare.entity.Penyakit;
import com.feechan.imcare.global.AppHelper;
import com.feechan.imcare.global.DatabaseHelper;
import com.feechan.imcare.services.PenyakitService;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.util.ArrayList;
import java.util.List;

public class ListArtikelActivity extends AppCompatActivity {

    RecyclerView artikelRecyclerView;
    ArtikelListAdapter mAdapter;
    List<Artikel> artikels;
    Penyakit penyakit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_artikel);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        penyakit = (Penyakit) getIntent().getSerializableExtra("penyakit");

//        db = new DatabaseHelper(this);

        artikelRecyclerView = (RecyclerView) findViewById(R.id.artikelRecyclerView);
        artikels = new ArrayList<Artikel>();
        artikels.add(new Artikel(1,"Artikel Gejala","http://www.alodokter.com/setidaknya-ada-15-gejala-kanker-yang-harus-diwaspadai",1));
        artikels.add(new Artikel(2,"Artikel Diagnosa","http://www.alodokter.com/setidaknya-ada-15-gejala-kanker-yang-harus-diwaspadai",1));
        artikels.add(new Artikel(3,"Artikel Pengobatan","http://www.alodokter.com/setidaknya-ada-15-gejala-kanker-yang-harus-diwaspadai",1));


        mAdapter = new ArtikelListAdapter(artikels,this);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        artikelRecyclerView.setLayoutManager(mLayoutManager);
        artikelRecyclerView.setItemAnimator(new DefaultItemAnimator());
        artikelRecyclerView.setAdapter(mAdapter);

    }




    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            onBackPressed();
            return true;
        }
        return false;
    }
}

