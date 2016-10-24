package fiap.scj.gerenciamento_filas.endpoints;

import javax.inject.Inject;

import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import br.com.fiap.mba.scj.gerenciamento_filas.GerarSenhaRequest;
import br.com.fiap.mba.scj.gerenciamento_filas.GerarSenhaResponse;
import fiap.scj.gerenciamento_filas.repositorios.SenhasRepositorio;

@Endpoint
public class GerenciamentoFilasEndpoint {
	private static final String NAMESPACE_URI = "http://www.fiap.com.br/mba/scj/gerenciamento_filas";

	@Inject
	private SenhasRepositorio senhasRepositorio;

	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "gerarSenhaRequest")
	@ResponsePayload
	public GerarSenhaResponse gerarSenha(
			@RequestPayload GerarSenhaRequest request) {
		GerarSenhaResponse response = new GerarSenhaResponse();
		String codigo = senhasRepositorio.gerarNovaSenha(request.getFila(),
				request.getNomeCidadao());
		response.setCodigo(codigo);
		return response;
	}

}