package com.example.momo.testforresult;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView tv_result;
    int number1 = 3;
    int number2 = 4;
    int result = 0;
    static final int RESULT_SUBACTIVITY = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // connect layout view & java program
        TextView tv1 = (TextView) findViewById(R.id.text_view1);
        TextView tv2 = (TextView) findViewById(R.id.text_view2);
        tv_result = (TextView) findViewById(R.id.text_view_result);
        Button button = (Button) findViewById(R.id.button);

        tv1.setText("Number : " + String.valueOf(number1));
        tv2.setText("Number : " + String.valueOf(number2));
        tv_result.setText("Result : " + String.valueOf(result)); //★★


        //-------【 1 】send information(intent)-----------------------------//
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplication(),SubActivity.class); // container to put information then bring it to Sub.
                intent.putExtra("Num1", number1);
                intent.putExtra("Num2", number2);
                intent.putExtra("Message", "You added! Go back!");
                startActivityForResult(intent, RESULT_SUBACTIVITY);
            }
        });
    }

    //-------【 4 】get information(intent)-----------------------------//
    protected void onActivityResult(int requestCode, int resultCode, Intent intent){
        super.onActivityResult(requestCode, resultCode, intent);
        if(resultCode == RESULT_OK && requestCode == RESULT_SUBACTIVITY && null != intent){
            int res = intent.getIntExtra("RESULT", 0);
            String message = intent.getStringExtra("Message");
            tv_result.setText(message + "... Result = " + String.valueOf(res));
        }
    }
}
