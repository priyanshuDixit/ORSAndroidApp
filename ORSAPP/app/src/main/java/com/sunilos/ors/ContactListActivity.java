package com.sunilos.ors;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ContactListActivity extends BaseActivity {

    private TextView conatctlist = null;
    private TextView one = null;
    private Button btn = null;

    @Override
    protected void init() {
        conatctlist = (TextView) findViewById(R.id.hello);
        one = (TextView) findViewById(R.id.one);
        btn = (Button) findViewById(R.id.Save);
    }

    @Override
    public void display() {
        conatctlist.setText("This is sunil sahu");
        one.setText("This is Priyanshu");
    }


    @Override
    protected void submit() {
        btn.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        // butLogin();
                        Intent intent = new Intent(ContactListActivity.this, SmsListActivity.class);
                        startActivity(intent);
                    }
                }
        );
    }

    @Override
    protected int getView() {
        return R.layout.activity_contact_list;
    }

}
