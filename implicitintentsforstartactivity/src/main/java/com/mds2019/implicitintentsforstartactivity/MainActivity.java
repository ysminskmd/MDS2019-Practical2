package com.mds2019.implicitintentsforstartactivity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private static final int REQUEST_CODE = 1000;
    private static final String EXTRA_DATA = "extra_data";

    //Если вы определяете собственные действия, обязательно используйте в качестве их префикса имя пакета вашего приложения
    private static final String INTENT_ACTION = "com.mds2019.implicitintentsforstartactivity.action";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final View view = findViewById(R.id.button);
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(final View v) {
                final Intent intent = new Intent(INTENT_ACTION);
                intent.putExtra("data", "value");
                startActivityForResult(intent, REQUEST_CODE);
            }
        });
    }

    @Override
    protected void onActivityResult(final int requestCode,
                                    final int resultCode,
                                    @Nullable final Intent data) {
        if (requestCode == REQUEST_CODE) {
            if (resultCode == RESULT_OK) {
                if (data != null) {
                    final String value = data.getStringExtra(EXTRA_DATA);
                    Toast.makeText(this, value, Toast.LENGTH_SHORT).show();
                }
            }
        }
    }
}
