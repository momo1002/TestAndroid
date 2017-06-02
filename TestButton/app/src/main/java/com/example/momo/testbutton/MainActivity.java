package com.example.momo.testbutton;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private TextView mTextView;
    private boolean mSwitch = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mTextView = (TextView) findViewById(R.id.textView);
        Button button =  (Button) findViewById(R.id.button);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mSwitch){
                    mTextView.setText("Hello!");
                    mSwitch = false;
                } else {
                    mTextView.setText("World :)");
                    mSwitch = true;
                }
            }
        });
        Log.d("debug","onCreate()");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d("debug","onStart()");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d("debug","onResume()");
    }

    @Override
    protected void onPause(){
        super.onPause();
        Log.d("debug","onPause()");
    }

    @Override
    protected void onDestroy(){
        super.onDestroy();
        Log.d("debug","onDestroy()");
    }

    @Override
    protected void onStop(){
        super.onStop();
        Log.d("debug","onStop()");
    }
}
