package br.com.videoaulasneri;

import br.com.videoaulasneri.R;
import android.app.Activity;
import android.app.AlertDialog;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class aplicacabanco extends Activity {
	/** Called when the activity is first created. */
	SQLiteDatabase bancoDados = null;
	Cursor cursor;

	EditText etNome, etEndereco, etTelefone;
	Button btCadastro, btConsulta, btVoltar, btProxReg, btRegAnt,
			btMenuPrincipal, btGravar;
	TextView tvNome, tvEndereco, tvTelefone;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		abreouCriaBanco();
		chamaMenuPrincipal();

	}

	public void abreouCriaBanco() {
		try {
			String nomeBanco = "bancoEstoque";
			bancoDados = openOrCreateDatabase(nomeBanco, MODE_WORLD_READABLE,
					null);
			String sql = "CREATE TABLE IF NOT EXISTS pessoas "
					+ "(id INTEGER PRIMARY KEY, nome TEXT, endereco TEXT,"
					+ "telefone TEXT);";
			bancoDados.execSQL(sql);
		//	mensagemExibir("Banco", "Banco criado com sucesso");

		} catch (Exception erro) {
			mensagemExibir("Erro",
					"Erro ao abri ou criar o banco" + erro.getMessage());

		}
	}

	public void fechaBanco() {
		try {
			bancoDados.close();
		} catch (Exception erro) {
			mensagemExibir("Erro", "Erro ao fechar o banco" + erro.getMessage());
		}
	}

	public void chamaMenuPrincipal() {
		setContentView(R.layout.main);
		inicializacaoObjetos();
		listeners();

	}

	public void mensagemExibir(String titulo, String texto) {
		AlertDialog.Builder mensagem = new AlertDialog.Builder(
				aplicacabanco.this);
		mensagem.setTitle(titulo);
		mensagem.setMessage(texto);
		mensagem.setNeutralButton("OK", null);
		mensagem.show();

	}

	public void chamaCadastro() {
		setContentView(R.layout.cadastro);
		inicializacaoObjetos();
		listeners();
		etNome.requestFocus();

	}

	private boolean buscarDados() {
		try {
			cursor = bancoDados.query("pessoas", new String[] { "nome",
					"endereco", "telefone" }, null,// selection,
					null,// selectionArgs,
					null,// groupBy,
					null,// having,
					null,// orderBy);
					null);// limite de registros retornado
			int numeroRegistro = cursor.getCount();
			if (numeroRegistro != 0) {
				cursor.moveToFirst(); // vai para o primeiro
										// registro
				return true;
			} else
				return false;

		} catch (Exception erro) {
			mensagemExibir("Erro",
					"Erro ao buscar dados no banco" + erro.getMessage());
			return false;

		}
	}

	public void gravarRegistro() {
		try {
			String sql = "INSERT INTO pessoas (nome, endereco, telefone) values ('"
					+ etNome.getText().toString()
					+ "','"
					+ etEndereco.getText().toString()
					+ "','"
					+ etTelefone.getText().toString() + "')";
			bancoDados.execSQL(sql);
			mensagemExibir("Dados gravados", "Dados gravados com Sucesso");

		} catch (Exception erro) {
			mensagemExibir("Erro Banco",
					"Erro ao gravar dados no banco" + erro.getMessage());
		}
	}

	public void inicializacaoObjetos() {
		try {
			btCadastro = (Button) findViewById(R.id.btCadastro);
			btConsulta = (Button) findViewById(R.id.btConsulta);
		} catch (Exception erro) {
		}
		try {
			// objetos da consulta
			tvNome = (TextView) findViewById(R.id.nome);
			tvTelefone = (TextView) findViewById(R.id.telefone);
			tvEndereco = (TextView) findViewById(R.id.endereco);
			btVoltar = (Button) findViewById(R.id.btVoltar);
			btProxReg = (Button) findViewById(R.id.btProxReg);
			btRegAnt = (Button) findViewById(R.id.btRegAnt);
		} catch (Exception erro) {
		}
		try {
			// objetos do cadastro
			btMenuPrincipal = (Button) findViewById(R.id.btMenuPrincipal);
			btGravar = (Button) findViewById(R.id.btGravar);
			etNome = (EditText) findViewById(R.id.nome);
			etEndereco = (EditText) findViewById(R.id.endereco);
			etTelefone = (EditText) findViewById(R.id.telefone);
		} catch (Exception erro) {
		}

	}

	public void listeners() {
		try{
				btCadastro.setOnClickListener(new 
				     View.OnClickListener() {
					public void onClick(View arg0) {
							abreouCriaBanco();
							chamaCadastro();
					}
				});
				btConsulta.setOnClickListener(new 
						View.OnClickListener() {
					public void onClick(View arg0) {
							abreouCriaBanco();
							chamaConsulta();
					}
				});	

			} catch (Exception e){}

		try{
			btGravar.setOnClickListener(new 
			       View.OnClickListener() {
				public void onClick(View arg0) {
					try {
						gravarRegistro();						
						etEndereco.setText(null);
						etTelefone.setText(null);
						etNome.setText(null);
						etNome.requestFocus();
					} catch (Exception erro) {
						mensagemExibir("Erro Banco", "Erro ao gravar dados no banco: "+erro.getMessage());
					}
				}
			});
			btMenuPrincipal.setOnClickListener(new 
			      View.OnClickListener() {
				public void onClick(View arg0) {
					chamaMenuPrincipal();
				}
			});
		} catch (Exception e){
		}

		try{
			btVoltar.setOnClickListener(new 
			      View.OnClickListener(){
				public void onClick(View arg0){
					cursor.close();
					chamaMenuPrincipal();
				}
			});
		
			btRegAnt.setOnClickListener(new 
			     View.OnClickListener(){
				public void onClick(View arg0){
					mostrarRegistroAnterior();
				}
			});
		
			btProxReg.setOnClickListener(new View.OnClickListener(){
				public void onClick(View arg0){
					mostrarProximoRegistro();
				}
			});
		} catch (Exception e){ }
		
		}

	public void chamaConsulta() {
		if (buscarDados()) // é igual a buscarDados() == true
		{
			setContentView(R.layout.consulta);
			inicializacaoObjetos();
			listeners();
			mostrarDados();

		} else {
			mensagemExibir("Aviso", "Não possui registros gravdos");
			chamaMenuPrincipal();
			return;
		}
	}

	public void mostrarDados() {
		tvNome.setText(cursor.getString(cursor.getColumnIndex("nome")));
		tvEndereco.setText(cursor.getString(cursor.getColumnIndex("endereco")));
		tvTelefone.setText(cursor.getString(cursor.getColumnIndex("telefone")));
	}

	public void mostrarRegistroAnterior() {
		try {
			cursor.moveToPrevious();
			mostrarDados();

		} catch (Exception erro) {
			mensagemExibir(
					"Erro navegar banco",
					"Você está no primeiro registro");
		}
	}

	public void mostrarProximoRegistro() {
		try {
			cursor.moveToNext();
			mostrarDados();

		} catch (Exception erro) {
			mensagemExibir(
					"Erro navegar banco",
					"Não tem mais registro");
		}

	}

}