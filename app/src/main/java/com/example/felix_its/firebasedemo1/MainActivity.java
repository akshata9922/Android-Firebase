package com.example.felix_its.firebasedemo1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void bnregister(View view) {
        Intent intent=new Intent(MainActivity.this,RegisterActivity.class);
        startActivity(intent);
    }

    public void btnlogin(View view) {
        Intent intent=new Intent(MainActivity.this,LoginActivity.class);
        startActivity(intent);
    }
}
