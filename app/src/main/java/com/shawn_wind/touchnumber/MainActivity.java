package com.shawn_wind.touchnumber;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.GridLayout;

public class MainActivity extends AppCompatActivity {
    private Button button[] = new Button[16];
    double b[] = new double[16];
    int c[] = new int[16];
    int num = 1;
    private  long startTime;
    private  long stopTime;

    @Override
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_main);

        GridLayout GL = new GridLayout(this);

        GL.setColumnCount(4);   //Buttonの横の数
        setContentView(GL);

        startTime = System.currentTimeMillis();     //stat時間を取得


        for (int i=0; i<16; i++) {
            b[i] = Math.random();
            c[i]=0;
            button[i] = new Button(this);
            button[i].setText("" + i);
            //GL.addView(button[i]);
        }

        for (int j=0; j<16; j++){
            for (int m=0; m<16; m++){
                if((b[j]<b[m]) && (!(j==m))){
                    c[j]++;
                }
            }
        }

        for (int k=0; k<16; k++){
            button[k].setText("" + (c[k] + 1));
            button[k].setId(c[k] + 1);
            button[k].setOnClickListener(new View.OnClickListener() {
                                             @Override
                                             public void onClick(View v) {
                                                 if ((int) v.getId() == num) {
                                                     Button button = (Button) findViewById(v.getId());
                                                     button.setVisibility(View.INVISIBLE);   //buttonを消す
                                                     num++; //次のButtonを消す
                                                     if (num == 17) {
                                                         stopTime = System.currentTimeMillis();
                                                         Intent intent = new Intent(getApplicationContext(), RestartActivity.class);
                                                         intent.putExtra("result", String.valueOf((stopTime - startTime) / 1000) + "秒");  //費やした時間(秒)
                                                         startActivity(intent);
                                                     }
                                                 }
//                    if ((int) v.getId() == 16) {
//                        Intent intent = new Intent(get)
                                             }
                                         }

            );
                GL.addView(button[k]);
           // }
        }
    }
}