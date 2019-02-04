package com.mds2019.contentprovider;

import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.provider.ContactsContract;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private static final int PICK_CONTACT_REQUEST = 1000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final View view = findViewById(R.id.button);
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(final View v) {
                final Intent pickContactIntent = new Intent(Intent.ACTION_PICK);
                //URI (объект Uri), ссылающийся на данные, с которыми будет выполняться действие
                pickContactIntent.setDataAndType(Uri.parse("content://contacts"), ContactsContract.CommonDataKinds.Phone.CONTENT_TYPE);
                startActivityForResult(pickContactIntent, PICK_CONTACT_REQUEST);
            }
        });
    }

    @Override
    protected void onActivityResult(final int requestCode,
                                    final int resultCode,
                                    @Nullable final Intent data) {
        if (requestCode == PICK_CONTACT_REQUEST) {
            if (resultCode == RESULT_OK) {
                if (data != null) {
                    final Uri contactUri = data.getData();
                    final String[] projection = {ContactsContract.CommonDataKinds.Phone.NUMBER};

                    final Cursor cursor = getContentResolver().query(
                            contactUri, projection, null, null, null);
                    cursor.moveToFirst();

                    final int column = cursor.getColumnIndex(ContactsContract.CommonDataKinds.Phone.NUMBER);
                    final String number = cursor.getString(column);

                    Toast.makeText(this, number, Toast.LENGTH_SHORT).show();
                }
            }
        }
    }
}
