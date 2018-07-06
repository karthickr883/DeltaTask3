package com.example.karthik.delta3;

import android.content.Intent;
import android.database.Cursor;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

public class DetailsData extends AppCompatActivity {
    DatabaseHelper databaseHelper;
    ImageView image;
    TextView name, house, gender, culture, books, dob;

    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details_data);
        Bundle bundle = getIntent().getExtras();
        image = (ImageView) findViewById(R.id.imageView2);
        name = (TextView) findViewById(R.id.charName);
        house = (TextView) findViewById(R.id.charHouse);
        gender = (TextView) findViewById(R.id.charGender);
        culture = (TextView) findViewById(R.id.charCulture);
        books = (TextView) findViewById(R.id.charBooks);
        dob = (TextView) findViewById(R.id.charDob);
        String gname = bundle.getString("CharName");
        databaseHelper = new DatabaseHelper(this);
        Cursor data = databaseHelper.getData(gname);
        Log.d("DATA", String.valueOf(data.getCount()));
        String value = "no";
        while (data.moveToNext()) {

            name.setText(data.getString(1));
            dob.setText(data.getString(2));
            house.setText(data.getString(4));
            gender.setText(data.getString(3));
            culture.setText(data.getString(5));
            books.setText(data.getString(6));
            if (data.getString(7).trim().equalsIgnoreCase(value.trim())) {
                image.setImageResource(R.drawable.no_image);
            } else {
                Log.d("CHecking Link", data.getString(7));
                Picasso.with(this).load(data.getString(7)).into(image);
            }
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_2, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.home_menu) {
            Intent intent = new Intent(DetailsData.this, MainActivity.class);
            startActivity(intent);
            return true;
        } else if (id == R.id.list_menu) {
            Intent intent = new Intent(DetailsData.this, History.class);
            startActivity(intent);
            return true;

        } else
            return super.onOptionsItemSelected(item);
    }
}
