package com.example.smd_3;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class signup extends AppCompatActivity {
Button ssign;
EditText sname,suser,spass;
Context c;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.signup);
        ssign=findViewById(R.id.ssign);
        sname=findViewById(R.id.sname);
        suser=findViewById(R.id.suser);
        spass=findViewById(R.id.spass);
        c=this;

        ssign.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!sname.getText().toString().isEmpty()&&!suser.getText().toString().isEmpty()&&!spass.getText().toString().isEmpty()) {
                    MyDatabaseHelper database = new MyDatabaseHelper(c);
                    database.open();
                    if (!database.checkUsernameExists(suser.getText().toString().trim())) {
                        database.signup(sname.getText().toString().trim(), suser.getText().toString().trim(), spass.getText().toString().trim());
                        startActivity(new Intent(signup.this, MainActivity.class));
                        finish();
                    } else {
                        Toast.makeText(c, "User already exists", Toast.LENGTH_SHORT).show();
                    }
                    database.close();

                }
                else
                {
                    Toast.makeText(c, "At least enter something", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
