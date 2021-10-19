package com.example.comprasapp.db;


import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.room.TypeConverters;

import com.example.comprasapp.dao.CompraDao;
import com.example.comprasapp.model.Compra;
import com.example.comprasapp.utils.Converters;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Database(entities = Compra.class, version = 1, exportSchema = false)
@TypeConverters(Converters.class)
public abstract class BaseDeDatos extends RoomDatabase {

    private static volatile  BaseDeDatos instance;

    public abstract CompraDao compraDao();


    private static final String DB_NAME =  "compras_db";

    private static int NUMBER_OF_THREADS =4;

    public static final ExecutorService databaseWriteExecutor =
            Executors.newFixedThreadPool(NUMBER_OF_THREADS);

    public static BaseDeDatos getDatabase(final Context context){

        if( instance == null){
            synchronized (BaseDeDatos.class){
                if(instance == null){
                    instance = Room.databaseBuilder(
                            context.getApplicationContext(),
                            BaseDeDatos.class,
                            DB_NAME
                    )
                            .fallbackToDestructiveMigration()
                            .addTypeConverter(Converters.class)
                            .build();
                }
            }
        }
        return instance;
    }
}
