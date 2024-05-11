package com.example.smd_3;

import android.content.Intent;
import android.content.Context;
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

public class MainActivity extends AppCompatActivity {
EditText etun,etpwd;
Button Btnlogin,Btnsignup;
 Context c;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
//
        Btnlogin=findViewById(R.id.Btnlogin);
        Btnsignup=findViewById(R.id.Btnsignup);
        c=this;
        Btnlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!etun.getText().toString().isEmpty()&&!etpwd.getText().toString().isEmpty()) {
                    MyDatabaseHelper database = new MyDatabaseHelper(c);
                    database.open();
                    if (!database.checkUsernameExists(etun.getText().toString().trim())) {
                        if (database.loggedin(etun.getText().toString(), etpwd.getText().toString())) {
                            startActivity(new Intent(MainActivity.this, home.class));
                        }
                        else
                        {
                            Toast.makeText(c,"Wrong credentials" , Toast.LENGTH_SHORT).show();
                        }
                    }
                }
                else
                {
                    Toast.makeText(c,"kuch tou likh bhai" , Toast.LENGTH_SHORT).show();
                }

            }
        });

        Btnsignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, signup.class));

            }
        });
    }


}