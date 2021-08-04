package com.example.main;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Day extends AppCompatActivity {

    Button button2,button3,button4,button5,button6,button7;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_day);

        button2=(Button)findViewById(R.id.button2);//Monday
        button3=(Button)findViewById(R.id.button3);//tuesday
        button4=(Button)findViewById(R.id.button4);//wednesday
        button5=(Button)findViewById(R.id.button5);//thursday
        button6=(Button)findViewById(R.id.button6);//friday
        button7=(Button)findViewById(R.id.button7);//saturday

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent =new Intent(Day.this,MainActivity.class);
                startActivity(intent);
            }
        });

        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent =new Intent(Day.this,MainActivity2.class);
                startActivity(intent);
            }
        });

      button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent =new Intent(Day.this,MainActivity3.class);
                startActivity(intent);
            }
        });



        button5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent =new Intent(Day.this,MainActivity4.class);
                startActivity(intent);
            }
        });


        button6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent =new Intent(Day.this,MainActivity5.class);
                startActivity(intent);
            }
        });

        button7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent =new Intent(Day.this,MainActivity6.class);
                startActivity(intent);
            }
        });


    }
}