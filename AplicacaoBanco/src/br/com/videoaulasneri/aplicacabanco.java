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
			bancoDados = openOrCreateDatabase("bancoEstoque",
					MODE_WORLD_READABLE, null);
			String sql = "CREATE TABLE IF NOT EXISTS pessoas "
					+ "(id INTEGER PRIMARY KEY, nome TEXT, endereco TEXT,"
					+ "telefone TEXT);";
			bancoDados.execSQL(sql);
			mensagemExibir("Banco", "Banco criado com sucesso");

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
		// etNome.requestFocus();

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

	public void inicializacaoObjetos() {
		try {
			btCadastro = (Button) findViewById(R.id.btCadastro);
			btConsulta = (Button) findViewById(R.id.btConsulta);

			// objetos da consulta
			btVoltar = (Button) findViewById(R.id.btVoltar);
			btProxReg = (Button) findViewById(R.id.btProxReg);
			btRegAnt = (Button) findViewById(R.id.btRegAnt);

			// objetos do cadastro
			btMenuPrincipal = (Button) findViewById(R.id.btMenuPrincipal);
			btGravar = (Button) findViewById(R.id.btGravar);

			etNome = (EditText) findViewById(R.id.nome);
			etEndereco = (EditText) findViewById(R.id.endereco);
			etTelefone = (EditText) findViewById(R.id.telefone);

		} catch (Exception erro) {
		}

	}

	public void listeners()

	{
		try {
			btCadastro.setOnClickListener(new View.OnClickListener() {

				@Override
				public void onClick(View v) {
					chamaCadastro(); // chama a tela
										// de
										// cadastro
										// ao clicar

				}
			});

			btConsulta.setOnClickListener(new View.OnClickListener() {

				@Override
				public void onClick(View v) {
					chamaConsulta(); // chama a tela
										// de
										// consulta
										// ao clicar
				}
			});

		} catch (Exception erro) {
		}

		try {
			btMenuPrincipal.setOnClickListener(new View.OnClickListener() {

				@Override
				public void onClick(View v) {
					chamaMenuPrincipal();

				}
			});
			btGravar.setOnClickListener(new View.OnClickListener() {
				// videoaulaneri@gmail.com
				// www.informaticon.com.br NERIZON DA
				// GAITA
				@Override
				public void onClick(View v) {
					// gravarRegistro();
					// chamaMenuPrincipal();
				}

			});
		} catch (Exception erro) {
		}

		try {
			btVoltar.setOnClickListener(new View.OnClickListener() {

				@Override
				public void onClick(View v) {
					chamaMenuPrincipal();
				}
			});

			btProxReg.setOnClickListener(new View.OnClickListener() {

				@Override
				public void onClick(View v) {
					// mostrarProximoRegistro();

				}

			});
			btRegAnt.setOnClickListener(new View.OnClickListener() {

				@Override
				public void onClick(View v) {
					// mostrarRegistroAnterior();

				}
			});
		} catch (Exception erro) {
		}

	}

	public void chamaConsulta() {
		// if (contadorRegistros == 0)
		// {
		// mensagemExibir("Aviso do Neri",
		// "N�o possui registros gravdos");
		// chamaMenuPrincipal();
		// return;
		// }
		// posicao=1;
		setContentView(R.layout.consulta);
		inicializacaoObjetos();
		listeners();

		// regAuxiliar = primeiroRegistro;

		// mostrarDados();

	}

	public void mostrarDados() {
		// tvNome.setText(cursor.getString(columnIndex));
		// tvEndereco.setText(cursor.getString(columnIndex));
		// tvTelefone.setText(cursor.getString(columnIndex));
	}

}