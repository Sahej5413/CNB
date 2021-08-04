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

public class MainActivity3 extends AppCompatActivity {
        Button show3;
        TextView textView5,textView6,textView7,textView12;
        DatabaseReference day3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        show3=(Button)findViewById(R.id.show3);
        textView5=(TextView)findViewById(R.id.textView5);
        textView6=(TextView)findViewById(R.id.textView6);
        textView7=(TextView)findViewById(R.id.textView7);
        textView12=(TextView)findViewById(R.id.textView12);

        show3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                day3= FirebaseDatabase.getInstance().getReference().child("Day3");
                day3.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot snapshot) {
                        String Date =snapshot.child("Date").getValue().toString();
                        String notice1=snapshot.child("notice1").getValue().toString();
                        String notice2=snapshot.child("notice2").getValue().toString();
                        String notice3=snapshot.child("notice3").getValue().toString();
                        //String notice4=snapshot.child("notice4").getValue().toString();

                        textView5.setText(Date);
                        textView6.setText(notice1);
                        textView7.setText(notice2);
                        textView12.setText(notice3);
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {

                    }
                });
            }
        });



    }
}