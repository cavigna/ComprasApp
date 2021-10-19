package com.example.comprasapp.repository;

import android.app.Application;

import androidx.lifecycle.LiveData;

import com.example.comprasapp.dao.CompraDao;
import com.example.comprasapp.db.BaseDeDatos;
import com.example.comprasapp.model.Compra;

import java.util.List;

public class RepositorioCompras {
    private CompraDao compraDao;
    private LiveData<List<Compra>> allCompras;
    private LiveData<Integer> total;

    public RepositorioCompras(Application application) {
        BaseDeDatos baseDeDatos = BaseDeDatos.getDatabase(application);
        compraDao = baseDeDatos.compraDao();
        allCompras = compraDao.allCompras();
        total = compraDao.sumCompras();
    }

    public CompraDao getCompraDao() {
        return compraDao;
    }

    public LiveData<List<Compra>> getAllCompras() {
        return allCompras;
    }

    public LiveData<Integer> getTotal() {
        return total;
    }

    public void agregarCompra(Compra compra){
        BaseDeDatos.databaseWriteExecutor.execute(()->
                compraDao.agregarCompra(compra)
                );
    }

    public void eliminarCompra(Compra compra){
        BaseDeDatos.databaseWriteExecutor.execute(()->
                compraDao.eliminarCompra(compra)
        );
    }
}
