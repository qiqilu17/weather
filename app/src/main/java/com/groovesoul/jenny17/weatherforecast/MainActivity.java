package com.groovesoul.jenny17.weatherforecast;

import android.os.StrictMode;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import android.widget.TextView;
import android.widget.Toast;

import java.io.IOException;
import java.io.StringReader;
import android.os.Handler;

public class MainActivity extends AppCompatActivity {
    private TextView result;
    private Handler handler = new Handler();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
       setContentView(R.layout.activity_main);

        result = (TextView) findViewById(R.id.tv_result);
        Thread subThread = new Thread() {

            @Override
            public void run() {
                try {
                    final String data = WeatherApi.getWeather("400040");

                    handler.post(new Runnable() {

                        @Override
                        public void run() {
                           result.setText(data);
                        }
                    });

                } catch (IOException e) {
                    Toast.makeText(getApplicationContext(), "IOException is occurred.",
                            Toast.LENGTH_SHORT).show();
                }
            }

        };
        subThread.start();

    }
}
