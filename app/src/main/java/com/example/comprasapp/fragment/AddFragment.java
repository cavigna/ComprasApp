package com.example.comprasapp.fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.comprasapp.R;
import com.example.comprasapp.databinding.FragmentAddBinding;
import com.google.android.material.datepicker.MaterialDatePicker;

public class AddFragment extends Fragment {

    FragmentAddBinding binding;

    private TextView tvFecha;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding =  FragmentAddBinding.inflate(inflater, container, false);

        tvFecha = binding.tvfecha;

        MaterialDatePicker.Builder builder = MaterialDatePicker.Builder.datePicker();

        builder.setTitleText("Selecionar Fecha");
        final MaterialDatePicker materialDatePicker = builder.build();

        tvFecha.setOnClickListener(l->{

        });



        return binding.getRoot();




    }
}