# tapr-2023-equipe1-professor-java

## Autenticação no AZURE
[DOC CLI](https://learn.microsoft.com/en-us/cli/azure/install-azure-cli-linux?pivots=apt)

## DOCs COMOS DB
[DOC COSMOS DB introduction](https://learn.microsoft.com/pt-br/azure/cosmos-db/introduction)

[DOC COSMOS DB roesource model](https://learn.microsoft.com/pt-br/azure/cosmos-db/resource-model)

## Minhas colinhas
```
az login -u claudio.ionck@unville.br
```
```
az login --use-device-code
```
```
az ad signed-in-user show
```
```
https://portal.azure.com/#@univillebr.onmicrosoft.com/resource/subscriptions/1c43c274-f7dd-4647-a446-e270787fb1bc/resourceGroups/rg-tarp2023-brazilsouth-dev/providers/Microsoft.DocumentDB/databaseAccounts/cosmosclaudio/dataExplorer
```
```
http://localhost:8080/swagger-ui.html
```
```
 mvn clean install -DskipTests
```
## Coisas para fazer ao iniciar
[Portal AZURE](https://portal.azure.com/#home)

```
Sempre ao iniciar o projeto - selecionar um arquivo java - ir em java no canto inferior - carregar.
```

```
https://orange-space-rotary-phone-rx6pxwrp7xv259x4-8080.app.github.dev/swagger-ui/index.html
```

```
https://portal.azure.com/#home
```

```
https://orange-space-rotary-phone-rx6pxwrp7xv259x4-8080.app.github.dev/swagger-ui/index.html
```

## Extensões do VSCode
[Java Extension Pack](https://marketplace.visualstudio.com/items?itemName=vscjava.vscode-java-pack)

[Springboot Extension Pack](https://marketplace.visualstudio.com/items?itemName=vmware.vscode-boot-dev-pack)

[Rest Client](https://marketplace.visualstudio.com/items?itemName=humao.rest-client)

## Dependências do projeto (pom.xml)
```
        <dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-web</artifactId>
		</dependency>

		<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-test</artifactId>
			<scope>test</scope>
		</dependency>

		<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-devtools</artifactId>
			<scope>runtime</scope>
		</dependency>
		<dependency>
			<groupId>com.azure.spring</groupId>
			<artifactId>spring-cloud-azure-starter-data-cosmos</artifactId>
			<version>5.5.0</version>
		</dependency>

		<dependency>
			<groupId>com.azure</groupId>
			<artifactId>azure-spring-data-cosmos</artifactId>
			<version>5.5.0</version>
		</dependency>

		<dependency>
			<groupId>com.azure</groupId>
			<artifactId>azure-identity</artifactId>
			<version>1.10.0</version>
		</dependency>

		<dependency>
			<groupId>org.springdoc</groupId>
			<artifactId>springdoc-openapi-starter-webmvc-ui</artifactId>
			<version>2.1.0</version>
		</dependency>
```

## Configuração RBAC de permissão
```
az cosmosdb sql role assignment create --account-name COSMOSDBACCOUNT --resource-group GRUPODERECURSO --role-assignment-id 00000000-0000-0000-0000-000000000002 --role-definition-name "Cosmos DB Built-in Data Contributor" --scope "/" --principal-id GUIDUSUARIOAD
```
