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

    EditText userName, password, fullName, rePassword;
    Button registerButton;
    TextView goToLogin;
    User user;

    //Method to check if all required user input is empty or not
    private Boolean validateUser(User user) {
        if (user.getUsername().isEmpty() || user.getPassword().isEmpty() || user.getFullName().isEmpty()) {
            return false;
        }
        return true;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.register);

        //Call database
        AppDB appDB = AppDB.getInstance(getApplicationContext());
        AppDAO appDao = appDB.appDao();

        userName = findViewById(R.id.userNameInput);
        password = findViewById(R.id.passwordInput);
        fullName = findViewById(R.id.fullNameInput);
        registerButton = findViewById(R.id.registerButton);
        rePassword = findViewById(R.id.reTypePassword);
        goToLogin = findViewById(R.id.goToLogin);

        registerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //Get input from user
                String username = userName.getText().toString();
                String passWord = password.getText().toString();
                String fullname = fullName.getText().toString();
                String repass = rePassword.getText().toString();

                //Create an user in database with all information given by user
                user = new User();
                user.setUsername(username);
                user.setPassword(passWord);
                user.setFullName(fullname);

                if (appDao.getUserByUsername(username) == null) {
                    if (validateUser(user)) {
                        //Check if retype password is match or not
                        if (passWord.equals(repass)) {
                            //Check if username is already exist
                            //If password matched and username is not used yet, add user to database and go to next activity
                            appDao.registerUser(user);
                            Log.d("User", "user registered");
                            Intent intent = new Intent(getApplicationContext(), Login.class);
                            startActivity(intent);


                        } else {
                            //If mismatch, show message
                            Toast.makeText(Register.this, "Mismatch password", Toast.LENGTH_SHORT).show();
                        }
                    } else {
                        //Display message to ask for user input
                        Toast.makeText(getApplicationContext(), "Enter all information please!", Toast.LENGTH_SHORT).show();
                    }
                } else{
                    Toast.makeText(getApplicationContext(),"Username is taken. Use another one please!",Toast.LENGTH_SHORT).show();
                }
            }

        });

    }
}
