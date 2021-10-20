package com.example.comprasapp.fragment;

import android.app.DatePickerDialog;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;
import android.widget.Toast;

import com.example.comprasapp.R;
import com.example.comprasapp.databinding.FragmentAddBinding;
import com.example.comprasapp.model.Compra;
import com.example.comprasapp.utils.Converters;
import com.example.comprasapp.viewmodel.ComprasViewModel;
import com.google.android.material.datepicker.MaterialDatePicker;
import com.google.android.material.textfield.TextInputLayout;

import java.time.LocalDate;
import java.util.Date;

public class AddFragment extends Fragment {

    FragmentAddBinding binding;
    ComprasViewModel viewModel;

    private TextView tvFecha;
    private MaterialDatePicker<Long> materialDatePicker;
    private Long fechaFromPicker = 0L;

    private TextInputLayout tilnombre, tilprecio, tilCantidad;
    private Button boton;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentAddBinding.inflate(inflater, container, false);

        viewModel = new ViewModelProvider(getActivity()).get(ComprasViewModel.class);

        tilnombre = binding.tilnombre;
        tilprecio = binding.tilprecio;
        tilCantidad = binding.tilcantidad;
        boton = binding.button;
        tvFecha = binding.tvfecha;


        MaterialDatePicker.Builder<Long> builder = MaterialDatePicker.Builder.datePicker();

        builder.setTitleText("Selecionar Fecha");
        materialDatePicker = builder.build();


        tvFecha.setOnClickListener(view -> {
            materialDatePicker.show(getActivity().getSupportFragmentManager(), "algo");
            materialDatePicker.addOnPositiveButtonClickListener(selection -> {
               tvFecha.setText(materialDatePicker.getHeaderText());
                Long date  = materialDatePicker.getSelection();
                fechaFromPicker  = materialDatePicker.getSelection();


               //builder.todayInUtcMilliseconds()
               //Date fecha = ;
            });
        });

        boton.setOnClickListener(view -> {
            String nombre = tilnombre.getEditText().getText().toString();
            String precioS = tilprecio.getEditText().getText().toString();
            String cantidadS = tilCantidad.getEditText().getText().toString();

            if(!nombre.isEmpty() && !precioS.isEmpty() && !cantidadS.isEmpty()){
                int precio = Integer.parseInt(tilprecio.getEditText().getText().toString());
                int cantidad = Integer.parseInt(tilCantidad.getEditText().getText().toString());

                Compra compra = new Compra(nombre, precio, cantidad, Converters.fromTimestamp(fechaFromPicker));
                viewModel.agregarCompra(compra);
                Toast.makeText(getContext(), "Compra Agregada", Toast.LENGTH_SHORT).show();

            }else{
                if(nombre.isEmpty()) tilnombre.setError("Debe Ingresar un Nombre");
                if(precioS.isEmpty()) tilCantidad.setError("Debe Ingresar un Precio");
                if(cantidadS.isEmpty()) tilCantidad.setError("Debe Ingresar un Precio");
            }



        });







        return binding.getRoot();


    }
}
