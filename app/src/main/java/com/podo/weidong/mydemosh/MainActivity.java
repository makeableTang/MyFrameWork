package com.podo.weidong.mydemosh;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity {
    public static final String TAG = MainActivity.class.getName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        int a = 0;
        if (a > 3) {
            Log.i(TAG, "onCreate: a>3");
        } else if (a > 4) {
            Log.i(TAG, "onCreate: a>4");
        } else if (a == 5) {
            Log.i(TAG, "onCreate: a=5");
        } else if (a > 5) {
            Log.i(TAG, "onCreate: a>5");
        } else {
            Log.i(TAG, "onCreate: a------->  " + a);
        }
    }
}
