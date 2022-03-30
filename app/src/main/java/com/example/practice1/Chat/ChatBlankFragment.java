package com.example.practice1.Chat;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.practice1.R;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link ChatBlankFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ChatBlankFragment extends Fragment {

    public ChatBlankFragment() {
        // Required empty public constructor
    }
    public static ChatBlankFragment newInstance(String param1, String param2) {
        ChatBlankFragment fragment = new ChatBlankFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_chat_blank, container, false);
        return view;
    }
}