package br.com.videoaulas;


import br.com.videoaulas.R.id;
// import br.comvideoaulasneri.R;
import android.app.Activity;
import android.app.AlertDialog;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

public class menuxml extends Activity {
	   /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
   
    }
    
    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
    	
    	MenuInflater menuInflater = getMenuInflater();
    	menuInflater.inflate(R.menu.itensmenu, menu);
    	return true;
    }
    
    
    @Override
    public boolean onOptionsItemSelected(MenuItem item)
    {
    	
    	switch(item.getItemId())
    	{
    	case id.gravar: mensagemExibir("gravar", "Gravar") ;break;
    	case id.excluir: mensagemExibir("excluir", "excluir") ;break;
    	case id.alterar: mensagemExibir("alterar", "alterar") ;break;
    	}
    	return super.onOptionsItemSelected(item);
    }
    
    
    public void mensagemExibir(String titulo, String texto)
    {
		AlertDialog.Builder mensagem = new AlertDialog.Builder(menuxml.this);
		mensagem.setTitle(titulo);
		mensagem.setMessage(texto);
		mensagem.setNeutralButton("OK",null);
		mensagem.show();

    }
}

