package fi.chinguyen.betterskin;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

import java.util.Objects;

public class Register extends AppCompatActivity {
    EditText fullNameInput, emailInput, passwordInput, phoneInput;
    Button registerButton;
    TextView loginButton;
    FirebaseAuth auth;
    ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        fullNameInput = findViewById(R.id.fullName);
        emailInput = findViewById(R.id.email);
        passwordInput = findViewById(R.id.password);
        phoneInput = findViewById(R.id.password);
        registerButton = findViewById(R.id.registerDone);
        loginButton = findViewById(R.id.already);

        auth = FirebaseAuth.getInstance();
        progressBar = findViewById(R.id.progressBar);

        if(auth.getCurrentUser() != null){
            startActivity(new Intent(getApplicationContext(), LogoDisplay.class));
            finish();
        }

        registerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = emailInput.getText().toString().trim();
                String password = passwordInput.getText().toString().trim();

                if (TextUtils.isEmpty(email)){
                    emailInput.setError("Email is required");
                    return;
                }

                if(TextUtils.isEmpty(password)){
                    passwordInput.setError("Password is required");
                    return;
                }

                if(password.length() < 6){
                    passwordInput.setError("Password must be >= 6 characters");
                    return;
                }

                progressBar.setVisibility(View.VISIBLE);

                auth.createUserWithEmailAndPassword(email,password).addOnCompleteListener(task -> {
                    if(task.isSuccessful()){
                        Toast.makeText(Register.this, "User Created", Toast.LENGTH_SHORT).show();
                        startActivity(new Intent(getApplicationContext(), LogoDisplay.class));
                    }else{
                        Toast.makeText(Register.this, "Error!", Toast.LENGTH_SHORT).show();

                    }
                });
            }
        });
        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(),Login.class));
            }
        });
    }
}