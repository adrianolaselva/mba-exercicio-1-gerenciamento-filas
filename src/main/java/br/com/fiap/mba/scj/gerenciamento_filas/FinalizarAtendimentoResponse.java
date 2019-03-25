//
// Este arquivo foi gerado pela Arquitetura JavaTM para Implementação de Referência (JAXB) de Bind XML, v2.2.7 
// Consulte <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Todas as modificações neste arquivo serão perdidas após a recompilação do esquema de origem. 
// Gerado em: 2019.03.25 às 08:16:47 PM BRT 
//


package br.com.fiap.mba.scj.gerenciamento_filas;

import java.math.BigInteger;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


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
 *         &lt;element name="dataInicio" type="{http://www.w3.org/2001/XMLSchema}dateTime"/>
 *         &lt;element name="dataFim" type="{http://www.w3.org/2001/XMLSchema}dateTime"/>
 *         &lt;element name="servico" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="avaliacao" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="nomeCidadao" type="{http://www.w3.org/2001/XMLSchema}string"/>
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
    "dataInicio",
    "dataFim",
    "servico",
    "avaliacao",
    "nomeCidadao"
})
@XmlRootElement(name = "finalizarAtendimentoResponse")
public class FinalizarAtendimentoResponse {

    @XmlElement(required = true)
    protected BigInteger idAtendimento;
    @XmlElement(required = true)
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar dataInicio;
    @XmlElement(required = true)
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar dataFim;
    @XmlElement(required = true)
    protected String servico;
    @XmlElement(required = true)
    protected String avaliacao;
    @XmlElement(required = true)
    protected String nomeCidadao;

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
     * Obtém o valor da propriedade dataInicio.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getDataInicio() {
        return dataInicio;
    }

    /**
     * Define o valor da propriedade dataInicio.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setDataInicio(XMLGregorianCalendar value) {
        this.dataInicio = value;
    }

    /**
     * Obtém o valor da propriedade dataFim.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getDataFim() {
        return dataFim;
    }

    /**
     * Define o valor da propriedade dataFim.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setDataFim(XMLGregorianCalendar value) {
        this.dataFim = value;
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

    /**
     * Obtém o valor da propriedade nomeCidadao.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNomeCidadao() {
        return nomeCidadao;
    }

    /**
     * Define o valor da propriedade nomeCidadao.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNomeCidadao(String value) {
        this.nomeCidadao = value;
    }

}
