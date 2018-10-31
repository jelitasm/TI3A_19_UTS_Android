package com.example.jelit.ti3a_19_uts;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {

    EditText edtUsername, edtPassword;
    Button buttonLogin;
    SessionManagement sessionManagement;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        edtUsername = findViewById(R.id.editUsername);
        edtPassword = findViewById(R.id.editPassword);
        buttonLogin = findViewById(R.id.buttonLogin);

        sessionManagement = new SessionManagement(this);

        if(sessionManagement.isLoggedIn()){
            goToActivity();
        }
        buttonLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String username = edtUsername.getText().toString();
                String password = edtPassword.getText().toString();
                if(username.matches("") || username.trim().isEmpty() || password.matches("") || password.trim().isEmpty()){
                    Toast.makeText(LoginActivity.this,"Username dan Passsword Tidak Boleh Kosong / Space"
                            ,Toast.LENGTH_LONG).show();
                    return;
                }else {
                    sessionManagement.createLoginSession(username, password);
                    goToActivity();
                }
            }
        });
    }
    private void goToActivity(){
        Intent mIntent = new Intent(this,ProfilActivity.class);
        startActivity(mIntent);
    }
}
