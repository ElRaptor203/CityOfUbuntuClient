package com.example.cityofubuntu;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.os.Build;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.widget.ImageView;
import android.widget.TextView;

public class FarineActivity extends AppCompatActivity {

    private ImageView fMaisImg;
    private ImageView fManiocImg;
    private ImageView fTeffImg;
    private ImageView fCocoImg;
    private ImageView fPatateImg;
    private ImageView fRizImg;
    private TextView fMaisTxt;
    private TextView fManiocTxt;
    private TextView fTeffTxt;
    private TextView fCocoTxt;
    private TextView fRizTxt;
    private TextView fPatateTxt;
    private Toolbar toolbar;



    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_farine);

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        fMaisImg = (ImageView) findViewById(R.id.fMaisImg);
        fManiocImg = (ImageView) findViewById(R.id.fManiocImg);
        fTeffImg = (ImageView) findViewById(R.id.fTeffImg);
        fCocoImg = (ImageView) findViewById(R.id.fCocoImg);
        fPatateImg = (ImageView) findViewById(R.id.fPatateImg);
        fRizImg = (ImageView) findViewById(R.id.fRizImg);
        fMaisTxt = (TextView) findViewById(R.id.fMaisTxt);
        fManiocTxt = (TextView) findViewById(R.id.fManiocTxt);
        fTeffTxt = (TextView) findViewById(R.id.fTeffTxt);
        fCocoTxt = (TextView) findViewById(R.id.fCocoTxt);
        fRizTxt = (TextView) findViewById(R.id.fRizTxt);
        fPatateTxt = (TextView) findViewById(R.id.fPatateTxt);

        setSupportActionBar(toolbar);
        getSupportActionBar().setIcon(getDrawable(R.drawable.ic_baseline_arrow_back_24));
        getSupportActionBar().setTitle("Farines");

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_home_activity, menu);
        return true;
    }
}