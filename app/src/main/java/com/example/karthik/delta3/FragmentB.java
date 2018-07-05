package com.example.karthik.delta3;

import android.database.Cursor;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

/**
 * Created by karthik on 04-07-2018.
 */

public class FragmentB extends Fragment {
    ListView list;
    DatabaseHelper databaseHelper;
    ArrayList<String> sname = new ArrayList<>();

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_b, container, false);
        databaseHelper = new DatabaseHelper(getActivity());
        list = (ListView) view.findViewById(R.id.storedName);
        Cursor data = databaseHelper.getAllData();
        sname.clear();
        while (data.moveToNext()) {
            sname.add(data.getString(1));
            Log.d("LOGGING", data.getString(1));
        }

        ArrayAdapter<String> sadapter = new ArrayAdapter<>(getActivity(), android.R.layout.simple_list_item_1, sname);

        list.setAdapter(sadapter);
        return view;
    }


}
