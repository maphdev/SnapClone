package com.example.manon.snapclone.AppActivity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.manon.snapclone.R;

public class LoginActivity extends AppCompatActivity {

    private EditText editUsername;
    private EditText editPassword;
    private Button loginButton;
    private Button backButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        final Intent i = new Intent(this, MainActivity.class);
        loginButton = findViewById(R.id.loginButton);
        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(editUsername.getText().toString().equals("maphdev") && editPassword.getText().toString().equals("a")){
                    setResult(2);
                    startActivity(i);
                    finish();
                }
            }
        });

        backButton = findViewById(R.id.backButton);
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        editUsername = findViewById(R.id.login_username_edit);
        editUsername.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                checkColorEditText();
            }
        });

        editPassword = findViewById(R.id.login_password_edit);
        editPassword.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            }

            @Override
            public void afterTextChanged(Editable editable) {
                checkColorEditText();
            }
        });
    }

    private void checkColorEditText(){
        if (!TextUtils.isEmpty(editUsername.getText().toString()) && !TextUtils.isEmpty(editPassword.getText().toString())) {
            loginButton.setBackground(getResources().getDrawable(R.drawable.rounded_purple_button));
        } else {
            loginButton.setBackground(getResources().getDrawable(R.drawable.rounded_grey_button));
        }
    }
}
