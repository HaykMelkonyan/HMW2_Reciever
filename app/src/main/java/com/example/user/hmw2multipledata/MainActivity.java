package com.example.user.hmw2multipledata;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import javax.xml.datatype.Duration;

public class MainActivity extends AppCompatActivity {

    TextView myTxtView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        myTxtView= (TextView)findViewById(R.id.myTxtBox);

        Intent intent = getIntent();
        String action = intent.getAction();
        String type = intent.getType();
       if (Intent.ACTION_SEND_MULTIPLE.equals(action) && type != null) {
           myTxtView.setText("if1");
            if (type.startsWith("text")) {
                myTxtView.setText("if2");
                handleSendText(intent);
            }
        }


    }
    void handleSendText(Intent intent) {
        ArrayList<String> sharedTexts = intent.getStringArrayListExtra(Intent.EXTRA_STREAM);
        if(sharedTexts==null)
            return;
        myTxtView.setText(sharedTexts.toString());
        if (sharedTexts != null) {
            String str="";
            for (String item: sharedTexts){
                str+= item;
                str+="\n";
            }
            myTxtView= (TextView)findViewById(R.id.myTxtBox);
            myTxtView.setText(str);
        }
    }


}
