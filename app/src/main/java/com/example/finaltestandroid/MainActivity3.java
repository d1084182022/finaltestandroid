package com.example.finaltestandroid;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Environment;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

public class MainActivity3 extends AppCompatActivity {
    private TextView mtext;
    private Button mbutton,btndel,btnread;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        mtext=(TextView) findViewById(R.id.textView4);
        String edittextString=(String)getIntent().getExtras().getString("edittext");
        mtext.setMovementMethod(ScrollingMovementMethod.getInstance());
        mbutton=(Button) findViewById(R.id.button2);
        btnread=findViewById(R.id.btnread2);
        btndel=findViewById(R.id.btndel2);
        btnread.setOnClickListener(readClickListener);
        btndel.setOnClickListener(delClickListener);
        mbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                intent.setClass(MainActivity3.this,MainActivity.class);

                startActivity(intent);
            }
        });
    }
    //按下Read按鈕
    private Button.OnClickListener readClickListener = new Button.OnClickListener() {

        public void onClick(View arg0) {
            String filename = "CheckFlie.txt";
            File path = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS);
            File file = new File(path, filename);

            try{
                //建立FileReader物件，並設定讀取的檔案為CheckFlie.txt
                FileReader fr = new FileReader(file);
                //將BufferedReader與FileReader做連結
                BufferedReader bufFile = new BufferedReader(fr);
                String readData = "";
                String temp = bufFile.readLine(); //readLine()讀取一整行
                while (temp!=null){
                    readData+=temp +  "\n";
                    temp=bufFile.readLine();
                }
                mtext.setText(readData);
            }catch(Exception e){
                e.printStackTrace();
            }
        }
    };
    private Button.OnClickListener delClickListener = new Button.OnClickListener() {
        @Override
        public void onClick(View view) {
            String filename = "CheckFlie.txt";
            File path = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS);
            File file = new File(path, filename);
            if(file.isFile()&&file.exists())
            {
                file.delete();
                mtext.setText(R.string.delsuccess);
            }
            else
            {
                mtext.setText(R.string.delfall);
            }


        }
    };
}