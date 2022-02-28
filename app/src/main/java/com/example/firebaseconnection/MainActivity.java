 package com.example.firebaseconnection;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.FirebaseApp;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

 public class MainActivity extends AppCompatActivity {
    EditText ed;
    Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ed = (EditText) findViewById(R.id.name);
        btn = (Button) findViewById(R.id.button);
        FirebaseApp.initializeApp(this);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String uname  = ed.getText().toString();
                FirebaseDatabase db = FirebaseDatabase.getInstance();
                DatabaseReference table = db.getReference();
                table.setValue(uname);
                Toast.makeText(MainActivity.this, "Data Added", Toast.LENGTH_SHORT).show();

            }
        });


    }
}