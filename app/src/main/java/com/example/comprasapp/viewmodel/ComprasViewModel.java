package com.example.comprasapp.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import com.example.comprasapp.model.Compra;
import com.example.comprasapp.repository.RepositorioCompras;

import java.util.List;

public class ComprasViewModel extends AndroidViewModel {
    private RepositorioCompras repository;
    private LiveData<List<Compra>> allCompras;
    private LiveData<Integer> total;



    public ComprasViewModel(@NonNull Application application) {
        super(application);
        repository = new RepositorioCompras(application);
        allCompras = repository.getAllCompras();
        total = repository.getTotal();

    }

    public void agregarCompra(Compra compra){repository.agregarCompra(compra);}
    public void eliminarCompra(Compra compra){repository.eliminarCompra(compra);}

    public LiveData<List<Compra>> getAllCompras() {
        return allCompras;
    }

    public LiveData<Integer> getTotal() {
        return total;
    }
}
