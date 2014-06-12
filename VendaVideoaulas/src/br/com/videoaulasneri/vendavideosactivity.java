package br.com.videoaulasneri;

import android.app.Activity;
import android.os.Bundle;
import android.widget.*;
import android.view.*;
import android.app.AlertDialog;
import android.widget.*;
import android.app.AlertDialog;


public class vendavideosactivity extends Activity {
    /** Called when the activity is first created. */
	
	CheckBox cbAlgoritimo, cbJava, cbDelphi, cbPHP, cbAndroid;
	Button btFinalizar;
	EditText etValorTotal;
	double valortoal=0;
	
	
    @Override

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        //Para o heckBox
        cbAlgoritimo = (CheckBox) findViewById(R.id.cbAlgoritimo);
        cbJava = (CheckBox) findViewById(R.id.cbJava);
        cbAndroid = (CheckBox) findViewById(R.id.cbAndroid);
        cbDelphi = (CheckBox) findViewById(R.id.cbDelphi);
        cbPHP = (CheckBox) findViewById(R.id.cbPHP);        
        //Para o Botão
        btFinalizar = (Button)findViewById(R.id.btFinalizar);
        //Para o EditText
        etValorTotal = (EditText)findViewById(R.id.etValorTotal);
        
        btFinalizar.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				
				valortoal=0;
				
				if(cbAlgoritimo.isChecked())
					valortoal+= 99.00;
				
				if(cbAndroid.isChecked())
					valortoal+= 99.00;
				
				if(cbJava.isChecked())
					valortoal+= 129.00;
				
				if(cbDelphi.isChecked())
					valortoal+= 119.00;
				
				if(cbPHP.isChecked())
					valortoal+= 109.00;
				
				etValorTotal.setText(String.valueOf(valortoal));
				if(valortoal>=500)
				{
					AlertDialog.Builder caixaAlerta = new AlertDialog.Builder(vendavideosactivity.this);
					caixaAlerta.setMessage("Agradecemos pela compra dos Videos aulas, você terá 10% de desconto");
					caixaAlerta.setTitle("Alerta de compra dos videos");
					caixaAlerta.setNeutralButton("OK", null);
					caixaAlerta.show();
				}
				
			}
		});
        
        
    }
}
