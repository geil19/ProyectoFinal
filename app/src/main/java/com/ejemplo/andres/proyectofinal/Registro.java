package com.ejemplo.andres.proyectofinal;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class Registro extends AppCompatActivity {

    private EditText et1,et2,et3,et4;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);

        et1=(EditText) findViewById(R.id.codigo);
        et2=(EditText) findViewById(R.id.nombre);
        et3=(EditText) findViewById(R.id.contraseña);
        et4=(EditText) findViewById(R.id.celular);

    }

    public void registrar(View v){
        BaseDatos admin = new BaseDatos(this,"prueba9", null, 1);
        SQLiteDatabase bd = admin.getWritableDatabase();
        String Valor= et1.getText().toString();
        int codigo=Integer.parseInt(Valor);
        String nombre = et2.getText().toString();
        String contraseña = et3.getText().toString();
        String Valor2=et4.getText().toString();
        int celular = Integer.parseInt(Valor2);
        ContentValues registro = new ContentValues();
        ContentValues estudiante= new ContentValues();
        registro.put("codigo", codigo);
        estudiante.put("nombre", nombre);
        registro.put("contraseña", contraseña);
        estudiante.put("celular", celular);

        //Inserta los datos en la tabla usuario
        bd.insert("login", null, registro);
        bd.insert("estudiante",null,estudiante);
        bd.close();
        //Ponemos los campos a vacío para insertar el siguiente usuario
        et1.setText(""); et2.setText(""); et3.setText(""); et4.setText("");
        Toast.makeText(this, "Registro Completado", Toast.LENGTH_SHORT).show();
    }
}
