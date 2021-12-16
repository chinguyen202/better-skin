package fi.chinguyen.betterskin;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import fi.chinguyen.betterskin.data.AppDAO;
import fi.chinguyen.betterskin.data.AppDB;
import fi.chinguyen.betterskin.data.User;


public class Login extends AppCompatActivity {

    EditText username, password;
    Button loginButton;
    TextView createNewAccount;
    AppDB appDB;
    AppDAO appDao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);

        SharedPreferences loginUser = getSharedPreferences("login", Activity.MODE_PRIVATE);
        SharedPreferences.Editor editor = loginUser.edit();
        username = findViewById(R.id.userNameInput);
        password = findViewById(R.id.passwordInput);
        loginButton = findViewById(R.id.loginButton);
        createNewAccount = findViewById(R.id.goToRegister);

        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String userName = username.getText().toString();
                String passWord = password.getText().toString();
                if (userName.isEmpty() || passWord.isEmpty()) {
                    Toast.makeText(getApplicationContext(), "Fill username and password please!", Toast.LENGTH_SHORT).show();

                } else {
                    //Query from database
                    appDB= AppDB.getInstance(getApplicationContext());
                    appDao = appDB.appDao();
                    new Thread(new Runnable() {
                        @Override
                        public void run() {
                            User user = appDao.logIn(userName, passWord);
                            if (user == null) {
                                runOnUiThread(new Runnable() {
                                    @Override
                                    public void run() {
                                        Toast.makeText(getApplicationContext(), "Invalid password or username!", Toast.LENGTH_SHORT).show();
                                    }
                                });

                            } else {
                                String userInfo = appDao.getAllUser().toString();
                                startActivity(new Intent(getApplicationContext(), Profile.class));
                            }
                        }

                    }).start();
                }
                editor.putString("userName", userName);
                editor.putString("password", passWord);
                editor.apply();
            }

        });
        createNewAccount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), Register.class);
                startActivity(intent);

            }
        });

    }



}

