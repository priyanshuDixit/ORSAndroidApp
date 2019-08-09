package com.sunilos.ors;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class SmsListActivity extends BaseActivity {

    private TextView label = null;

    @Override
    protected void init() {
        label = (TextView) findViewById(R.id.Three);
    }

    @Override
    protected void display() {
        label.setText("This is SMS list");
    }

    @Override
    protected int getView() {
        return R.layout.activity_sms_list;
    }

    @Override
    protected void submit() {

    }

}
