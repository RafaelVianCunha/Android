package br.com.videoaulasneri;
//videoaulas neri  www.informaticon.com.br
import android.app.Activity;
import android.os.Bundle;
import android.widget.*;
import android.view.*;

public class calcActivity extends Activity {
    /** Called when the activity is first created. */
	
	EditText etNum1,etNum2,etResultado;
	double num1, num2, resultado;
	Button btSomar, btDividir, btSubtrair, btMultiplicar;
   
	@Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        etNum1 = (EditText) findViewById(R.id.numero1);
        etNum2 = (EditText) findViewById(R.id.numero2);
        etResultado = (EditText) findViewById(R.id.resultado);
        btSomar = (Button) findViewById(R.id.btSoma);
        btSubtrair = (Button) findViewById(R.id.btSubtrair);
        btMultiplicar = (Button) findViewById(R.id.btMultiplicar);
        btDividir = (Button) findViewById(R.id.btDividir);
        
        
      //videoaulas neri  www.informaticon.com.br                
        btSomar.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				num1 = Double.parseDouble(etNum1.getText().toString());				
				num2 = Double.parseDouble(etNum2.getText().toString());
				resultado = num1 + num2;
				etResultado.setText(String.valueOf(resultado));				
			}
		});
       
       btSubtrair.setOnClickListener(new View.OnClickListener() {
		
		@Override
		public void onClick(View v) {
			num1 = Double.parseDouble(etNum1.getText().toString());				
			num2 = Double.parseDouble(etNum2.getText().toString());
			resultado = num1 - num2;
			etResultado.setText(String.valueOf(resultado));		
			
		}
	});
       
       btDividir.setOnClickListener(new View.OnClickListener() {
   		
   		@Override
   		public void onClick(View v) {
   			num1 = Double.parseDouble(etNum1.getText().toString());				
   			num2 = Double.parseDouble(etNum2.getText().toString());
   			resultado = num1 / num2;
   			etResultado.setText(String.valueOf(resultado));		
   			
   		}
   	});
       
       btMultiplicar.setOnClickListener(new View.OnClickListener() {
      		
      		@Override
      		public void onClick(View v) {
      			num1 = Double.parseDouble(etNum1.getText().toString());				
      			num2 = Double.parseDouble(etNum2.getText().toString());
      			resultado = num1 * num2;
      			etResultado.setText(String.valueOf(resultado));		
      			
      		}
      	});
        
    }
}
//videoaulas neri  www.informaticon.com.br