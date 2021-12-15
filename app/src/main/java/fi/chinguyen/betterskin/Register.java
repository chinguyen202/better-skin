package fi.chinguyen.betterskin;

import android.content.Intent;
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

    EditText userName, passWord,fullName;
    Button registerButton;
    TextView goToLogin;
    User user,registerUser;
    private AppDAO appDAO;
    private AppDB appDB;

    @Override
    protected void onCreate (Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.register);

        appDB = AppDB.getInstance(getApplicationContext());
        appDAO = appDB.appDao();

        userName = findViewById(R.id.userNameInput);
        passWord = findViewById(R.id.passwordInput);
        fullName = findViewById(R.id.fullNameInput);
        registerButton = findViewById(R.id.registerButton);
        goToLogin = findViewById(R.id.goToLogin);


        registerButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                //Create an user
                user = new User();
                user.setUsername(userName.getText().toString());
                user.setPassword(passWord.getText().toString());
                user.setFullName(fullName.getText().toString());


                if(validateUser(user)){
                    Intent intent = new Intent (getApplicationContext(),Welcome.class);
                    appDAO.registerUser(user);
                    intent.putExtra("registerUser",user);
                    startActivity(intent);
                    finish();

                }else{
                    Toast.makeText(getApplicationContext(),"Enter all information please!",Toast.LENGTH_SHORT).show();
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

    private Boolean validateUser(User user){
        if(user.getUsername().isEmpty() || user.getPassword().isEmpty() ||user.getFullName().isEmpty()){
            return false;
        }
        return true;

    }
}
