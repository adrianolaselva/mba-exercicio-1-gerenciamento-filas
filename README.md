# Gerenciamento de filas


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