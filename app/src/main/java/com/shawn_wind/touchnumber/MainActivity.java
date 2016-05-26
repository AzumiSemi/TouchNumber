package com.shawn_wind.touchnumber;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.GridLayout;

public class MainActivity extends AppCompatActivity {
    private Button button[] = new Button[16];
    double b[] = new double[16];
    int c[] = new int[16];

    @Override
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
    }



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        GridLayout GL = new GridLayout(this);

        GL.setColumnCount(4);   //Buttonの横の数
        setContentView(GL);

        for (int i=0; i<16; i++) {
            b[i] = Math.random();
            c[i]=0;
            button[i] = new Button(this);
            button[i].setText("" + i);
            GL.addView(button[i]);
        }

        for (int j=0; j<16; j++){
            for (int m=0; m<16; m++){
                if((b[j]<b[m]) && (!(j==m))){
                    c[j]++;
                }
            }
        }
    }
}
