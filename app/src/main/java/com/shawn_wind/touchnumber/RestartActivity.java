package com.shawn_wind.touchnumber;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class RestartActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        final Intent intent = getIntent();
        String result = intent.getStringExtra("result");    //resultに秒を表示

        setContentView(R.layout.activity_restart);
        Button button = (Button) findViewById(R.id.restartButton);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent restartIntent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(restartIntent);

            }
        });
        TextView timeTextView = (TextView) findViewById(R.id.textView);
        timeTextView.setText(result);

    }
}
