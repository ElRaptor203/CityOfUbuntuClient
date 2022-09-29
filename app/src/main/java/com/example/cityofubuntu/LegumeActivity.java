package com.example.cityofubuntu;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class LegumeActivity extends AppCompatActivity {

    private ImageView pOkockImg;
    private ImageView pNdoleImg;
    private ImageView pGomboImg;
    private ImageView pPersilImg;
    private ImageView pFollonImg;
    private ImageView pChouxImg;
    private ImageView pKelenkelenImg;
    private TextView pOkockTxt;
    private TextView pNdoleTxt;
    private TextView pGomboTxt;
    private TextView pPersilTxt;
    private TextView pFollonTxt;
    private TextView pChouxTxt;
    private TextView pKelenkelenTxt;
    private Toolbar toolbar;



    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_legume);

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        pOkockImg = (ImageView) findViewById(R.id.pOkockImg);
        pNdoleImg = (ImageView) findViewById(R.id.pNdoleImg);
        pGomboImg = (ImageView) findViewById(R.id.pGomboImg);
        pPersilImg = (ImageView) findViewById(R.id.pPersilImg);
        pFollonImg = (ImageView) findViewById(R.id.pFollonImg);
        pChouxImg = (ImageView) findViewById(R.id.pChouxImg);
        pKelenkelenImg = (ImageView) findViewById(R.id.pKelenkelenImg);
        pOkockTxt = (TextView) findViewById(R.id.pOkockTxt);
        pNdoleTxt = (TextView) findViewById(R.id.pNdoleTxt);
        pGomboTxt = (TextView) findViewById(R.id.pGomboTxt);
        pPersilTxt = (TextView) findViewById(R.id.pPersilTxt);
        pFollonTxt = (TextView) findViewById(R.id.pFollonTxt);
        pChouxTxt = (TextView) findViewById(R.id.pChouxTxt);
        pKelenkelenTxt = (TextView) findViewById(R.id.pKelenkelenTxt);

        setSupportActionBar(toolbar);
        getSupportActionBar().setIcon(getDrawable(R.drawable.ic_baseline_arrow_back_24));
        getSupportActionBar().setTitle("Légumes");

        pOkockImg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent OkockActivity = new Intent(LegumeActivity.this, OkockActivity.class);
                startActivity(OkockActivity);
            }
        });
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_home_activity, menu);
        return true;
    }
}