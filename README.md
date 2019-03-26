# Gerenciamento de filas


### Gerar classes a partir do xsd

A partir do xsd dentro de resources as classes são geradas para o pacote definido

```xml
<build>
    <plugins>
        <plugin>
            <groupId>org.codehaus.mojo</groupId>
            <artifactId>jaxb2-maven-plugin</artifactId>
            <version>1.6</version>
            <executions>
                <execution>
                    <id>xjc</id>
                    <goals>
                        <goal>xjc</goal>
                    </goals>
                </execution>
            </executions>
            <configuration>
                <schemaDirectory>${project.basedir}/src/main/resources/</schemaDirectory>
                <outputDirectory>${project.basedir}/src/main/java</outputDirectory>
                <clearOutputDir>false</clearOutputDir>
            </configuration>
        </plugin>
        <plugin>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-maven-plugin</artifactId>
        </plugin>
    </plugins>
</build>
```

### Gerar classes a partir do xsd

Sempre que alterar o XSD basta recontruir a aplicação

```xml
<xs:schema xmlns:xs="http://www.w3.org/2001/XMLSchema"
	xmlns:tns="http://www.fiap.com.br/mba/scj/gerenciamento_filas"
	targetNamespace="http://www.fiap.com.br/mba/scj/gerenciamento_filas"
	elementFormDefault="qualified">

	<xs:element name="gerarSenhaRequest">
		<xs:complexType>
			<xs:sequence>
				<xs:element name="fila" type="xs:string" />
				<xs:element name="nomeCidadao" type="xs:string" />
			</xs:sequence>
		</xs:complexType>
	</xs:element>

	<xs:element name="gerarSenhaResponse">
		<xs:complexType>
			<xs:sequence>
				<xs:element name="codigo" type="xs:string" />
			</xs:sequence>
		</xs:complexType>
	</xs:element>

	<xs:element name="proximaSenhaRequest">
		<xs:complexType>
			<xs:sequence>
				<xs:element name="fila" type="xs:string" />
				<xs:element name="numeroPontoAtd" type="xs:integer" />
			</xs:sequence>
		</xs:complexType>
	</xs:element>

	<xs:element name="proximaSenhaResponse">
		<xs:complexType>
			<xs:sequence>
				<xs:element name="codigo" type="xs:string" />
			</xs:sequence>
		</xs:complexType>
	</xs:element>

	<xs:element name="iniciarAtendimentoRequest">
		<xs:complexType>
			<xs:sequence>
				<xs:element name="codigoSenha" type="xs:string" />
			</xs:sequence>
		</xs:complexType>
	</xs:element>

	<xs:element name="iniciarAtendimentoResponse">
		<xs:complexType>
			<xs:sequence>
				<xs:element name="identificador" type="xs:integer" />
			</xs:sequence>
		</xs:complexType>
	</xs:element>

	<xs:element name="finalizarAtendimentoRequest">
		<xs:complexType>
			<xs:sequence>
				<xs:element name="idAtendimento" type="xs:integer" />
				<xs:element name="servico" type="xs:string" />
				<xs:element name="avaliacao" type="xs:string" />
			</xs:sequence>
		</xs:complexType>
	</xs:element>
	
	<xs:element name="finalizarAtendimentoResponse">
		<xs:complexType>
			<xs:sequence>
				<xs:element name="idAtendimento" type="xs:integer" />
				<xs:element name="dataInicio" type="xs:dateTime" />
				<xs:element name="dataFim" type="xs:dateTime" />
				<xs:element name="servico" type="xs:string" />
				<xs:element name="avaliacao" type="xs:string" />
				<xs:element name="nomeCidadao" type="xs:string" />
			</xs:sequence>
		</xs:complexType>
	</xs:element>

</xs:schema>
```

http://localhost:8090/ws/gerenciamentoFilas.wsdl

### Gerar senha

```soap
<soapenv:Envelope xmlns:soapenv="http://schemas.xmlsoap.org/soap/envelope/" xmlns:ger="http://www.fiap.com.br/mba/scj/gerenciamento_filas">
   <soapenv:Header/>
   <soapenv:Body>
      <ger:gerarSenhaRequest>
         <ger:fila>1</ger:fila>
         <ger:nomeCidadao>Adriano</ger:nomeCidadao>
      </ger:gerarSenhaRequest>
   </soapenv:Body>
</soapenv:Envelope>
```

### Iniciar atendimento

```soap
<soapenv:Envelope xmlns:soapenv="http://schemas.xmlsoap.org/soap/envelope/" xmlns:ger="http://www.fiap.com.br/mba/scj/gerenciamento_filas">
   <soapenv:Header/>
   <soapenv:Body>
      <ger:iniciarAtendimentoRequest>
         <ger:codigoSenha>A0001</ger:codigoSenha>
      </ger:iniciarAtendimentoRequest>
   </soapenv:Body>
</soapenv:Envelope>
```

### Próxima senha

```soap
<soapenv:Envelope xmlns:soapenv="http://schemas.xmlsoap.org/soap/envelope/" xmlns:ger="http://www.fiap.com.br/mba/scj/gerenciamento_filas">
   <soapenv:Header/>
   <soapenv:Body>
      <ger:proximaSenhaRequest>
         <ger:fila>1</ger:fila>
         <ger:numeroPontoAtd>1</ger:numeroPontoAtd>
      </ger:proximaSenhaRequest>
   </soapenv:Body>
</soapenv:Envelope>
```

### Finalizar atendimento

```soap
<soapenv:Envelope xmlns:soapenv="http://schemas.xmlsoap.org/soap/envelope/" xmlns:ger="http://www.fiap.com.br/mba/scj/gerenciamento_filas">
   <soapenv:Header/>
   <soapenv:Body>
      <ger:finalizarAtendimentoRequest>
         <ger:idAtendimento>1</ger:idAtendimento>
         <ger:servico>1</ger:servico>
         <ger:avaliacao>5</ger:avaliacao>
      </ger:finalizarAtendimentoRequest>
   </soapenv:Body>
</soapenv:Envelope>
```
