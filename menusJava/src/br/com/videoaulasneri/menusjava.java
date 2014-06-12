package br.com.videoaulasneri;
//videoaulaneri@gmail.com  www.informaticon.com.br

import br.com.videoaulasneri.R;
import android.app.Activity;
import android.app.AlertDialog;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.SubMenu;

public class menusjava extends Activity {
	   /** Called when the activity is first created. */
	//cria uma contante 
	final int  gravar=1;
	@Override
	public void onCreate(Bundle savedInstanceState) {
	     super.onCreate(savedInstanceState);
	     setContentView(R.layout.main);

 }
	
   
	@Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
    	
    	//MenuInflater menuInflater = getMenuInflater();
    	//menuInflater.inflate(R.menu.itensmenu, menu);
    	//return true;
		
		boolean result = super.onCreateOptionsMenu(menu);
		super.onCreateOptionsMenu(menu);
		menu.add(0, gravar, 0, "Gravar").setIcon(R.drawable.usuarios);
		menu.add(0, 2, 0, "Excluir").setIcon(R.drawable.icon);
		
		SubMenu ultilitarios = menu.addSubMenu("Ultilitario");
		ultilitarios.add(0, 3, 0, "Procurar");
		ultilitarios.add(0, 4, 0, "imprimir");
		
		
		
		return result;
    }
	
	
	 @Override
	    public boolean onOptionsItemSelected(MenuItem item)
	    {
	    	
	    	switch(item.getItemId())
	    	{
	    	case gravar: mensagemExibir("gravar", "Gravar") ;break;
	    	case 2: mensagemExibir("excluir", "excluir") ;break;	
	    	case 3: mensagemExibir("Procurar", "Procurar") ;break;
	    	case 4: mensagemExibir("imprimir", "imprimir") ;break;	
	    	}
	    	return super.onOptionsItemSelected(item);
	    }
	 
	 
	 public void mensagemExibir(String titulo, String texto)
	    {
			AlertDialog.Builder mensagem = new AlertDialog.Builder(menusjava.this);
			mensagem.setTitle(titulo);
			mensagem.setMessage(texto);
			mensagem.setNeutralButton("OK",null);
			mensagem.show();

	    }
 
 
}