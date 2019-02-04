package com.mds2019.resolveactivity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class ThirdActivity extends AppCompatActivity {

    private static final String EXTRA_DATA = "extra_data";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);

        //adb shell am start com.mds2019.implicitintentsforstartactivity/.ThirdActivity
    }

    public void clickButton(View view) {
        final Intent intent = new Intent();
        intent.putExtra(EXTRA_DATA, "ThirdActivity");
        setResult(RESULT_OK, intent);
        finish();
    }
}
