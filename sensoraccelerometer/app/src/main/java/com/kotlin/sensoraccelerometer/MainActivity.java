package com.kotlin.sensoraccelerometer;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.DialogInterface;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements SensorEventListener {
    private SensorManager sensorManager;
    TextView xCoor;
    TextView yCoor;
    TextView zCoor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        xCoor = (TextView) findViewById(R.id.xcoor);
        yCoor = (TextView) findViewById(R.id.ycoor);
        zCoor = (TextView) findViewById(R.id.zcoor);

        Button button = findViewById(R.id.check);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(checkConnection()) {
                    Toast.makeText(MainActivity.this, "You are connected to the internet", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(MainActivity.this, "You are not connected to the internet", Toast.LENGTH_SHORT).show();
                }
            }
        });

        sensorManager = (SensorManager) getSystemService(SENSOR_SERVICE);

        if(sensorManager != null) {
            // menambahkan listener. Listener untuk class ini adalah accelerometer
            Sensor accelSensor = sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);

            if(accelSensor != null) {
                sensorManager.registerListener(this, accelSensor, SensorManager.SENSOR_DELAY_NORMAL);
            }
            // fungsi api yang dipakai untuk perubahan screen orientation
        } else {
            Toast.makeText(this, "Sensor service not detected", Toast.LENGTH_SHORT).show();
        }
    }

    public boolean checkConnection() {
        ConnectivityManager cm = (ConnectivityManager) getSystemService(CONNECTIVITY_SERVICE);

        NetworkInfo activeNetwork = cm.getActiveNetworkInfo();

        boolean isConnected = activeNetwork != null && activeNetwork.isConnectedOrConnecting();

        return isConnected;
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {}

    @Override
    public void onSensorChanged(SensorEvent event) {
        // cek jenis sensor
        if (event.sensor.getType() == Sensor.TYPE_ACCELEROMETER) {
        // assign directions
        float x = event.values[0];
        float y = event.values[1];
        float z = event.values[2];

        xCoor.setText("X: " + x);
        yCoor.setText("Y: " + y);
        zCoor.setText("Z: " + z);
        }
    }
}
