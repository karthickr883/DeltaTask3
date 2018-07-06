package com.example.karthik.delta3;

import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.karthik.delta3.CharcterByName.CharacterResponse;
import com.squareup.picasso.Picasso;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

import static com.example.karthik.delta3.MainActivity.vname;

/**
 * Created by karthik on 04-07-2018.
 */

public class FragmentA extends android.app.Fragment {
    TextView name, house, gender, culture, books, dob;
    DatabaseHelper databaseHelper;
    String BASE_URL = "https://api.got.show/api";
    String URL = "https://api.got.show/";
    ImageView imageView;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_a, container, false);
        name = (TextView) view.findViewById(R.id.charName);
        house = (TextView) view.findViewById(R.id.charHouse);
        gender = (TextView) view.findViewById(R.id.charGender);
        culture = (TextView) view.findViewById(R.id.charCulture);
        books = (TextView) view.findViewById(R.id.charBooks);
        dob = (TextView) view.findViewById(R.id.charDob);
        imageView = (ImageView) view.findViewById(R.id.imageView2);
        String fname = vname;
        databaseHelper = new DatabaseHelper(getActivity());

        Retrofit retrofit = RetrofitClient.getRetrofit();
        APIinterface apIinterface = retrofit.create(APIinterface.class);

        Call<CharacterResponse> call = apIinterface.getCharacter(fname);
        call.enqueue(new Callback<CharacterResponse>() {
            @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
            @Override
            public void onResponse(Call<CharacterResponse> call, Response<CharacterResponse> response) {
                StringBuilder book = new StringBuilder();
                String temp_name, temp_house, temp_culture;
                String age;
                if (response.body().getData().getDateOfBirth() != null)
                    age = Integer.toString(response.body().getData().getDateOfBirth());
                else
                    age = "Not available";
                if (response.body().getData().getName() != null)
                    temp_name = response.body().getData().getName();
                else
                    temp_name = "Not available";
                if (response.body().getData().getHouse() != null)
                    temp_house = response.body().getData().getName();
                else
                    temp_house = "Not available";
                if (response.body().getData().getCulture() != null)
                    temp_culture = response.body().getData().getCulture();
                else
                    temp_culture = "Not available";

                Log.d("CHECKING", temp_name);
                name.setText(temp_name);
                house.setText(temp_house);
                dob.setText(String.valueOf(age));
                culture.setText(temp_culture);
                List<String> list = response.body().getData().getBooks();
                for (int i = 0; i < list.size(); i++) {
                    if (i == list.size() - 1)
                        book.append(list.get(i));
                    else
                        book.append(list.get(i) + ",");

                }
                String gen;
                books.setText(book);
                boolean g = response.body().getData().getMale();
                if (g == true) {
                    gender.setText("Male");
                    gen = "Male";
                } else {
                    gender.setText("Female");
                    gen = "Female";
                }
                String link;
                if (response.body().getData().getImageLink() == null)
                    link = "No";
                else
                    link = URL + response.body().getData().getImageLink();
                Log.d("IMAGE",link);
                if (link!="No")
                Picasso.with(getActivity()).load(link).into(imageView);
                else
                    imageView.setImageResource(R.drawable.no_image);
                if (databaseHelper.getData(temp_name).getCount() == 0) {

                    databaseHelper.addData(temp_name, age, gen, temp_house, temp_culture, book.toString(), link);

                }

            }

            @Override
            public void onFailure(Call<CharacterResponse> call, Throwable t) {
                Log.d("ERROR", t.getMessage());
            }
        });

        return view;
    }
}
