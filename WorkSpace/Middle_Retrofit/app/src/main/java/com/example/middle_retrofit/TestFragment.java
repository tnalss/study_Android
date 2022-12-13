package com.example.middle_retrofit;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.middle_retrofit.databinding.FragmentTestBinding;

public class TestFragment extends Fragment {

    FragmentTestBinding binding;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentTestBinding.inflate(inflater);
        return binding.getRoot();
    }
//반드시 지켜야할것 안보이는거 없애줘야함


    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}

