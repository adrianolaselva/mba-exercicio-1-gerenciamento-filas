package fiap.scj.gerenciamento_filas.endpoints;

import java.math.BigInteger;
import java.util.Date;
import java.util.GregorianCalendar;

import javax.inject.Inject;
import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;

import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import br.com.fiap.mba.scj.gerenciamento_filas.FinalizarAtendimentoRequest;
import br.com.fiap.mba.scj.gerenciamento_filas.FinalizarAtendimentoResponse;
import br.com.fiap.mba.scj.gerenciamento_filas.GerarSenhaRequest;
import br.com.fiap.mba.scj.gerenciamento_filas.GerarSenhaResponse;
import br.com.fiap.mba.scj.gerenciamento_filas.IniciarAtendimentoRequest;
import br.com.fiap.mba.scj.gerenciamento_filas.IniciarAtendimentoResponse;
import br.com.fiap.mba.scj.gerenciamento_filas.ProximaSenhaRequest;
import br.com.fiap.mba.scj.gerenciamento_filas.ProximaSenhaResponse;
import fiap.scj.gerenciamento_filas.repositorios.SenhasRepositorio;
import fiap.scj.gerenciamento_filas.to.AtendimentoTO;
import fiap.scj.gerenciamento_filas.to.SenhaTO;

@Endpoint
public class GerenciamentoFilasEndpoint {
	private static final String NAMESPACE_URI = "http://www.fiap.com.br/mba/scj/gerenciamento_filas";

	@Inject
	private SenhasRepositorio senhasRepositorio;

	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "gerarSenhaRequest")
	@ResponsePayload
	public GerarSenhaResponse gerarSenha(@RequestPayload GerarSenhaRequest request) {
		GerarSenhaResponse response = new GerarSenhaResponse();
		String codigo = senhasRepositorio.gerarNovaSenha(request.getFila(), request.getNomeCidadao());
		response.setCodigo(codigo);
		return response;
	}

	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "proximaSenhaRequest")
	@ResponsePayload
	public ProximaSenhaResponse gerarSenha(@RequestPayload ProximaSenhaRequest request) throws Exception {
		ProximaSenhaResponse response = new ProximaSenhaResponse();
		SenhaTO to = senhasRepositorio.proximaSenha(request.getFila(), request.getNumeroPontoAtd().intValue());
		response.setCodigo(to.getCodigoSenha());
		return response;
	}

	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "iniciarAtendimentoRequest")
	@ResponsePayload
	public IniciarAtendimentoResponse iniciarAtendimento(@RequestPayload IniciarAtendimentoRequest request)
			throws Exception {
		IniciarAtendimentoResponse response = new IniciarAtendimentoResponse();
		Integer idAtendimento = senhasRepositorio.iniciarAtendimento(request.getCodigoSenha());
		response.setIdentificador(BigInteger.valueOf(idAtendimento));
		return response;
	}

	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "finalizarAtendimentoRequest")
	@ResponsePayload
	public FinalizarAtendimentoResponse finalizarAtendimento(@RequestPayload FinalizarAtendimentoRequest request) throws Exception {
		FinalizarAtendimentoResponse response = new FinalizarAtendimentoResponse();		
		AtendimentoTO to = senhasRepositorio.finalizarAtendimento(request.getIdAtendimento().intValue(), request.getServico(),
				request.getAvaliacao());
		response.setIdAtendimento(BigInteger.valueOf(to.getIdentificador()));
		response.setDataInicio(dateToXMLGregorianCalendar(to.getDataInicio()));
		response.setDataFim(dateToXMLGregorianCalendar(to.getDataFim()));
		response.setServico(to.getServico());
		response.setAvaliacao(to.getAvaliacao());	
		response.setNomeCidadao(to.getNomeCidadao());
		
		System.out.println("Finalizar atendimento: "+ to.toString());
		
		return response;
	}
	
	private XMLGregorianCalendar dateToXMLGregorianCalendar(Date data) {
		GregorianCalendar gc = (GregorianCalendar) GregorianCalendar.getInstance();
		gc.setTime(data);
		try {
			return DatatypeFactory.newInstance().newXMLGregorianCalendar(gc);
		} catch (DatatypeConfigurationException e) {
			System.err.println(e);
			return null;
		}
	}

}