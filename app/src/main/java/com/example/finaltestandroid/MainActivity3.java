package com.example.finaltestandroid;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity3 extends AppCompatActivity {
    private TextView mtext;
    private Button mbutton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        mtext=(TextView) findViewById(R.id.textView4);
        String edittextString=(String)getIntent().getExtras().getString("edittext");
        mtext.setText(edittextString);
        mbutton=(Button) findViewById(R.id.button2);
        mbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                intent.setClass(MainActivity3.this,MainActivity.class);

                startActivity(intent);
            }
        });
    }
}