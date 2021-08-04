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

public class MainActivity2 extends AppCompatActivity {

        Button show1;
        TextView textView8,textView9,textView10,textView11;
        DatabaseReference day2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        show1=(Button)findViewById(R.id.show1);
        textView8=(TextView)findViewById(R.id.textView8);
        textView9=(TextView)findViewById(R.id.textView9);
        textView10=(TextView)findViewById(R.id.textView10);
        textView11=(TextView)findViewById(R.id.textView11);

        show1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                day2= FirebaseDatabase.getInstance().getReference().child("Day2");
                day2.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot snapshot) {
                        String Date =snapshot.child("Date").getValue().toString();
                        String notice1=snapshot.child("notice1").getValue().toString();
                        String notice2=snapshot.child("notice2").getValue().toString();
                        String notice3=snapshot.child("notice3").getValue().toString();
                        //String notice4=snapshot.child("notice4").getValue().toString();

                        textView8.setText(Date);
                        textView9.setText(notice1);
                        textView10.setText(notice2);
                        textView11.setText(notice3);
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {

                    }
                });
            }
        });

    }
}