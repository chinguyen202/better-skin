package fi.chinguyen.betterskin;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import fi.chinguyen.betterskin.data.AppDAO;
import fi.chinguyen.betterskin.data.AppDB;
import fi.chinguyen.betterskin.data.User;

public class Register extends AppCompatActivity {

    EditText userName, password,fullName, rePassword;
    Button registerButton;
    TextView goToLogin;
    User user;

    @Override
    protected void onCreate (Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.register);

        //Call database
        AppDB userDB = AppDB.getInstance(getApplicationContext());
        AppDAO userDao = userDB.appDao();

        userName = findViewById(R.id.userNameInput);
        password = findViewById(R.id.passwordInput);
        fullName = findViewById(R.id.fullNameInput);
        registerButton = findViewById(R.id.registerButton);
        rePassword = findViewById(R.id.reTypePassword);
        goToLogin = findViewById(R.id.goToLogin);

        registerButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                //Create an user in database with all information given by user
                user = new User();
                String username = userName.getText().toString();
                user.setUsername(username);
                user.setPassword(password.getText().toString());
                user.setFullName(fullName.getText().toString());
                String repass = rePassword.getText().toString();

                //Condition to check user input
                if (validateUser(user)) {
                    //set condition for matching password
                    //If they are matched, add user to database
                    if (user.getPassword().equals(rePassword.getText().toString())) {
                        new Thread(new Runnable() {
                            @Override
                            public void run() {
                                userDao.registerUser(user);
                                Log.d("User", "user registered");
                            }
                        }).start();
                        //Go to Login
                        Intent intent = new Intent(getApplicationContext(), Login.class);
                        startActivity(intent);

                    } else {
                        //If retype password is not match, display message
                        Toast.makeText(Register.this, "Passwords is not matching", Toast.LENGTH_SHORT).show();


                    }
                } else {
                    //Display message to ask for user input
                    Toast.makeText(getApplicationContext(), "Enter all information please!", Toast.LENGTH_SHORT).show();
                }

            }

        });

    }
    //Method to check if all required user input is empty or not
    private Boolean validateUser(User user){
        if(user.getUsername().isEmpty() || user.getPassword().isEmpty() ||user.getFullName().isEmpty()){
            return false;
        }
        return true;

    }
}
