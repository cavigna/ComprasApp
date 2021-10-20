package com.example.comprasapp.adapter;


import android.os.Build;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.recyclerview.widget.RecyclerView;

import com.example.comprasapp.R;
import com.example.comprasapp.databinding.ItemRowBinding;
import com.example.comprasapp.model.Compra;

import java.text.SimpleDateFormat;
import java.util.Date;

public class ComprasViewHolder extends RecyclerView.ViewHolder {
    ItemRowBinding binding;
    private TextView tvNombre, tvPrecio, tvCantidad, tvTotal, tvFecha;

    public ComprasViewHolder(@NonNull View itemView) {
        super(itemView);
        binding = ItemRowBinding.bind(itemView);

        tvNombre = binding.tvNombreRow;
        tvPrecio = binding.tvPrecioRow;
        tvCantidad = binding.tvCantidadRow;
        tvTotal =  binding.tvTotalRow;
        tvFecha = binding.tvFechaRow;

    }

    public static ComprasViewHolder create(ViewGroup parent) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_row, parent, false);
        return new ComprasViewHolder(view);
    }


    public void unirDatos(Compra compra){
        String nombre = compra.getNombre();
        int precio = compra.getPrecio();
        int cantidad = compra.getCantidad();
        int total = compra.getTotal();
        Date fecha = compra.getFecha();
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");

        tvNombre.setText(nombre);
        tvPrecio.setText(String.valueOf(precio));
        tvCantidad.setText(String.valueOf(cantidad));
        tvTotal.setText(String.valueOf(total));
        tvFecha.setText(sdf.format(fecha).toString());

    }
}
