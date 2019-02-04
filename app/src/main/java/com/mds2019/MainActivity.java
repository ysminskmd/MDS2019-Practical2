package com.mds2019;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;

import com.crashlytics.android.Crashlytics;

import io.fabric.sdk.android.Fabric;

public class MainActivity extends AppCompatActivity {

    private int mIndex;

    private final int[] drawables = {
            R.drawable.i1,
            R.drawable.i2,
            R.drawable.i3,
            R.drawable.i4,
            R.drawable.i5
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Fabric.with(this, new Crashlytics());
        setContentView(R.layout.frame_layout);

        final ImageView imageView = findViewById(R.id.image);
        fillImage(imageView);

        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(final View v) {
                fillImage(imageView);
            }
        });
    }

    private void fillImage(final ImageView imageView) {
        final int resId = drawables[mIndex];
        imageView.setImageResource(resId);
        mIndex = mIndex < drawables.length - 1 ? mIndex + 1 : 0;
    }
}
