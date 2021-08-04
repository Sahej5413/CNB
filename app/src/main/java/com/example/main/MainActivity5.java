package com.example.main;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class MainActivity5 extends AppCompatActivity {

    Button show5;
    TextView textView17,textView18,textView19,textView20;
    DatabaseReference day5;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main5);

        show5=(Button)findViewById(R.id.show5);
        textView17=(TextView)findViewById(R.id.textView17);
        textView18=(TextView)findViewById(R.id.textView18);
        textView19=(TextView)findViewById(R.id.textView19);
        textView20=(TextView)findViewById(R.id.textView20);

        show5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                day5= FirebaseDatabase.getInstance().getReference().child("Day5");
                day5.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot snapshot) {

                        String Date=snapshot.child("Date").getValue().toString();
                        String notice1=snapshot.child("notice1").getValue().toString();
                        String notice2=snapshot.child("notice2").getValue().toString();
                        String notice3=snapshot.child("notice3").getValue().toString();

                        textView17.setText(Date);
                        textView18.setText(notice1);
                        textView19.setText(notice2);
                        textView20.setText(notice3);
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {

                        Toast.makeText(MainActivity5.this, "No Internet !",Toast.LENGTH_LONG).show();
                    }
                });
            }
        });

    }
}