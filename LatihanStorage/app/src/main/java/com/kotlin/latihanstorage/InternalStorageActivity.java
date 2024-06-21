package com.kotlin.latihanstorage;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;

public class InternalStorageActivity extends AppCompatActivity implements View.OnClickListener {
    public static final String FILENAME = "filename.txt";
    Button readFileButton, updateFileButton, deleteFileButton, createFileButton;
    TextView result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_internal_storage);

        createFileButton = findViewById(R.id.createFileButton);
        readFileButton = findViewById(R.id.readFileButton);
        updateFileButton = findViewById(R.id.updateFileButton);
        deleteFileButton = findViewById(R.id.deleteFileButton);
        result = findViewById(R.id.result);

        createFileButton.setOnClickListener(this);
        readFileButton.setOnClickListener(this);
        updateFileButton.setOnClickListener(this);
        deleteFileButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        run(v.getId());
    }

    public void run(int id) {
        if (id == R.id.createFileButton) {
            createFile();
        } else if (id == R.id.deleteFileButton) {
            deleteFile();
        } else if (id == R.id.readFileButton) {
            readFile();
        } else if (id == R.id.updateFileButton) {
          updateFile();
        } else {
            throw new IllegalArgumentException("Unknown id: " + id);
        }
    }

    public void updateFile() {
        String updatedText = "Updated text in file";
        File file = new File(getFilesDir(), "DemoFile.txt");

        try {
            FileOutputStream outputStream = new FileOutputStream(file, false);
            outputStream.write(updatedText.getBytes());
            outputStream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        Toast.makeText(this, "Berhasil mengubah file", Toast.LENGTH_SHORT).show();
    }

    public void readFile() {
        File path = new File(getFilesDir(), "DemoFile.txt");

        try {
            BufferedReader br = new BufferedReader(new FileReader(path));
            StringBuilder sb = new StringBuilder();
            String line = br.readLine();

            while (line != null) {
                sb.append(line).append("\n");
                line = br.readLine();
            }

            result.setText(sb.toString());
            br.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        Toast.makeText(this, "Berhasil membaca file", Toast.LENGTH_SHORT).show();
    }

    public void createFile() {
        String cashback = "lorem ipsum dolor sit amet";
        File file = new File(getFilesDir(), "DemoFile.txt");

        FileOutputStream outputStream = null;

        try {
            file.createNewFile();
            outputStream = new FileOutputStream(file, true);
            outputStream.write(cashback.getBytes());
            outputStream.flush();
            outputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        Toast.makeText(this, "File berhasil dibuat", Toast.LENGTH_SHORT).show();
    }

    public void deleteFile() {
        File file = new File(getFilesDir(), "DemoFile.txt");

        if (file.exists()) {
            file.delete();
            Toast.makeText(this, "Berhasil menghapus file", Toast.LENGTH_SHORT).show();
        }
    }
}
