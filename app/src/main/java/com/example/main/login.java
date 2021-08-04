package com.example.main;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class login extends AppCompatActivity {

    TextView user, password;
    Button login;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        user=(TextView)findViewById(R.id.user);
        password=(TextView)findViewById(R.id.password);
        login=(Button)findViewById(R.id.login);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String uuser=user.getText().toString();
                String upassword = password.getText().toString();
                if ((uuser.equals("KIST") && upassword.equals("kist@123"))) {

                    Intent intent = new Intent(login.this, Day.class);
                    startActivity(intent);
                } else {
                    Toast.makeText(login.this, "Please Enter Valid Id or Password", Toast.LENGTH_SHORT).show();
                }
                //after fill up the data it will be blank
                user.setText("");
                password.setText("");
            }
        });


    }
}