package fiap.scj.gerenciamento_filas.repositorios;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

import javax.inject.Named;

import fiap.scj.gerenciamento_filas.WebFaultException;
import fiap.scj.gerenciamento_filas.to.AtendimentoTO;
import fiap.scj.gerenciamento_filas.to.SenhaTO;
import fiap.scj.gerenciamento_filas.to.StatusSenhaEnum;

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
	private static Collection<AtendimentoTO> listaAtendimento = new ArrayList<AtendimentoTO>();
	private static Integer proxAtendimento = 1;

	public String gerarNovaSenha(String nomeFila, String nomeCidadao) {
		Queue<SenhaTO> fila = listaFilas.get(nomeFila);
		if (fila == null) {
			fila = new LinkedList<SenhaTO>();
			listaFilas.put(nomeFila, fila);
		}

		SenhaTO novaSenha = new SenhaTO(nomeCidadao, String.format("A%04d", proxSenha++));
		listaSenhas.add(novaSenha);
		fila.add(novaSenha);

		System.out.println(String.format("Nova senha emitida: Código %s / Fila: %s", novaSenha.getCodigoSenha(), nomeFila));

		return novaSenha.getCodigoSenha();
	}

	public SenhaTO proximaSenha(String nomeFila, Integer numeroPontoAtd) throws WebFaultException {
		Queue<SenhaTO> fila = listaFilas.get(nomeFila);
		if (fila == null) {
			throw new WebFaultException("Fila não existente");
		}
		
		SenhaTO to = fila.poll();
		if (to == null) {
			throw new WebFaultException("Nenhuma senha disponível para atendimento");
		}
		
		chamarSenhaNoPainel(to.getCodigoSenha(), numeroPontoAtd);
		to.setStatus(StatusSenhaEnum.CHAMADO);
		System.out.println(String.format("Senha retirada da fila para atendimento: Código %s", to.getCodigoSenha()));
		return to;
	}

	public void chamarSenhaNoPainel(String codigoSenha, Integer numeroPontoAtd) {
		System.out.println(String.format("Senha chamada no painel: %s - Ponto %d", codigoSenha, numeroPontoAtd));
	}

	public Integer iniciarAtendimento(String codigoSenha) throws WebFaultException {
		SenhaTO senhaTO = procurarSenhaPorCodigo(codigoSenha);
		if (senhaTO == null) {
			throw new WebFaultException("Senha não encontrada");
		}
		senhaTO.setStatus(StatusSenhaEnum.EM_ATENDIMENTO);

		AtendimentoTO to = new AtendimentoTO();
		to.setIdentificador(proxAtendimento++);
		to.setCodigoSenha(codigoSenha);
		to.setNomeCidadao(senhaTO.getNomeCidadao());
		to.setDataInicio(new Date());
		listaAtendimento.add(to);
		
		System.out.println("Início de atendimento " + to);

		return to.getIdentificador();
	}

	private SenhaTO procurarSenhaPorCodigo(String codigoSenha) {
		for (SenhaTO to : listaSenhas) {
			if (codigoSenha.equals(to.getCodigoSenha())) {
				return to;
			}
		}
		return null;
	}

	public AtendimentoTO finalizarAtendimento(Integer idAtendimento, String servico, String avaliacao) throws WebFaultException {
		AtendimentoTO to = procurarAtendimentoPorId(idAtendimento);
		if (to == null) {
			throw new WebFaultException("Atendimento não encontrado");
		}

		to.setServico(servico);
		to.setDataFim(new Date());
		to.setAvaliacao(avaliacao);

		SenhaTO senhaTO = procurarSenhaPorCodigo(to.getCodigoSenha());
		if (senhaTO != null) {
			senhaTO.setStatus(StatusSenhaEnum.FINALIZADO);
		}
		
		System.out.println("Fim do atendimento " + to);
		return to;
	}

	private AtendimentoTO procurarAtendimentoPorId(Integer idAtendimento) {
		for (AtendimentoTO to : listaAtendimento) {
			if (idAtendimento.equals(to.getIdentificador())) {
				return to;
			}
		}
		return null;
	}

}
