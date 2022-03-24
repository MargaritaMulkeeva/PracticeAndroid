package com.example.practice1;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link CompilationBlankFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class CompilationBlankFragment extends Fragment {

    ListView listView1;

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public CompilationBlankFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment CompilationBlankFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static CompilationBlankFragment newInstance(String param1, String param2) {
        CompilationBlankFragment fragment = new CompilationBlankFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        List<Discussion> discussion_data = new ArrayList<>();
        discussion_data.add(new Discussion(R.drawable.photo_film, "Игра престолов", "Иван: Смотрели уже последнюю серию? я просто не могу поверить, что там"));
        discussion_data.add(new Discussion(R.drawable.photo_film, "Игра престолов", "Иван: Смотрели уже последнюю серию? я просто не могу поверить, что там"));
        discussion_data.add(new Discussion(R.drawable.photo_film, "Игра престолов", "Иван: Смотрели уже последнюю серию? я просто не могу поверить, что там"));
        discussion_data.add(new Discussion(R.drawable.photo_film, "Игра престолов", "Иван: Смотрели уже последнюю серию? я просто не могу поверить, что там"));

        View view= inflater.inflate(R.layout.fragment_compilation_blank, container, false);
        DiscussionAdapter adapter = new DiscussionAdapter(getContext(), R.layout.list_item, discussion_data);
        listView1= view.findViewById(R.id.lv);
        listView1.setAdapter(adapter);
        return  view;
    }
}