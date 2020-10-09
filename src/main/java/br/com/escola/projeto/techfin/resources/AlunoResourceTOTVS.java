package br.com.escola.projeto.techfin.resources;


public class AlunoResourceTOTVS {
	
}
/*
import java.net.URI;


import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.totvs.tjf.api.context.stereotype.ApiGuideline;
import com.totvs.tjf.api.context.stereotype.ApiGuideline.ApiGuidelineVersion;
import com.totvs.tjf.api.context.stereotype.openapi.MessageDocumentationApi;
import com.totvs.tjf.api.context.stereotype.openapi.ProductInformationApi;
import com.totvs.tjf.api.context.stereotype.openapi.ProductInformationEndPoint;
import com.totvs.tjf.api.context.stereotype.openapi.XTOTVSApi;
import com.totvs.tjf.api.context.stereotype.openapi.XTOTVSEndPoint;
import com.totvs.tjf.api.context.v2.response.ApiCollectionResponse;

import br.com.escola.projeto.techfin.entities.Aluno;
import br.com.escola.projeto.techfin.respositories.AlunoRepository;
import br.com.escola.projeto.techfin.services.AlunoService;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.servers.Server;
import io.swagger.v3.oas.annotations.servers.ServerVariable;

 * @RestController
 * 
 * @RequestMapping(path = "/api/v1/alunos", produces =
 * MediaType.APPLICATION_JSON_VALUE)
 * 
 * @CrossOrigin(origins = "*", allowedHeaders = "*")
 * 
 * @ApiGuideline(ApiGuidelineVersion.V2)
 * 
 * @OpenAPIDefinition(info = @Info(title = "API Turma POC TechFin", description
 * = "Controle de Alunos", version = "1.0", contact = @Contact(name = "", url =
 * "", email = "")), servers = @Server(url = "{{host}}/api/v1/alunos",
 * description = "Descrição do Server", variables = {
 * 
 * @ServerVariable(name = "serverUrl", defaultValue = "localhost"),
 * 
 * @ServerVariable(name = "serverHttpPort", defaultValue = "8080") }))
 * 
 * @XTOTVSApi(messageDocumentation = @MessageDocumentationApi(name = "Product",
 * description = "Produto", segment = "Saúde"), productInformation
 * = @ProductInformationApi(product = "OpenApiSample", contact =
 * "tjf@totvs.com.br", description = "Open Api Sample", helpUrl =
 * "http://tjf.totvs.com.br")) public class AlunoResourceTOTVS {
 * 
 * @Autowired private AlunoService service;
 * 
 * @Autowired private AlunoRepository repository;
 * 
 * @Operation(summary = "Buscar Alunos", description = "Buscar lista de Alunos",
 * operationId = "AlunoGet", tags = { "client" }, responses =
 * { @ApiResponse(responseCode = "200", description =
 * "Lista de alunos retornada."),
 * 
 * @ApiResponse(responseCode = "400", description =
 * "Erro ao retornar a lista de alunos.") })
 * 
 * @GetMapping()
 * 
 * @XTOTVSEndPoint(productInformation
 * = @ProductInformationEndPoint(minimalVersion = "2.0", product =
 * "OpenApiSample")) public ApiCollectionResponse<Aluno> findAll() { return
 * ApiCollectionResponse.of(repository.findAll()); }
 * 
 * @Operation(summary = "Buscar Aluno por Id", description =
 * "Buscar Aluno por Id", operationId = "produtoGet", tags = { "client" },
 * responses = { @ApiResponse(responseCode = "200", description =
 * "Aluno retornado."),
 * 
 * @ApiResponse(responseCode = "400", description = "Erro ao retornar aluno.")
 * })
 * 
 * @GetMapping(value = "/{id}")
 * 
 * @XTOTVSEndPoint(productInformation
 * = @ProductInformationEndPoint(minimalVersion = "2.0", product =
 * "OpenApiSample")) public ResponseEntity<Aluno> findById(@PathVariable Long
 * id) { Aluno aluno = service.findById(id); return
 * ResponseEntity.ok().body(aluno); }
 * 
 * @PostMapping public ResponseEntity<Aluno> insert(@Valid @RequestBody Aluno
 * obj) { service.insert(obj); URI locationURI =
 * ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand
 * (obj.getId()) .toUri(); return ResponseEntity.created(locationURI).body(obj);
 * }
 * 
 * @DeleteMapping(value = "/{id}") public ResponseEntity<Void>
 * delete(@PathVariable Long id) { service.delete(id); return
 * ResponseEntity.noContent().build(); }
 * 
 * @PutMapping(value = "/{id}") public ResponseEntity<Aluno>
 * update(@PathVariable Long id, @Valid @RequestBody Aluno obj) { obj =
 * service.update(id, obj); return ResponseEntity.ok().body(obj); }
 * 
 * }
 */