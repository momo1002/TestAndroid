package com.example.momo.testforresult;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class SubActivity extends AppCompatActivity {
    int number1 = 0;
    int number2 = 0;
    String message;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sub);

        // connect layout view & java program
        TextView textview1 = (TextView) findViewById(R.id.text_view_sub1);
        TextView textview2 = (TextView) findViewById(R.id.text_view_sub2);
        Button button_back = (Button) findViewById(R.id.button_back);

        //-------【 2 】get information(intent) & connect-----------------------//
        Intent intent = getIntent();
        number1 = intent.getIntExtra("Num1", 0);
        number2 = intent.getIntExtra("Num2", 0);
        message = intent.getStringExtra("Message");

        final int number3 = number1 + number2;
        String str = String.valueOf(number1) + "+" + String.valueOf(number2) + " =  " + String.valueOf(number3);
        textview1.setText(message);
        textview2.setText(str);


        //-------【 3 】go back with information(intent)------------------------//
        button_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.putExtra("RESULT", number3); //★★
                intent.putExtra("Message", "It's result :)");
                setResult(RESULT_OK, intent);
                finish();
            }
        });

    }
}
