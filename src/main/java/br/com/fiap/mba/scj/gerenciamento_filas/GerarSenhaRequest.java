//
// Este arquivo foi gerado pela Arquitetura JavaTM para Implementação de Referência (JAXB) de Bind XML, v2.2.7 
// Consulte <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Todas as modificações neste arquivo serão perdidas após a recompilação do esquema de origem. 
// Gerado em: 2019.03.25 às 08:40:13 PM BRT 
//


package br.com.fiap.mba.scj.gerenciamento_filas;

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
 *         &lt;element name="fila" type="{http://www.w3.org/2001/XMLSchema}string"/>
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
    "fila",
    "nomeCidadao"
})
@XmlRootElement(name = "gerarSenhaRequest")
public class GerarSenhaRequest {

    @XmlElement(required = true)
    protected String fila;
    @XmlElement(required = true)
    protected String nomeCidadao;

    /**
     * Obtém o valor da propriedade fila.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFila() {
        return fila;
    }

    /**
     * Define o valor da propriedade fila.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFila(String value) {
        this.fila = value;
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
