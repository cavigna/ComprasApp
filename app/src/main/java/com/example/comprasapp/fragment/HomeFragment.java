package com.example.comprasapp.fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.comprasapp.R;
import com.example.comprasapp.databinding.FragmentAddBinding;
import com.example.comprasapp.databinding.FragmentHomeBinding;
import com.google.android.material.floatingactionbutton.FloatingActionButton;


public class HomeFragment extends Fragment {
    FragmentHomeBinding binding;
    FloatingActionButton fbAdd;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        binding = FragmentHomeBinding.inflate(inflater, container, false);
        fbAdd = binding.fbAdd;

        fbAdd.setOnClickListener(l->{
            Navigation.findNavController(getView()).navigate(R.id.action_homeFragment_to_addFragment);
        });


        return binding.getRoot();

    }
}