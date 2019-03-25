//
// Este arquivo foi gerado pela Arquitetura JavaTM para Implementação de Referência (JAXB) de Bind XML, v2.2.7 
// Consulte <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Todas as modificações neste arquivo serão perdidas após a recompilação do esquema de origem. 
// Gerado em: 2019.03.25 às 08:40:13 PM BRT 
//


package br.com.fiap.mba.scj.gerenciamento_filas;

import java.math.BigInteger;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java de anonymous complex type.
 * 
 * <p>O seguinte fragmento do esquema especifica o conteúdo esperado contido dentro desta classe.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="idAtendimento" type="{http://www.w3.org/2001/XMLSchema}integer"/>
 *         &lt;element name="servico" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="avaliacao" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "idAtendimento",
    "servico",
    "avaliacao"
})
@XmlRootElement(name = "finalizarAtendimentoRequest")
public class FinalizarAtendimentoRequest {

    @XmlElement(required = true)
    protected BigInteger idAtendimento;
    @XmlElement(required = true)
    protected String servico;
    @XmlElement(required = true)
    protected String avaliacao;

    /**
     * Obtém o valor da propriedade idAtendimento.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getIdAtendimento() {
        return idAtendimento;
    }

    /**
     * Define o valor da propriedade idAtendimento.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setIdAtendimento(BigInteger value) {
        this.idAtendimento = value;
    }

    /**
     * Obtém o valor da propriedade servico.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getServico() {
        return servico;
    }

    /**
     * Define o valor da propriedade servico.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setServico(String value) {
        this.servico = value;
    }

    /**
     * Obtém o valor da propriedade avaliacao.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAvaliacao() {
        return avaliacao;
    }

    /**
     * Define o valor da propriedade avaliacao.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAvaliacao(String value) {
        this.avaliacao = value;
    }

}
