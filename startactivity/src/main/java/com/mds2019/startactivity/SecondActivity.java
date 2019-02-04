package com.mds2019.startactivity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        final Intent intent = getIntent();
        final String data = intent.getStringExtra("data");
        Toast.makeText(this, data, Toast.LENGTH_SHORT).show();

        //adb shell am start com.mds2019.startactivity/.SecondActivity
    }

    public void clickButton(View view) {
        Toast.makeText(this, "This is SecondActivity class", Toast.LENGTH_SHORT).show();
    }
}
