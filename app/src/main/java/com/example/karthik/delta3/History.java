package com.example.karthik.delta3;

import android.content.Intent;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class History extends AppCompatActivity {
    ListView list;
    DatabaseHelper databaseHelper;
    ArrayList<String> sname = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_history);
        databaseHelper = new DatabaseHelper(History.this);
        list = (ListView) findViewById(R.id.storedName);
        Cursor data = databaseHelper.getAllData();
        sname.clear();
        while (data.moveToNext()) {
            sname.add(data.getString(1));
            Log.d("LOGGING", data.getString(1));
        }

        ArrayAdapter<String> sadapter = new ArrayAdapter<>(History.this, android.R.layout.simple_list_item_1, sname);

        list.setAdapter(sadapter);

        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(History.this, DetailsData.class);
                Bundle bundle = new Bundle();
                String putString = (String) list.getItemAtPosition(position);
                bundle.putString("CharName",putString);
                intent.putExtras(bundle);
                startActivity(intent);
            }
        });


    }
}
