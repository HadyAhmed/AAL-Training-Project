package com.example.queizapp;

import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

/**
 * @author Hadi Ahmed
 * @version 1.0
 * this view is the main entry point for the application
 * handle login validation
 * @since 27th, Sep 2019
 */
public class MainActivity extends AppCompatActivity  {

    private static final String TAG = "MainActivityTag";

    // placeholder for validation on email and password
    private static final String EMAIL = "example@gmail.com";
    private static final String PASSWORD = "123456";

    private static final Integer PASSWORD_LENGTH = 6;

    private Button button;
    private EditText username, password;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button = findViewById(R.id.login_button);
        username = findViewById(R.id.username_et);
        password = findViewById(R.id.password_et);



        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (isValidInputs()) {
                    Intent startHomeActivity = new Intent(MainActivity.this, HomeActivity.class);
                    startActivity(startHomeActivity);
                } else {
                    Toast.makeText(MainActivity.this, "invalid credentials", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }

    private boolean isValidInputs() {
        String usernameString = username.getText().toString();
        String passwordString = password.getText().toString();
        return (usernameIsValid(usernameString) && passwordIsValid(passwordString));
    }

    private boolean passwordIsValid(String passwordString) {
        if (passwordString != null && passwordString.length() >= PASSWORD_LENGTH) {
            return true;
        } else {
            password.setError("Please Insert more then 6 characters");
            return false;
        }
    }

    /**
     * this method checks for username validation
     *
     * @param usernameString username (fetched from username edit text)
     * @return true if valid and false if invalid and error msg
     */
    private boolean usernameIsValid(String usernameString) {
        if (Patterns.EMAIL_ADDRESS.matcher(usernameString).matches() && usernameString.equals(EMAIL)) {
            return true;
        } else {
            username.setError("Please Insert Valid E-Mail");
            return false;
        }
    }

    /**
     * this method fetch username from the activity_main.xml with view R.id.username
     *
     * @return username
     */
    private String getUserName() {
        return username.getText().toString();
    }

    private String getPassword() {
        return password.getText().toString();
    }
}
