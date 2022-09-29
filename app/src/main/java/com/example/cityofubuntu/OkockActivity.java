package com.example.cityofubuntu;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.os.Build;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class OkockActivity extends AppCompatActivity {

    private TextView oTitleTxt;
    private ImageView okockImg;
    private TextView okockTxt;
    private TextView oPrixTxt;
    private TextView oInfoTxt;
    private ImageView oInfoImg;
    private Button oPartagerBtn;
    private Button oPanierBtn;
    private Button oAcheterBtn;
    private Toolbar toolbar;


    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_okock);

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        oTitleTxt = (TextView) findViewById(R.id.oTitleTxt);
        okockImg = findViewById(R.id.okockImg);
        okockTxt = findViewById(R.id.okockTxt);
        oPrixTxt = findViewById(R.id.oPrixTxt);
        oInfoTxt = findViewById(R.id.oInfoTxt);
        oInfoImg = findViewById(R.id.oInfoImg);
        oPartagerBtn = findViewById(R.id.oPartagerBtn);
        oPanierBtn = findViewById(R.id.oPanierBtn);
        oAcheterBtn = findViewById(R.id.oAcheterBtn);

        setSupportActionBar(toolbar);
        getSupportActionBar().setIcon(getDrawable(R.drawable.ic_baseline_arrow_back_24));
        getSupportActionBar().setTitle("OKOCK");
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_okock_activity, menu);
        return true;
    }
}