package fi.chinguyen.betterskin;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import fi.chinguyen.betterskin.data.AppDB;
import fi.chinguyen.betterskin.data.User;
import fi.chinguyen.betterskin.data.UserDao;


public class Login extends AppCompatActivity {

    EditText username, password;
    Button loginButton;
    TextView createNewAccount;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);

        username = findViewById(R.id.userNameInput);
        password = findViewById(R.id.passwordInput);
        loginButton = findViewById(R.id.loginButton);
        createNewAccount = findViewById(R.id.goToRegister);
    }
}


       // user123 = new User(this);
/*
        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String userName = username.getText().toString();
                String passWord = password.getText().toString();

                if (userName.isEmpty() || passWord.isEmpty()) {
                    Toast.makeText(getApplicationContext(), "Fill username and password please!", Toast.LENGTH_SHORT).show();

                } else {
                    //Query from database
                    AppDB userDB = AppDB.getInstance(getApplicationContext());
                    UserDao userDao = userDB.userDao();
                    new Thread(new Runnable() {
                        @Override
                        public void run() {
                            User user = userDao.logIn(userName, passWord);
                            if (user == null) {
                                runOnUiThread(new Runnable() {
                                    @Override
                                    public void run() {
                                        Toast.makeText(getApplicationContext(), "Invalid password or username!", Toast.LENGTH_SHORT).show();
                                    }
                                });

                            } else {
                                //int userID = userDao.getUserID();
                                String username = userDao.getUsername();
                                String fullName = userDao.getFullname();
                                startActivity(new Intent(getApplicationContext(), Profile.class));
                            }
                        }

                    }).start();
                }
            }

        });
        createNewAccount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick (View v){
                Intent intent = new Intent(getApplicationContext(), Register.class);
                startActivity(intent);

            }
        });

<<<<<<< HEAD
<<<<<<< HEAD
            }
        });
=======
<<<<<<< HEAD
            }
        });*/

