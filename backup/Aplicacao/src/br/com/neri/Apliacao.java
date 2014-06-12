package br.com.neri;

import android.R.string;
import android.app.Activity;
import android.app.AlertDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Apliacao extends Activity {
   
	Registro objRegistro, regAuxiliar, ultimoRegistro, primeiroRegistro;
	EditText edNome, edEndereco, edTelefone;
	int contadorRegistros=0, posicao=0;
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        primeiroRegistro=null;
        ultimoRegistro=null;
        
        chamarMenuPrincipal();
 
    }
    
    public void chamaCadastro(){
    	setContentView(R.layout.cadastro);
    	Button	btMenuPrincipal = (Button) findViewById(R.id.btMenuPrincipal);
    	Button	btGravar = (Button) findViewById(R.id.btGravar);
        btMenuPrincipal.setOnClickListener(new View.OnClickListener() {
    			
    			@Override
    			public void onClick(View v) {
    				chamarMenuPrincipal();
    				
    			}
    		});
        
        btGravar.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				try{
				objRegistro = new Registro();
				edNome = (EditText) findViewById(R.id.nome);
				edEndereco = (EditText) findViewById(R.id.endereco);
				edTelefone = (EditText) findViewById(R.id.telefone);
				
				// grava as informaçoes no objeto registro
				
				objRegistro.nome = edNome.getText().toString();
				objRegistro.endereco = edEndereco.getText().toString();
				objRegistro.telefone = edTelefone.getText().toString();
				
				if(primeiroRegistro==null)
					primeiroRegistro = objRegistro;
				
				objRegistro.registroAnterior = ultimoRegistro;
				
				if(ultimoRegistro == null)
					ultimoRegistro = objRegistro;
				else{
					ultimoRegistro.proximoRegistro = objRegistro;
					ultimoRegistro= objRegistro;
				}
				
				
				contadorRegistros++;
				mensagemExibir("AviGravação","Dados gravados com sucesso");
				chamarMenuPrincipal();
				}
				catch(Exception erro)
				{
					mensagemExibir("Erro","Erro ao gravar os dados"+erro);
					
				}			
		
			}
		});
    }
    
    public void mensagemExibir(String tirulo, String texto)
    {
    	AlertDialog.Builder mensagem = new AlertDialog.Builder(Apliacao.this);
		mensagem.setTitle(tirulo);
		mensagem.setMessage(texto);
		mensagem.setNeutralButton("ok", null);
		mensagem.show();
		
    	
    }
    
    
    
    public void chamarConsulta(){
    	if (contadorRegistros==0)
    	{
    		mensagemExibir("Aviso","Não possui registros gravados");
    		chamarMenuPrincipal();
    		return;
    	}
    	posicao=1;
    	
    	setContentView(R.layout.consulta);
    	 
    	Button btVoltar = (Button) findViewById(R.id.btVoltar);
    	Button btProxRg = (Button) findViewById(R.id.btProxReg);
    	Button btRegAnt = (Button) findViewById(R.id.btRegAnt);
    	
    	
    	
    	TextView tvNome = (TextView)  findViewById(R.id.tvNome);
    	TextView tvEndereco = (TextView)  findViewById(R.id.tvEndereco);
    	TextView tvTelefone = (TextView)  findViewById(R.id.tvTelefone);
    	
    	regAuxiliar = primeiroRegistro;
    	
    	// Joga o que tem em objRegistro para dentro do texto de tvNome
    	tvNome.setText(regAuxiliar.nome);
    	tvEndereco.setText(regAuxiliar.endereco);
    	tvTelefone.setText(regAuxiliar.telefone);
    	
         
         btVoltar.setOnClickListener(new View.OnClickListener() {
 			
 			@Override
 			public void onClick(View v) {
 				chamarMenuPrincipal();
 				
 			}
 		});   
         
         btProxRg.setOnClickListener(new View.OnClickListener() {
   			
   			@Override
   			public void onClick(View v) {
   				if(posicao==contadorRegistros)
   					return;
   				
   				posicao++;
   				regAuxiliar = regAuxiliar.proximoRegistro;
   				TextView tvNome = (TextView)  findViewById(R.id.tvNome);
   		    	TextView tvEndereco = (TextView)  findViewById(R.id.tvEndereco);
   		    	TextView tvTelefone = (TextView)  findViewById(R.id.tvTelefone);	    	
   		  
   		    	
   		    	// Joga o que tem em objRegistro para dentro do texto de tvNome
   		    	tvNome.setText(regAuxiliar.nome);
   		    	tvEndereco.setText(regAuxiliar.endereco);
   		    	tvTelefone.setText(regAuxiliar.telefone);
   				
   			}
   		});
         
         btRegAnt.setOnClickListener(new View.OnClickListener() {
    			
    			@Override
    			public void onClick(View v) {
    				
    				if(posicao==1)
    					return;
    				
    				posicao--;
    				regAuxiliar = regAuxiliar.registroAnterior;
    				TextView tvNome = (TextView)  findViewById(R.id.tvNome);
    		    	TextView tvEndereco = (TextView)  findViewById(R.id.tvEndereco);
    		    	TextView tvTelefone = (TextView)  findViewById(R.id.tvTelefone);	    	
    		  
    		    	
    		    	// Joga o que tem em objRegistro para dentro do texto de tvNome
    		    	tvNome.setText(regAuxiliar.nome);
    		    	tvEndereco.setText(regAuxiliar.endereco);
    		    	tvTelefone.setText(regAuxiliar.telefone);
    				
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