package br.com.informaticon;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class VariasTelas extends Activity {
    /** Called when the activity is first created. */
	
	
	
	//Button btCadastro, btConsulta;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.main); 
        
        chamarMenuPrincipal();
        
        
        
 

    }
    
    public void chamaCadastro(){
    	setContentView(R.layout.cadastro);
    	Button	btMenuPrincipal = (Button) findViewById(R.id.btMenuPrincipal);
        btMenuPrincipal.setOnClickListener(new View.OnClickListener() {
    			
    			@Override
    			public void onClick(View v) {
    				chamarMenuPrincipal();
    				
    			}
    		});
    }
    
    public void chamarConsulta(){
    	setContentView(R.layout.consulta);
    	 
    	Button btVoltar = (Button) findViewById(R.id.btVoltar);
         
         btVoltar.setOnClickListener(new View.OnClickListener() {
 			
 			@Override
 			public void onClick(View v) {
 				chamarMenuPrincipal();
 				
 			}
 		});
    	
    }
    
    public void chamarMenuPrincipal(){
    	setContentView(R.layout.main);
    	Button btCadastro, btConsulta;
    	
    	btCadastro = (Button) findViewById(R.id.btCadastro);
        btConsulta = (Button) findViewById(R.id.btConsulta);
        
        btCadastro.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				chamaCadastro();
				
			}
		});
        
        btConsulta.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				chamarConsulta();
				
			}
		});
    	
    }
}