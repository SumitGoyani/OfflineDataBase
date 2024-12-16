package com.example.offlinedatabase;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button submit;
    EditText ename,econtact;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        submit = findViewById(R.id.submit);
        ename = findViewById(R.id.ename);
        econtact = findViewById(R.id.econtact);

        Toast.makeText(this, "", Toast.LENGTH_SHORT).show();
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String name = ename.getText().toString();
                String contact = econtact.getText().toString();

                DBHelper dbHelper = new DBHelper(MainActivity.this);
                dbHelper.insertData(name, contact);

            }
        });

    }
}