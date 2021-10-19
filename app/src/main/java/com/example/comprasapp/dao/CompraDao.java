package com.example.comprasapp.dao;


import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import com.example.comprasapp.model.Compra;

import java.util.Date;
import java.util.List;

@Dao
public interface CompraDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void agregarCompra(Compra compra);

    @Delete
    void eliminarCompra(Compra compra);

    @Query("SELECT * FROM compras")
    LiveData<List<Compra>> allCompras();

    @Query("SELECT * FROM compras WHERE fecha = :fecha")
    LiveData<List<Compra>> allComprasByDate(Date fecha);

    @Query("SELECT SUM(total) AS value FROM compras")
    LiveData<Integer> sumCompras();

}
