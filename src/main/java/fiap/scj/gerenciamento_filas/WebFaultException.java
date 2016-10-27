package fiap.scj.gerenciamento_filas;

import javax.xml.ws.WebFault;

@WebFault(name = "WebFault", targetNamespace = "http://www.fiap.com.br")
public class WebFaultException extends Exception {

	private static final long serialVersionUID = 2958703208072044469L;

	public WebFaultException(String fault) {
		super(fault);
	}
	
}