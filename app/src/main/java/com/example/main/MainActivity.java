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

public class MainActivity extends AppCompatActivity {

    Button show;
    TextView textView1,textView2,textView3,textView4;
    DatabaseReference day1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        show=(Button)findViewById(R.id.show);
        textView1=(TextView)findViewById(R.id.textView1);
        textView2=(TextView)findViewById(R.id.textView2);
        textView3=(TextView)findViewById(R.id.textView3);
        textView4=(TextView)findViewById(R.id.textView4);

        show.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                day1= FirebaseDatabase.getInstance().getReference().child("Day1");
                day1.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot snapshot) {

                        String Date=snapshot.child("Date").getValue().toString();
                        String notice1=snapshot.child("notice1").getValue().toString();
                        String notice2=snapshot.child("notice2").getValue().toString();
                        String notice3=snapshot.child("notice3").getValue().toString();

                        textView1.setText(Date);
                        textView2.setText(notice1);
                        textView3.setText(notice2);
                        textView4.setText(notice3);
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {

                    }
                });
            }
        });



    }
}