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

public class RegisterActivity extends AppCompatActivity {
    private EditText loginInp, passwordInp;
    private Button signInBtn;
    private String email,password;
    private FirebaseAuth firebaseAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.register_activity);

        firebaseAuth = FirebaseAuth.getInstance();

        loginInp = findViewById(R.id.etEmail);
        passwordInp= findViewById(R.id.etPassword);
        signInBtn = findViewById(R.id.btnRegister);

        signInBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                validData();
            }
        });


    }

    private void validData(){
        email = loginInp.getText().toString().trim();
        password = passwordInp.getText().toString().trim();

        if(!Patterns.EMAIL_ADDRESS.matcher(email).matches()){
            loginInp.setError("Неправильно введена почта");
        } else if(TextUtils.isEmpty(password)){
            passwordInp.setError("Пароль не должен быть пустым");
        }else if(password.length()<5){
            passwordInp.setError("Пароль должен содержать не менее 5 символов");
        }else{
            firebaseRegister();
        }
    }

    private void firebaseRegister(){
        firebaseAuth.createUserWithEmailAndPassword(email,password).addOnSuccessListener(new OnSuccessListener<AuthResult>() {
            @Override
            public void onSuccess(AuthResult authResult) {
                Toast.makeText(RegisterActivity.this, "Зареган брат", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(RegisterActivity.this,MainActivity.class));
                finish();
            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                Toast.makeText(RegisterActivity.this,"Говно рега" + e.getMessage(),Toast.LENGTH_SHORT).show();
            }
        });

    }
    public void onRegisterClick(View view){
        startActivity(new Intent(this,LoginActivity.class));
    }
}
