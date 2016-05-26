package com.shawn_wind.touchnumber;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.GridLayout;

public class StartActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);
        Button startButton = (Button) findViewById(R.id.button);
        startButton.setOnClickListener(this);

    }
    @Override
    public  void onClick(View start){
        Intent startIntent = new Intent(StartActivity.this, MainActivity.class);
        startActivity(startIntent);
    }

}
