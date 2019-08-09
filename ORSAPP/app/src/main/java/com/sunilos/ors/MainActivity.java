package com.sunilos.ors;

import android.content.ContentResolver;
import android.content.Intent;
import android.database.Cursor;
import android.provider.ContactsContract;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends BaseActivity {

    private Button butContact = null;
    public TextView conatctlist = null;

    @Override
    protected void init() {
        butContact = (Button) findViewById(R.id.contactbutton);
        conatctlist = (TextView) findViewById(R.id.hello);
    }

    @Override
    protected void display() {

    }

    @Override
    protected void submit() {
        butContact.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        // butLogin();
                        Intent intent = new Intent(MainActivity.this, ContactListActivity.class);
                        startActivity(intent);
                    }
                }
        );
    }

    @Override
    protected int getView() {
        return R.layout.activity_main;
    }


    private void butLogin() {
        StringBuilder builder = new StringBuilder();
        ContentResolver contentResolver = getContentResolver();
        Cursor cursor = contentResolver.query(ContactsContract.Contacts.CONTENT_URI, null, null, null, null);
        if (cursor.getCount() > 0) {
            while (cursor.moveToNext()) {
                String id = cursor.getString(cursor.getColumnIndex(ContactsContract.Contacts._ID));
                String name = cursor.getString(cursor.getColumnIndex(ContactsContract.Contacts.DISPLAY_NAME));
                int hasphonenumber = Integer.parseInt(cursor.getString(cursor.getColumnIndex(ContactsContract.Contacts.HAS_PHONE_NUMBER)));
                if (hasphonenumber > 0) {
                    Cursor cursor2 = contentResolver.query(ContactsContract.CommonDataKinds.Phone.CONTENT_URI, null, ContactsContract.CommonDataKinds.Phone.CONTACT_ID + "=?",
                            new String[]{id}, null);
                    while (cursor2.moveToNext()) {
                        String PhoneNumber = cursor2.getString(cursor2.getColumnIndex(ContactsContract.CommonDataKinds.Phone.NUMBER));
                        builder.append("contacts :").append(name).append(",PhoneNumber :").append(PhoneNumber).append("\n\n");
                    }
                    cursor2.close();
                }
            }
        }
        cursor.close();
        conatctlist.setText(builder.toString());
    }

}
