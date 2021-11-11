package com.example.github_projekt;

import android.hardware.*;
import android.widget.RelativeLayout;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.os.Bundle;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity implements SensorEventListener {

    RelativeLayout relativeLayout;          //Um Hintergrundfarbe ändern zu können
    SensorManager sensorManager;            //Zur Verwaltung der Sensor Objekte
    Sensor sensorProximity;                 //Näherungssensor zur Abstandsmessung
    TextView tvDistance:                    //zur Anzeige nah oder fern
    boolean hasProximitySensor;             //Variable wird true gesetzt wenn Sensor vorhanden ist
    float maxDistance;                      //maximaler Abstand des Näherungssensors
    float Distance;                         //gemessener Abstand des Näherungssensors


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //TextView-Objekte referenzieren
        tvX = (TextView) findViewById(R.id.textViewX);
        tvY = (TextView) findViewById(R.id.textViewY);
        tvZ = (TextView) findViewById(R.id.textViewZ);

        //Sensormanager
        sm = (SensorManager) getSystemService(SENSOR_SERVICE);

        //Acceleration Sensor
        sensorAcc = sm.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);

        //register Sensor Listener
        sm.registerListener(this, sensorAcc, sm.SENSOR_DELAY_NORMAL);
    }

    @Override
    public void onSensorChanged(SensorEvent event) {
        tvX.setText("X:" + event.values[0]);
        tvY.setText("Y:" + event.values[1]);
        tvZ.setText("Z:" + event.values[2]);
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {
        //Do nothing here
    }
}