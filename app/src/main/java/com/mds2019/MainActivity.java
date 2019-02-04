package com.mds2019;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Spinner mAges;
    private TextView mName;
    private Spinner mSpinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.relative_layout);

        mName = findViewById(R.id.name);
        mSpinner = findViewById(R.id.cities);
        mAges = findViewById(R.id.ages);
    }

    public void clickButton(View view) {
        final String age = String.valueOf(mAges.getSelectedItem());
        final String city = String.valueOf(mSpinner.getSelectedItem());
        final String name = String.valueOf(mName.getText());

        Toast.makeText(this, "Name = " + name + ", city = " + city + ", age = " + age, Toast.LENGTH_SHORT).show();
    }
}
