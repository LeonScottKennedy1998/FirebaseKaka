package com.example.firebasetest;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class LoginActivity  extends AppCompatActivity {
    private EditText loginEd, passwordEd;
    private Button signUp;
    private FirebaseAuth firebaseAuth;
    private String email, password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.login_activity);

        firebaseAuth = FirebaseAuth.getInstance();
        FirebaseUser currentUser = firebaseAuth.getCurrentUser();
        if(currentUser!=null){
            startActivity(new Intent(LoginActivity.this, MainActivity.class));
            finish();
        }
        loginEd=findViewById(R.id.etEmail);
        passwordEd =findViewById(R.id.etPassword);
        signUp =findViewById(R.id.btnLogin);

        signUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                validData();
            }
        });
    }

    private void validData(){
        email = loginEd.getText().toString().trim();
        password = passwordEd.getText().toString().trim();

        if(!Patterns.EMAIL_ADDRESS.matcher(email).matches()){
            loginEd.setError("Неправильно введена почта");
        } else if(TextUtils.isEmpty(password)){
            passwordEd.setError("Пароль не должен быть пустым");
        }else if(password.length()<5){
            passwordEd.setError("Пароль должен содержать не менее 5 символов");
        }else{
            firebaseLogin();
        }
    }

    private void firebaseLogin(){
        firebaseAuth.signInWithEmailAndPassword(email,password).addOnSuccessListener(new OnSuccessListener<AuthResult>() {
            @Override
            public void onSuccess(AuthResult authResult) {
                Toast.makeText(LoginActivity.this,"УСПЕШНО УАСЯ", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(LoginActivity.this,MainActivity.class));
                finish();
            }
        }) .addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
            Toast.makeText(LoginActivity.this,"Неуспешно не вошёл" + e.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    public void RegisterClick(){
        startActivity(new Intent(this,RegisterActivity.class));
    }

}


