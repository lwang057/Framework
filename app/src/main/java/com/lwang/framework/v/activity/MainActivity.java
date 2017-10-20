package com.lwang.framework.v.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

import com.lwang.framework.R;

/**
 * MainActivity.class
 *
 * @author lwang
 * @date 2017/10/20.
 */
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }


    public void button(View view) {

        Toast.makeText(this, "HelloWorld", Toast.LENGTH_SHORT).show();
    }

}
