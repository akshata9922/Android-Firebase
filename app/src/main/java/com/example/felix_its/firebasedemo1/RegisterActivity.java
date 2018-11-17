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
import com.google.firebase.auth.FirebaseAuthException;

public class RegisterActivity extends AppCompatActivity {
   private EditText edtemail,edtpassword;
    private FirebaseAuth firebaseAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        edtemail=findViewById(R.id.edtemail);
        edtpassword=findViewById(R.id.edtpassword);
        firebaseAuth=FirebaseAuth.getInstance();
    }

    public void registerUser(View view) {
        final ProgressDialog progressDialog=ProgressDialog.show(this,"please wait..!","progressing",true);

        ( firebaseAuth.createUserWithEmailAndPassword(edtemail.getText().toString(),edtpassword.getText().toString()))
                .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        progressDialog.dismiss();
                        if (task.isSuccessful())
                        {
                           Toast.makeText(RegisterActivity.this,"Register Successfully",Toast.LENGTH_LONG).show();
                            Intent intent=new Intent(RegisterActivity.this,LoginActivity.class);
                            startActivity(intent);
                        }
                        else {
                            Log.e("Error",task.getException().toString());
                            Toast.makeText(RegisterActivity.this,task.getException().getMessage(),Toast.LENGTH_LONG).show();
                        }
                    }
                });

    }
}
