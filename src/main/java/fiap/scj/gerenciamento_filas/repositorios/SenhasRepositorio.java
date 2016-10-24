package fiap.scj.gerenciamento_filas.repositorios;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

import javax.inject.Named;

import fiap.scj.gerenciamento_filas.to.SenhaTO;

/**
 * Classe responsável por armazenar os horários livres e agendamentos efetuados.
 * 
 * @author Eduardo Galego
 */
@Named
public class SenhasRepositorio {

	private static Collection<SenhaTO> listaSenhas = new ArrayList<SenhaTO>();
	private static Map<String, Queue<SenhaTO>> listaFilas = new HashMap<String, Queue<SenhaTO>>();
	private static Integer proxSenha = 1;

	public String gerarNovaSenha(String nomeFila, String nomeCidadao) {
		Queue<SenhaTO> fila = listaFilas.get(nomeFila);
		if (fila == null) {
			fila = new LinkedList<SenhaTO>();
			listaFilas.put(nomeFila, fila);
		}

		SenhaTO novaSenha = new SenhaTO(nomeCidadao, String.format("%04d",proxSenha++));
		listaSenhas.add(novaSenha);
		fila.add(novaSenha);
		return novaSenha.getCodigoSenha();
	}

	public SenhaTO proximaSenha(String nomeFila) throws Exception {
		Queue<SenhaTO> fila = listaFilas.get(nomeFila);
		if (fila == null) {
			throw new Exception("Fila não existente");
		}
		return fila.poll();
	}

}
