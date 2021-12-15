package fi.chinguyen.betterskin;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
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

        appDB= AppDB.getInstance(getApplicationContext());
        appDao = appDB.appDao();

        username = findViewById(R.id.userNameInput);
        password = findViewById(R.id.passwordInput);
        loginButton = findViewById(R.id.loginButton);
        createNewAccount = findViewById(R.id.goToRegister);

        loginButton.setOnClickListener(new View.OnClickListener() {
                                           @Override
                                           public void onClick(View v) {
                                               String userName = username.getText().toString();
                                               String passWord = password.getText().toString();
                                               User user = appDao.getUser(userName, passWord);

                                               if (user != null) {
                                                   Intent intent = new Intent(getApplicationContext(), Profile.class);
                                                   intent.putExtra("User", user);
                                                   startActivity(intent);
                                                   finish();
                                               } else {
                                                   Toast.makeText(getApplicationContext(), "User not found or invalid credentials", Toast.LENGTH_SHORT).show();
                                               }

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

