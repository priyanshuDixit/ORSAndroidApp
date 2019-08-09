package com.sunilos.ors;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

public abstract class BaseActivity extends AppCompatActivity {

    /**
     * Initialize action attributes
     */
    protected abstract void init();

    /**
     * Contains display logic of activity
     */
    protected abstract void display();

    /**
     * Contains submit logic of activity
     */
    protected abstract void submit();

    /**
     * returns view of activity
     */
    protected abstract int getView();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getView());
        init();
        display();
        submit();
    }

}
