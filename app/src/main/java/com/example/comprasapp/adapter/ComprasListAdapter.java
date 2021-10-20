package com.example.comprasapp.adapter;

import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.ListAdapter;

import com.example.comprasapp.model.Compra;

public class ComprasListAdapter extends ListAdapter<Compra, ComprasViewHolder> {
    public ComprasListAdapter(@NonNull DiffUtil.ItemCallback<Compra> diffCallback) {
        super(diffCallback);
    }

    @NonNull
    @Override
    public ComprasViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return ComprasViewHolder.create(parent);
    }

    @Override
    public void onBindViewHolder(@NonNull ComprasViewHolder holder, int position) {
        Compra compra = getItem(position);
        holder.unirDatos(compra);
    }


    public static class CompraDiff extends DiffUtil.ItemCallback<Compra>{

        @Override
        public boolean areItemsTheSame(@NonNull Compra oldItem, @NonNull Compra newItem) {
            return oldItem == newItem;
        }

        @Override
        public boolean areContentsTheSame(@NonNull Compra oldItem, @NonNull Compra newItem) {
            return oldItem.getId() == newItem.getId();
        }
    }
}
