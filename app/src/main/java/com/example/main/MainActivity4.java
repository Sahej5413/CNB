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

public class MainActivity4 extends AppCompatActivity {

    Button show4;
    TextView textView13,textView14,textView15,textView16;
    DatabaseReference day4;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);

        show4=(Button)findViewById(R.id.show4);
        textView13=(TextView)findViewById(R.id.textView13);
        textView14=(TextView)findViewById(R.id.textView14);
        textView15=(TextView)findViewById(R.id.textView15);
        textView16=(TextView)findViewById(R.id.textView16);

        show4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                day4= FirebaseDatabase.getInstance().getReference().child("Day4");
                day4.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot snapshot) {

                        String Date=snapshot.child("Date").getValue().toString();
                        String notice1=snapshot.child("notice1").getValue().toString();
                        String notice2=snapshot.child("notice2").getValue().toString();
                        String notice3=snapshot.child("notice3").getValue().toString();

                        textView13.setText(Date);
                        textView14.setText(notice1);
                        textView15.setText(notice2);
                        textView16.setText(notice3);
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {

                    }
                });
            }
        });

    }
}