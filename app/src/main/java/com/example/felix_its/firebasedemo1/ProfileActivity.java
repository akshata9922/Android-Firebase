package com.example.felix_its.firebasedemo1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class ProfileActivity extends AppCompatActivity {
    TextView txtemail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        txtemail=findViewById(R.id.txtemail);
        txtemail.setText(getIntent().getExtras().getString("Email"));

    }
}
