package com.example.karthik.delta3;

import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
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
        String fname = vname;
        databaseHelper = new DatabaseHelper(getActivity());
        Log.d("CHECKING", "Inside fragment a");
        Retrofit retrofit = RetrofitClient.getRetrofit();
        APIinterface apIinterface = retrofit.create(APIinterface.class);

        Call<CharacterResponse> call = apIinterface.getCharacter(fname);
        call.enqueue(new Callback<CharacterResponse>() {
            @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
            @Override
            public void onResponse(Call<CharacterResponse> call, Response<CharacterResponse> response) {
                StringBuilder book = new StringBuilder();
                name.setText(response.body().getData().getName());
                house.setText(response.body().getData().getHouse());
                dob.setText(String.valueOf(response.body().getData().getDateOfBirth()));

                if (response.body().getData().getCulture() == null)
                    culture.setText("Not available");
                else
                    culture.setText(response.body().getData().getCulture());
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
                if (databaseHelper.getData(response.body().getData().getName()).getCount() == 0)
                    databaseHelper.addData(response.body().getData().getName(), response.body().getData().getDateOfBirth(), gen, response.body().getData().getHouse(), response.body().getData().getCulture(), book.toString());


            }

            @Override
            public void onFailure(Call<CharacterResponse> call, Throwable t) {
                Log.d("ERROR", t.getMessage());
            }
        });

        return view;
    }
}
