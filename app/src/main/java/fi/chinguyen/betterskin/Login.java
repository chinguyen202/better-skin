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

import fi.chinguyen.betterskin.data.User;


public class Login extends AppCompatActivity {

    EditText username, password;
    Button loginButton;
    TextView createNewAccount, guest;
    User user123;

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

        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String user = username.getText().toString();
                String pass = password.getText().toString();

                if (user.equals("") || pass.equals("")) {
                    Toast.makeText(Login.this, "Please enter all the fields", Toast.LENGTH_SHORT).show();
                }else{
                        Boolean checkUserPassword = user123.checkUsernamePassword(user, pass);
                        if (checkUserPassword == true) {
                            Toast.makeText(Login.this, "Sign in successful", Toast.LENGTH_SHORT).show();
                            Intent intent = new Intent(getApplicationContext(), LogoDisplay.class);
                            startActivity(intent);
                        } else {
                            Toast.makeText(Login.this, "Invalid credentials", Toast.LENGTH_SHORT).show();
                        }
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
        guest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick (View v){
                Intent intent = new Intent(getApplicationContext(), LogoDisplay.class);
                startActivity(intent);

            }
        });

    }
}
