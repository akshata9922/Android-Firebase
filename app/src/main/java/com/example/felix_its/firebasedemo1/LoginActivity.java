package com.example.felix_its.firebasedemo1;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class LoginActivity extends AppCompatActivity {
    EditText edtemaillogin,edtpasswordlogin;
    FirebaseAuth firebaseAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        edtemaillogin=findViewById(R.id.edtemaillogin);
        edtpasswordlogin=findViewById(R.id.edtpasswordlogin);
        firebaseAuth=FirebaseAuth.getInstance();
    }

    public void userLogin(View view) {
       final ProgressDialog progressDialog=ProgressDialog.show(LoginActivity.this,"Please Wait ..!","Prossesing",true);

        (firebaseAuth.createUserWithEmailAndPassword(edtemaillogin.getText().toString(),edtpasswordlogin.getText().toString())).
                addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        progressDialog.dismiss();

                        if (task.isSuccessful())
                        {
                            Toast.makeText(LoginActivity.this,"Login Successful",Toast.LENGTH_LONG).show();
                            Intent intent=new Intent(LoginActivity.this,ProfileActivity.class);
                            intent.putExtra("Email",firebaseAuth.getCurrentUser().getEmail());
                            startActivity(intent);
                        }
                        else {
                            Log.e("Error",task.getException().toString());
                            Toast.makeText(LoginActivity.this,task.getException().getMessage(),Toast.LENGTH_LONG).show();
                        }
                    }
                });

    }
}
