package com.example.main;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class MainActivity6 extends AppCompatActivity {

    Button show6;
    TextView textView21,textView22,textView23,textView24;
    DatabaseReference day6;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main6);

        show6=(Button)findViewById(R.id.show6);
        textView21=(TextView)findViewById(R.id.textView21);
        textView22=(TextView)findViewById(R.id.textView22);
        textView23=(TextView)findViewById(R.id.textView23);
        textView24=(TextView)findViewById(R.id.textView24);

        show6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                day6= FirebaseDatabase.getInstance().getReference().child("Day6");
                day6.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot snapshot) {

                        String Date=snapshot.child("Date").getValue().toString();
                        String notice1=snapshot.child("notice1").getValue().toString();
                        String notice2=snapshot.child("notice2").getValue().toString();
                        String notice3=snapshot.child("notice3").getValue().toString();

                        textView21.setText(Date);
                        textView22.setText(notice1);
                        textView23.setText(notice2);
                        textView24.setText(notice3);
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {

                    }
                });
            }
        });

    }
}