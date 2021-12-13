package fi.chinguyen.betterskin;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import fi.chinguyen.betterskin.data.User;

public class Register extends AppCompatActivity {

    EditText userName, password, rePassword;
    Button registerButton;
    TextView goToLogin;
    User user123;
    @Override
    protected void onCreate (Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.register);


        userName = findViewById(R.id.userNameInput);
        password = findViewById(R.id.passwordInput);
        rePassword = findViewById(R.id.reTypePassword);
        registerButton = findViewById(R.id.registerButton);
        goToLogin = findViewById(R.id.goToLogin);
     //   user123 = new User(this);
/*
        registerButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                String user = userName.getText().toString();
                String pass = password.getText().toString();
                String repass = rePassword.getText().toString();

                if(user.equals("")||pass.equals("")||repass.equals("")) {
                    Toast.makeText(Register.this, "Please enter all the fields", Toast.LENGTH_SHORT).show();
                }else{
                    if(pass.equals(repass)){
                        Boolean checkUsername = user123.checkUsername(user);
                        if(checkUsername==false){
                            Boolean insert = user123.insertData(user, pass);
                            if(insert==true){
                                Toast.makeText(Register.this, "Registered successfully", Toast.LENGTH_SHORT).show();
                                Intent intent = new Intent(getApplicationContext(),Login.class);
                                startActivity(intent);
                            }else{
                                Toast.makeText(Register.this, "Registration failed", Toast.LENGTH_SHORT).show();
                            }
                        }
                        else{
                            Toast.makeText(Register.this, "User already exists! Please sign in", Toast.LENGTH_SHORT).show();
                        }
                    }else{
                        Toast.makeText(Register.this, "Passwords is not matching", Toast.LENGTH_SHORT).show();
                    }
                } }
        });

        goToLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent (getApplicationContext(),Login.class);
                startActivity(intent);

            }
        });*/
    }
}
