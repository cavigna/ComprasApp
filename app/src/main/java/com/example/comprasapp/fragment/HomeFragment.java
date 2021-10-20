package com.example.comprasapp.fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.comprasapp.R;
import com.example.comprasapp.databinding.FragmentAddBinding;
import com.example.comprasapp.databinding.FragmentHomeBinding;
import com.example.comprasapp.viewmodel.ComprasViewModel;
import com.google.android.material.floatingactionbutton.FloatingActionButton;


public class HomeFragment extends Fragment {
    FragmentHomeBinding binding;
    TextView tvTotal;
    FloatingActionButton fbAdd;
    ComprasViewModel viewModel;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        binding = FragmentHomeBinding.inflate(inflater, container, false);
        tvTotal = binding.tvTotalHome;
        viewModel = new ViewModelProvider(getActivity()).get(ComprasViewModel.class);

        viewModel.getTotal().observe(getViewLifecycleOwner(), total->{
            tvTotal.setText(String.valueOf(total));
        });


        fbAdd = binding.fbAdd;


        fbAdd.setOnClickListener(l->{
            Navigation.findNavController(getView()).navigate(R.id.action_homeFragment_to_addFragment);
        });




        return binding.getRoot();

    }
}