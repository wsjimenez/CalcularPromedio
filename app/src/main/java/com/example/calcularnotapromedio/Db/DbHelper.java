package com.example.calcularnotapromedio.Db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DbHelper extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION = 1; //Version de DB
    public static final String DATABASE_NOMBRE = "NotasAsignatura.db"; //Metodo Nombre del archivo que contiene la Db
    public static final String TABLE_NOTAS = "t_Notas"; //Nombre de la tabla de registro de datos del estudiante


    public DbHelper(@Nullable Context context ) {
        super(context, DATABASE_NOMBRE, null,DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) { //Metodo

        sqLiteDatabase.execSQL("CREATE TABLE " + TABLE_NOTAS + " (" +  //Creacion de tabla de datos del estudiante y sus respectivas notas
                "id INTEGER PRIMARY KEY AUTOINCREMENT," +
                "Estudiante TEXT NOT NULL," +
                "Primer20 TEXT NOT NULL," +
                "Parcial20 TEXT NOT NULL," +
                "Tercer20 TEXT NOT NULL," +
                "Parcial40 TEXT NOT NULL)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

        sqLiteDatabase.execSQL("DROP TABLE " + TABLE_NOTAS); //Metodo de actualizacion de tablas
        onCreate(sqLiteDatabase);

    }
}
