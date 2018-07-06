package com.example.karthik.delta3;


import android.content.Intent;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.karthik.delta3.CharcterByName.CharacterResponse;
import com.example.karthik.delta3.CharcterByName.Data;
import com.squareup.picasso.Picasso;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public class MainActivity extends AppCompatActivity {
    public static EditText searchText;
    ImageButton button;
    ViewPager viewPager;
    private TabLayout tabLayout;
    public static String vname;
    ImageView imageView;
    String BASE_URL = "https://api.got.show/api";
    int flag;

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.menu_item_new_quote: { // TODO put your code here to respond to the button tap
                Intent intent = new Intent(MainActivity.this, History.class);
                startActivity(intent);
                return true;
            }
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    @Override

    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_example, menu);
        return true;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        searchText = (EditText) findViewById(R.id.search);

        //   tabLayout = (TabLayout) findViewById(R.id.tabs);
        button = (ImageButton) findViewById(R.id.button);

        //  final pageAdapter adapter = new pageAdapter(getSupportFragmentManager());
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                vname = searchText.getText().toString();
                FragmentA fragment = new FragmentA();
                android.app.FragmentTransaction transaction = getFragmentManager().beginTransaction();
                searchText.clearFocus();
                searchText.setText("");
                transaction.replace(R.id.myLayout, fragment, "Details");
                transaction.commit();
                //  viewPager.setAdapter(adapter);
                //tabLayout.setupWithViewPager(viewPager);


            }
        });


       /* Retrofit retrofit = RetrofitClient.getRetrofit();
        APIinterface apIinterface = retrofit.create(APIinterface.class);

        Call<CharacterResponse> call = apIinterface.getCharacter("Ygritte");
        call.enqueue(new Callback<CharacterResponse>() {
            @Override
            public void onResponse(Call<CharacterResponse> call, Response<CharacterResponse> response) {
                Log.d("Checks", response.body().getData().getHouse());
                Picasso.with(MainActivity.this).load(response.body().getData().getImageLink()).into(imageView);
            }

            @Override
            public void onFailure(Call<CharacterResponse> call, Throwable t) {
                Log.d("ERROR", t.getMessage());
            }
        });*/


    }

  /*  class pageAdapter extends FragmentPagerAdapter {


        public pageAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            if (position == 0)
                return new FragmentA();
            if (position == 1)
                return new FragmentB();


            return null;

        }

        @Override
        public int getCount() {
            return 2;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            if (position == 0)
                return "Details";
            if (position == 1)
                return "List";

            return null;
        }
    }
*/

}
