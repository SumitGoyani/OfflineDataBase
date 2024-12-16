package com.example.offlinedatabase;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

public class FirstActivity extends AppCompatActivity {

    ListView listview;

    ArrayList<User> userlist = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first);

        listview = findViewById(R.id.listview);

        getData();
        findViewById(R.id.floatBtn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(FirstActivity.this, MainActivity.class);
                startActivity(intent);
//                startActivity(new Intent(FirstActivity.this, MainActivity.class).putExtra("","").putExtra("",""));
//                finish();
            }
        });


    }

    void getData()
    {
        DBHelper dbHelper = new DBHelper(FirstActivity.this);

       Cursor cursor =  dbHelper.viewData();

       while (cursor.moveToNext())
       {
           int id = cursor.getInt(0);
           String name= cursor.getString(1);
           String contact= cursor.getString(3);

           User user = new User(id,name,contact);
           userlist.add(user);
       }


       UserAdapter userAdapter = new UserAdapter(FirstActivity.this,userlist);
       listview.setAdapter(userAdapter);
    }
}