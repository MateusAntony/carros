package app.controller;


import app.entity.Marca;
import app.services.MarcaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/marca")
@CrossOrigin("*")
public class MarcaController {

    @Autowired
    private MarcaService marcaService;

    @GetMapping("/findAll")
    public ResponseEntity<List<Marca>> findAll(){
        List<Marca> lista = this.marcaService.findAll();
        return new ResponseEntity<List<Marca>>(lista, HttpStatus.OK);
    }

    @GetMapping("/findByNome")
    public ResponseEntity<List<Marca>> findByNome(@RequestParam("nome") String nome){
        List<Marca> lista = this.marcaService.findByNome(nome);
        return new ResponseEntity<>(lista, HttpStatus.OK);
    }

    @GetMapping("/findById/{id}")
    public ResponseEntity<Marca> findById(@PathVariable("id") long id){
        Marca marca = this.marcaService.findById(id);
        return new ResponseEntity<>(marca, HttpStatus.OK);
    }

    @DeleteMapping("/deleteById/{id}")
    public ResponseEntity<String> deleteById(@PathVariable("id") long id){
        String mensagem = this.marcaService.deleteById(id);
        return new ResponseEntity<>(mensagem, HttpStatus.OK);
    }

    @PostMapping("/save")
    public ResponseEntity<String> save(@RequestBody Marca marca){
        String mensagem = this.marcaService.save(marca);
        return new ResponseEntity<>(mensagem, HttpStatus.OK);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<String> update(@RequestBody Marca marca, @PathVariable("id") long id){
        String mensagem = this.marcaService.update(marca, id);
        return new ResponseEntity<>(mensagem, HttpStatus.OK);
    }

}
