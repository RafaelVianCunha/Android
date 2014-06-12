package br.com.neri;
//videoaulaneri@gmail.com  www.informaticon.com.br  NERIZON DA GAITA
import android.app.Activity;
import android.app.AlertDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
//videoaulaneri@gmail.com  www.informaticon.com.br  NERIZON DA GAITA
public class Apliacao extends Activity {
    Registro objRegistro, regAuxiliar, ultimoRegistro, primeiroRegistro;
    EditText etNome, etEndereco, etTelefone;
    int contadorRegistros=0, posicao=0;
    Button btCadastro, btConsulta, btVoltar, btProxReg,btRegAnt, btMenuPrincipal, btGravar;
    TextView tvNome, tvEndereco, tvTelefone;
	@Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.main);
        primeiroRegistro=null;
        ultimoRegistro=null;
        chamaMenuPrincipal();
        
      //videoaulaneri@gmail.com  www.informaticon.com.br  NERIZON DA GAITA    
        
    }
    public void chamaCadastro(){
    	setContentView(R.layout.cadastro);
    	inicializacaoObjetos();
    	listeners();
    	//etNome.requestFocus();
    	

    	
    	
    }
    public void mensagemExibir(String titulo, String texto)
    {
		AlertDialog.Builder mensagem = new AlertDialog.Builder(Apliacao.this);
		mensagem.setTitle(titulo);
		mensagem.setMessage(texto);
		mensagem.setNeutralButton("OK",null);
		mensagem.show();

    }
    
    //videoaulaneri@gmail.com  www.informaticon.com.br  NERIZON DA GAITA
    public void chamaConsulta(){
    	if (contadorRegistros == 0)
    	{
    		mensagemExibir("Aviso do Neri", "Não possui registros gravdos");
    		chamaMenuPrincipal();
    		return;
    	}
    	posicao=1;
    	setContentView(R.layout.consulta);
    	inicializacaoObjetos();
    	listeners();
        
        regAuxiliar = primeiroRegistro;
        
        mostrarDados();
        
       
    }
    public void chamaMenuPrincipal(){
    	setContentView(R.layout.main); 
    	inicializacaoObjetos();
    	listeners();
        
         

       //videoaulaneri@gmail.com  www.informaticon.com.br  NERIZON DA GAITA
    }
    public void inicializacaoObjetos()
    {
    	try
    	{
	    	 btCadastro = (Button) findViewById(R.id.btCadastro);
	         btConsulta = (Button) findViewById(R.id.btConsulta);
	         
	         //objetos da consulta
	         btVoltar = (Button) findViewById(R.id.btVoltar);
	         btProxReg = (Button) findViewById(R.id.btProxReg);
	         btRegAnt = (Button) findViewById(R.id.btRegAnt);
	         
	         //objetos do cadastro
	     	 btMenuPrincipal = (Button) findViewById(R.id.btMenuPrincipal);
	    	 btGravar  = (Button) findViewById(R.id.btGravar);
	    	 
	         tvNome = (TextView) findViewById(R.id.tvNome);
	         tvEndereco = (TextView) findViewById(R.id.tvEndereco);
	         tvTelefone = (TextView) findViewById(R.id.tvTelefone);
	         
			   etNome = (EditText) findViewById(R.id.nome);
			   etEndereco = (EditText) findViewById(R.id.endereco);
			   etTelefone = (EditText) findViewById(R.id.telefone);	
	     	}
    	catch(Exception erro) 
    	{}

    }
    public void listeners()
    {
    	try {
             btCadastro.setOnClickListener(new View.OnClickListener() {
	 			
	 			@Override
	 			public void onClick(View v) {
	 				chamaCadastro(); //chama a tela de cadastro ao clicar 
	 				
	 			}
	 		});
	         
	         btConsulta.setOnClickListener(new View.OnClickListener() {
	 			
	 			@Override
	 			public void onClick(View v) {
	 				chamaConsulta(); //chama a tela de consulta ao clicar
	 			}
	 		});
	     
	     	
    	}
	     	catch(Exception erro) 
	    	{}
	     	
	     	try
	     	{
	     		btMenuPrincipal.setOnClickListener(new View.OnClickListener() {
					
					@Override
					public void onClick(View v) {
						chamaMenuPrincipal();
						
					}
				});
		     	btGravar.setOnClickListener(new View.OnClickListener() {
		    	       //videoaulaneri@gmail.com  www.informaticon.com.br  NERIZON DA GAITA
					@Override
					public void onClick(View v) {
						gravarRegistro();
						chamaMenuPrincipal();
					  }			 	   			  
					
				});
	     	}
	     	catch(Exception erro) {}
	     	
	     	try
	     	{
	     		 btVoltar.setOnClickListener(new View.OnClickListener() {
	 	 			
	 	 			@Override
	 	 			public void onClick(View v) {
	 	 			   chamaMenuPrincipal();				
	 	 			}
	 	 		});
	 	         
	 	         btProxReg.setOnClickListener(new View.OnClickListener() {
	 	 			
	 	 			@Override
	 	 			public void onClick(View v) {
	 	 				mostrarProximoRegistro();
	 	 				
	 	 			}

	 	 		});
	 	         btRegAnt.setOnClickListener(new View.OnClickListener() {
	 	 			
	 	 			@Override
	 	 			public void onClick(View v) {
	 	 			   mostrarRegistroAnterior();
	 	 				
	 	 			}
	 	 		});
	     	}
	     	catch(Exception e) {}
    	
    
    }
    
    public void mostrarRegistroAnterior()
    {
    	 if (posicao ==1)
			    return;
			posicao--;
			regAuxiliar = regAuxiliar.registroAnterior;
     
	        mostrarDados();
    }
    
	public void mostrarProximoRegistro() {
		if (posicao == contadorRegistros)
			return;
		
		posicao++;
		regAuxiliar = regAuxiliar.proximoRegistro;
        
        mostrarDados();
		
	}

    public void gravarRegistro()
    {
    	 try {	
			   objRegistro = new Registro();
		   
			   //gravar
			   objRegistro.nome = etNome.getText().toString();
			   objRegistro.endereco = etEndereco.getText().toString();
			   objRegistro.telefone = etTelefone.getText().toString();
			   
			   if (primeiroRegistro == null)
				   primeiroRegistro = objRegistro;
			   
			   objRegistro.registroAnterior = ultimoRegistro;
			   
			   if(ultimoRegistro == null)
				   ultimoRegistro = objRegistro;
			   else {
				   ultimoRegistro.proximoRegistro = objRegistro;
				   ultimoRegistro = objRegistro;
			   }
				   
			   
			   contadorRegistros++;
			   mensagemExibir("Gravação", "Dados gravados com sucesso");
    	 }
		catch(Exception erro)
		{
		    mensagemExibir("Erro", "Deu erro ao gravar "+erro);
	    }		
    }
    public void mostrarDados()
    {
        tvNome.setText(regAuxiliar.nome);
        tvEndereco.setText(regAuxiliar.endereco);
        tvTelefone.setText(regAuxiliar.telefone);
    }
}