package com.example.practice1;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;

public class CollectionBlankFragment extends Fragment {

    ImageButton btn_add;

    public CollectionBlankFragment() {
    }
    public static CollectionBlankFragment newInstance(String param1, String param2) {
        CollectionBlankFragment fragment = new CollectionBlankFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_collection_blank, container, false);
        btn_add = view.findViewById(R.id.btn_add);
        btn_add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getContext(), CreateCollectionFragment.class);
                startActivity(intent);
            }
        });
        return view;
    }
}