package com.bn.demo.controllers;

import com.bn.demo.models.ProjetoModel;
import com.bn.demo.services.ProjetoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = {"/projetos", "/projetos/"})
public class ProjetoController {

    @Autowired
    private ProjetoService projetoService;

    @GetMapping
        public ResponseEntity<List<ProjetoModel> > buscarTodosOsProjetos(){
          List<ProjetoModel> requeste = projetoService.buscarTodosOsProjetos();
        return ResponseEntity.ok().body(requeste);
    }

    @PostMapping
    public ResponseEntity <ProjetoModel> criarProjetos(@RequestBody ProjetoModel projetoModel){
        ProjetoModel requeste = projetoService.criarProjeto(projetoModel);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri()
                .path("/{id}").buildAndExpand(projetoModel.getId())
                .toUri();
        return  ResponseEntity.created(uri).body(requeste);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletarProjetos(@PathVariable Long id){
        projetoService.deletarProjeto(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}")
    public Optional<ProjetoModel> buscarProjetoPorId(@PathVariable Long id){
        return  projetoService.buscarProjetoId(id);
    }

    @PutMapping("/{id}")
    public ResponseEntity <ProjetoModel> atualizarProjetos(@PathVariable Long id, @RequestBody ProjetoModel ProjetoModel){
        ProjetoModel requeste = projetoService.atualizarProjeto(id, ProjetoModel);
        return  ResponseEntity.ok().body(requeste);

    }








}
