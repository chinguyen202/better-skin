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

import fi.chinguyen.betterskin.data.UserDao;
import fi.chinguyen.betterskin.data.UserDatabase;
import fi.chinguyen.betterskin.data.UserEntity;

public class Register extends AppCompatActivity {

    EditText fullName, userName, password, rePassword, phone;
    Button registerButton;
    TextView goToLogin;
    @Override
    protected void onCreate (Bundle savedInstanceState) {
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
                UserEntity userEntity = new UserEntity();
                userEntity.setUserId(userName.getText().toString());
                userEntity.setPassword(password.getText().toString());
                userEntity.setName(fullName.getText().toString());
                String repass = rePassword.getText().toString();
                if (validateInput(userEntity)) {
                        UserDatabase userDatabase = UserDatabase.getUserDatabase(getApplicationContext());
                        UserDao userDao = userDatabase.userDao();
                        new Thread(new Runnable() {
                            @Override
                            public void run() {
                                userDao.registerUser(userEntity);
                                Toast.makeText(getApplicationContext(), "User registered", Toast.LENGTH_SHORT).show();
                            }
                        });

                } else{
                    Toast.makeText(getApplicationContext(), "Fill all fields", Toast.LENGTH_SHORT).show();
                }
            }
        });

        goToLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent (getApplicationContext(), Login.class);
                startActivity(intent);

            }
        });
    }
    private Boolean validateInput(UserEntity userEntity) {
        if (userEntity.getName().isEmpty() || userEntity.getUserId().isEmpty() || userEntity.getUserId().isEmpty()) {
            return false;
        }
        return true;
    }
}
