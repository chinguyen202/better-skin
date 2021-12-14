package fi.chinguyen.betterskin;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import fi.chinguyen.betterskin.data.AppDB;
import fi.chinguyen.betterskin.data.User;
import fi.chinguyen.betterskin.data.UserDao;

public class Register extends AppCompatActivity {

    EditText userName, password,fullName;
    Button registerButton;
    TextView goToLogin;

    @Override
    protected void onCreate (Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.register);

        userName = findViewById(R.id.userNameInput);
        password = findViewById(R.id.passwordInput);
        fullName = findViewById(R.id.fullNameInput);
        registerButton = findViewById(R.id.registerButton);
        goToLogin = findViewById(R.id.goToLogin);

        registerButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                //Create an user
                User user = new User();
                user.setUsername(userName.getText().toString());
                user.setPassword(password.getText().toString());
                user.setFullName(fullName.getText().toString());

                if(validateUser(user)){
                    //insert user to database
                    AppDB userDB = AppDB.getInstance(getApplicationContext());
                    UserDao userDao = userDB.userDao();
                    new Thread(new Runnable() {
                        @Override
                        public void run() {
                            userDao.registerUser(user);
                        }
                    }).start();
                    Intent intent = new Intent (getApplicationContext(),Welcome.class);
                    startActivity(intent);

                }else{
                    Toast.makeText(getApplicationContext(),"Enter all information please!",Toast.LENGTH_SHORT).show();
                }

            }

        });

        goToLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent (getApplicationContext(),Login.class);
                startActivity(intent);

            }
        });
    }

    private Boolean validateUser(User user){
        if(user.getUsername().isEmpty() || user.getPassword().isEmpty() ||user.getFullName().isEmpty()){
            return false;
        }
        return true;

    }
}
