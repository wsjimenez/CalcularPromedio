package com.example.calcularnotapromedio;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.calcularnotapromedio.Db.DbHelper;

public class MainActivity extends AppCompatActivity {

    Button btnCrear;

    private EditText etPrimer20; //Se declaran las variables donde se digita la nota del alumno
    private EditText etParcial20;
    private EditText etTercer20;
    private EditText etParcial40;
    private EditText etEstudiante;
    private TextView tvResult; //Se declara la variable donde se imprimira el resultado promedio de la nota del alumno

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etPrimer20 = (EditText)findViewById(R.id.txtPrimer20); //Realizamos un puente para conectar la interfaz grafica para poder capturar los datos
        etParcial20 = (EditText)findViewById(R.id.txtParcial20);
        etTercer20 = (EditText)findViewById(R.id.txtTercer20);
        etParcial40 = (EditText)findViewById(R.id.txtParcial40);
        etEstudiante = (EditText)findViewById(R.id.txtEstudiante);
        tvResult = (TextView) findViewById(R.id.tvResult);

        btnCrear = findViewById(R.id.btnGuardar);

        btnCrear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DbHelper dbHelper = new DbHelper(MainActivity.this);
                SQLiteDatabase db = dbHelper.getWritableDatabase();

                if(db != null){
                    Toast.makeText(MainActivity.this, "BASE DE DATOS CREADA", Toast.LENGTH_LONG).show();

                }else {
                    Toast.makeText(MainActivity.this, "ERROR AL CREAR BASE DE DATOS", Toast.LENGTH_LONG).show();
                }
            }
        });

    }

    public void calcularPromedio (View view ){ //Metodo par calcular promedio

        String Primer20_String = etPrimer20.getText().toString();
        String Parcial20_String = etParcial20.getText().toString();
        String Tercer20_String = etTercer20.getText().toString();
        String Parcial40_String= etParcial40.getText().toString();
        String Estudiante = etEstudiante.getText().toString();

        Double Primer20_Double = Double.parseDouble(Primer20_String);  //Convertimos el valor que el usuario digita a un tipo Double para la nota
        Double Parcial20_Double = Double.parseDouble(Parcial20_String);
        Double Tercer20_Double = Double.parseDouble(Tercer20_String);
        Double Parcial40_Double = Double.parseDouble(Parcial40_String);

        Double Promedio = (Primer20_Double * 0.2 + Parcial20_Double * 0.2 + Tercer20_Double * 0.2 + Parcial40_Double * 0.4); //Se multiplica el valor de la nota por el porcentaje
                                                                                                                             //para realizar el promedio

        if (Promedio >= 3.0 ){

            tvResult.setText("El estudiante "+ Estudiante +" ha aprobado con " + Promedio);

        }else if (Promedio <= 2.9){
            tvResult.setText("El estudiante " + Estudiante + " ha reprobado con " + Promedio);
        }

    }


}