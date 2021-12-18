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

/**
 * This class purpose is allow user to login their account
 */

//I do this one with youtube support https://www.youtube.com/watch?v=5yghiEUyeHY
public class Login extends AppCompatActivity {

    EditText username, password;
    Button loginButton;
    TextView createNewAccount;
    AppDB appDB;
    AppDAO appDao;

    /**
     * set up login button and logic
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);

        //Create a shared preference to save user input
        SharedPreferences loginUser = getSharedPreferences("login", Activity.MODE_PRIVATE);
        SharedPreferences.Editor editor = loginUser.edit();

        username = findViewById(R.id.userNameInput);
        password = findViewById(R.id.passwordInput);
        loginButton = findViewById(R.id.loginButton);
        createNewAccount = findViewById(R.id.goToRegister);

        //When user click Login button
        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String userName = username.getText().toString();
                String passWord = password.getText().toString();

                //set condition to check user input
                if (userName.isEmpty() || passWord.isEmpty()) {
                    Toast.makeText(getApplicationContext(), "Fill username and password please!", Toast.LENGTH_SHORT).show();

                } else {
                    //Call database
                    appDB= AppDB.getInstance(getApplicationContext());
                    appDao = appDB.appDao();
                    new Thread(new Runnable() {
                        @Override
                        public void run() {
                            //Check from users table if there is a user has same info as user input
                            User user = appDao.logIn(userName, passWord);
                            //If not, then create a pop up with message
                            if (user == null) {
                                runOnUiThread(new Runnable() {
                                    @Override
                                    public void run() {
                                        Toast.makeText(getApplicationContext(), "Invalid password or username!", Toast.LENGTH_SHORT).show();
                                    }
                                });

                            } else {
                                //If user exist in database, go to Profile activity
                                startActivity(new Intent(getApplicationContext(), Profile.class));
                            }
                        }

                    }).start();
                }
                //save data to sharePreference
                editor.putString("userName", userName);
                editor.putString("password", passWord);
                editor.apply();
            }

        });

        /**
         * When user click, go to Register activity
         */
        createNewAccount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), Register.class);
                startActivity(intent);

            }
        });

    }



}

