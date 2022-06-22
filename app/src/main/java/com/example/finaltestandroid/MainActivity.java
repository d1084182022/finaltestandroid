package com.example.finaltestandroid;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Environment;
import android.text.method.ScrollingMovementMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class MainActivity extends AppCompatActivity {
    private TextView mtxt;
    private EditText mETxt;
    private Button mbtngotochack,btnsava;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mtxt=findViewById(R.id.textView3);
        mETxt=findViewById(R.id.editText);

        btnsava = (Button) findViewById(R.id.btnsave);
        btnsava.setOnClickListener(saveClickListener);

        mtxt.setMovementMethod(ScrollingMovementMethod.getInstance());
        mbtngotochack=(Button) findViewById(R.id.btnchack);
        mbtngotochack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                intent.setClass(MainActivity.this,MainActivity3.class);
                Bundle bundle = new Bundle();
                bundle.putString("edittext",mETxt.getText().toString());
                intent.putExtras(bundle);
                startActivity(intent);
            }
        });
    }
    //按下Save按鈕
    private Button.OnClickListener saveClickListener = new Button.OnClickListener() {

        public void onClick(View arg0) {

            String strwhere = mETxt.getText().toString().trim();

            if (mETxt.getText().toString().matches("")){
                mtxt.setText(R.string.noNULL);
                return;
            }
            else{
                mtxt.setText(strwhere);
            }
            String filename = "CheckFlie.txt";
            // 存放檔案位置在 內部空間/Download/
            File path = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS);
            File file = new File(path, filename);
            try
            {
                // 第二個參數為是否 append
                // 若為 true，則新加入的文字會接續寫在文字檔的最後
                FileOutputStream Output = new FileOutputStream(file, true);

                String dateformat = "yyyyMMdd kk:mm:ss";
                SimpleDateFormat df = new SimpleDateFormat(dateformat);
                df.applyPattern(dateformat);
                String string =  df.format(new Date()) + " : " + mETxt.getText()  + "\n";
                Output.write(string.getBytes());
                Output.close();
            }
            catch (IOException e)
            {
                e.printStackTrace();
            }
        }
    };




}