package com.example.practice1;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

public class IconSelectionFragment extends Fragment {

    ImageView img_1;


    public IconSelectionFragment() {
        // Required empty public constructor
    }
    public static IconSelectionFragment newInstance(String param1, String param2) {
        IconSelectionFragment fragment = new IconSelectionFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_icon_selection, container, false);
        return view;
    }
}