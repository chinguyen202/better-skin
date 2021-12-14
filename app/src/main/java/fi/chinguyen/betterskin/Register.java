package fi.chinguyen.betterskin;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import fi.chinguyen.betterskin.data.UserDao;
import fi.chinguyen.betterskin.data.UserDatabase;
import fi.chinguyen.betterskin.data.UserEntity;

public class Register extends AppCompatActivity {

    EditText fullName, userName, password, rePassword;
    Button registerButton;
    TextView goToLogin;

    private Boolean validateInput(UserEntity userEntity) {
        return !(userEntity.getName().isEmpty() || userEntity.getUserId().isEmpty() || userEntity.getPassword().isEmpty()) ;
    }


    @Override
        protected void onCreate (Bundle savedInstanceState){
            super.onCreate(savedInstanceState);
            setContentView(R.layout.register);

            fullName = findViewById(R.id.fullNameInput);
            userName = findViewById(R.id.userNameInput);
            password = findViewById(R.id.passwordInput);
            rePassword = findViewById(R.id.reTypePassword);
            registerButton = findViewById(R.id.registerButton);
            goToLogin = findViewById(R.id.goToLogin);


            registerButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Log.d("Register", "register button");
                    UserEntity userEntity = new UserEntity();
                    userEntity.setUserId(userName.getText().toString());
                    userEntity.setPassword(password.getText().toString());
                    userEntity.setName(fullName.getText().toString());
                    String repass = rePassword.getText().toString();
                    if (validateInput(userEntity)) {
                        Log.d("register", "password match " + userEntity.getPassword() + " , " + repass);
                        if (userEntity.getPassword().equals(repass)) {
                            UserDatabase userDatabase = UserDatabase.getUserDatabase(getApplicationContext());
                            UserDao userDao = userDatabase.userDao();
                            Log.d("register", "onClick: ready to database ");
                            Thread thread = new Thread(new Runnable() {
                                @Override
                                public void run() {
                                    Log.d("register", "run: background process " + userEntity);
                                     userDao.registerUser(userEntity);
                                     // search how to get context
                                     Toast.makeText(getApplicationContext(), "User registered" , Toast.LENGTH_SHORT).show();
                                    Log.d("register", "User registered " );
                                }
                            });
                            thread.start();
                        } else {
                            Toast.makeText(Register.this, "Passwords is not matching", Toast.LENGTH_SHORT).show();
                        }

                    } else {
                        Toast.makeText(getApplicationContext(), "Fill all fields", Toast.LENGTH_SHORT).show();
                    }
                }
            });

            goToLogin.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(getApplicationContext(), Login.class);
                    startActivity(intent);

                }
            });
        }

}
