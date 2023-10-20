package com.example.mideportefavorito;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements RadioGroup.OnCheckedChangeListener, AdapterView.OnItemSelectedListener {

    private RadioGroup radGr;
    private Spinner sprDeporte;
    private TextView lblInfo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lblInfo = findViewById(R.id.lblInfo);

        radGr = findViewById(R.id.radGr);
        radGr.setOnCheckedChangeListener(this);

        sprDeporte = findViewById(R.id.sprDeporte);
        sprDeporte.setOnItemSelectedListener(this);

        ((RadioButton)findViewById(R.id.radIndividual)).setChecked(true);
        lblInfo.setText("");
    }

    @Override
    public void onCheckedChanged(RadioGroup radioGroup, int i) {
        int id = radioGroup.getCheckedRadioButtonId();
        String tipo = ((RadioButton)findViewById(id)).getText().toString();
        ArrayAdapter adapter;

        if (tipo.equals(getString(R.string.radIndividual))) {
            adapter = ArrayAdapter.createFromResource(this, R.array.individuales, android.R.layout.simple_spinner_dropdown_item);
            sprDeporte.setAdapter(adapter);
        } else if (tipo.equals(getString(R.string.radEnPareja))) {
            adapter = ArrayAdapter.createFromResource(this, R.array.enPareja, android.R.layout.simple_spinner_dropdown_item);
            sprDeporte.setAdapter(adapter);
        } else if (tipo.equals(getString(R.string.radGrupal))) {
            adapter = ArrayAdapter.createFromResource(this, R.array.grupales, android.R.layout.simple_spinner_dropdown_item);
            sprDeporte.setAdapter(adapter);
        }

        sprDeporte.setSelection(0);
    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
        lblInfo.setText(adapterView.getItemAtPosition(i).toString());
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }
}