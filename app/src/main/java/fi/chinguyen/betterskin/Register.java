package fi.chinguyen.betterskin;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
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

public class Register extends AppCompatActivity {
    EditText fullNameInput, emailInput, passwordInput, phoneInput;
    Button registerButton;
    TextView loginButton;
    FirebaseAuth fAuth;
    ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        Log.d("Register", userQuizChoices.getInstance().getUserChoices().toString());

        fullNameInput = findViewById(R.id.fullNameInput);
        emailInput = findViewById(R.id.emailInput);
        passwordInput = findViewById(R.id.passwordInput);
        phoneInput = findViewById(R.id.phoneInput);
        registerButton = findViewById(R.id.registerButton);
        loginButton = findViewById(R.id.goToLogin);

        fAuth = FirebaseAuth.getInstance();
        progressBar = findViewById(R.id.progressBar);

        if(fAuth.getCurrentUser() !=null){
            startActivity(new Intent(getApplicationContext(),MainActivity.class));
            finish();
        }

        registerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = emailInput.getText().toString().trim();
                String password = passwordInput.getText().toString().trim();


                //Register condition
                if (TextUtils.isEmpty(email)) {

                    emailInput.setError("Email is required");
                    return;
                }

                if(TextUtils.isEmpty(password)) {
                    passwordInput.setError("Password is required");
                    return;

                }

                if(password.length() < 6){
                    passwordInput.setError("Password must have at least 6 characters");
                    return;
                }

                progressBar.setVisibility(View.VISIBLE);

                //register the user to firebase

                fAuth.createUserWithEmailAndPassword(email,password) .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if(task.isSuccessful()){
                            Toast.makeText(Register.this,"User created", Toast.LENGTH_SHORT).show();
                            startActivity(new Intent(getApplicationContext(), LogoDisplay.class));
                        }else{
                            Toast.makeText(Register.this,"Error!" + task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                            progressBar.setVisibility(View.GONE);
                        }
                    }
                });
            }
        });
        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), Login.class));
            }
        });


    }


}
