package com.kotlin.latihanstorage;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.io.File;
import java.io.FileOutputStream;

public class ExternalStorageActivity extends AppCompatActivity {
    public static final String FILENAME = "filename.txt";
    Button readFile, updateFile, deleteFile, createFile;
    TextView result;

//    if(!isExternalStorageAvailable() || isExternalStorageReadOnly()) {
//        createFile.setEnabled(false);
//    }
//
//    private static boolean isExternalStorageAvailable() {
//        String extStorageState = Environment.getExternalStorageState();
//        if(Environment.MEDIA_MOUNTED_READ_ONLY.equals(extStorageState)) {
//            return true;
//        }
//
//        return false;
//    }
//
//    private static boolean isExternalStorageReadOnly() {
//        String extStorageState = Environment.getExternalStorageState();
//        if(Environment.MEDIA_MOUNTED.equals(extStorageState)) {
//            return true;
//        }
//
//        return false;
//    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_external_storage);

        createFile = findViewById(R.id.createfile);
        readFile = findViewById(R.id.readfile);
        updateFile = findViewById(R.id.updatefile);
        deleteFile = findViewById(R.id.deletefile);
        result = findViewById(R.id.result);

//        createFile.setOnClickListener(this);
//        updateFile.setOnClickListener(this);
//        readFile.setOnClickListener(this);
//        deleteFile.setOnClickListener(this);
    }

    public void createFile() {
        String content = "Hello World From Heaven";
        String state = Environment.getExternalStorageState();
        if(!Environment.MEDIA_MOUNTED.equals(state)) {
            return;
        }

        File file = new File(Environment.getExternalStorageDirectory(), "DemoFile.txt");
        FileOutputStream fos = null;

        try {
            file.createNewFile();
            fos = new FileOutputStream(file, true);
            fos.write(content.getBytes());
            fos.flush();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (fos != null) {
                try {
                    fos.close();
                } catch (Exception e)  {
                    e.printStackTrace();
                }
            }
        }
    }
}
