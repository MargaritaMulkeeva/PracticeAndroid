package com.example.practice1;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

public class CreateCollectionFragment extends Fragment {

    Button btn_select;
    EditText et_name;


    public CreateCollectionFragment() {
    }

    public static CreateCollectionFragment newInstance(String param1, String param2) {
        CreateCollectionFragment fragment = new CreateCollectionFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_create_collection, container, false);
        btn_select = view.findViewById(R.id.btn_select);
        btn_select.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getContext(), IconSelectionFragment.class);
                startActivity(intent);
            }
        });

        et_name = view.findViewById(R.id.et_name);
        return view;
    }
}