package com.example.comprasapp.fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.comprasapp.R;
import com.example.comprasapp.adapter.ComprasListAdapter;
import com.example.comprasapp.databinding.FragmentHomeBinding;
import com.example.comprasapp.databinding.FragmentListBinding;
import com.example.comprasapp.viewmodel.ComprasViewModel;

public class ListFragment extends Fragment {

   FragmentListBinding binding;
   private ComprasViewModel viewModel;
   private RecyclerView recycler;
   private ComprasListAdapter adapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentListBinding.inflate(inflater, container, false);

        viewModel = new ViewModelProvider(getActivity()).get(ComprasViewModel.class);

        recycler = binding.recycler;

        adapter = new ComprasListAdapter(new ComprasListAdapter.CompraDiff());

        recycler.setLayoutManager(new LinearLayoutManager(getContext()));
        recycler.setAdapter(adapter);

        viewModel.getAllCompras().observe(getViewLifecycleOwner(), compras -> {
            adapter.submitList(compras);
        });

        return binding.getRoot();

    }
}