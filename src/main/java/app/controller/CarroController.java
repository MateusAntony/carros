package app.controller;


import app.entity.Carro;
import app.services.CarroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.service.annotation.GetExchange;

import java.util.List;

@RestController
@RequestMapping("/api/carro")
public class CarroController {

    @Autowired
    private CarroService service;

    @PostMapping("/save")
    public ResponseEntity<String> save(@RequestBody Carro carro){
        try {
            String mensagem = this.service.save(carro);
            return new ResponseEntity<>(mensagem,HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<String> update(@RequestBody Carro carro, @PathVariable  long id){
        try {
            String mensagem = this.service.update(carro,id);
            return new ResponseEntity<>(mensagem,HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> delete(@PathVariable long id){
        try {
            String mensagem = this.service.delete(id);
            return new ResponseEntity<>(mensagem,HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/findAll")
    public ResponseEntity<List<Carro>> findAll(){
        try {
            List<Carro> carros = this.service.findAll();
            return new ResponseEntity<>(carros,HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/findById")
    public ResponseEntity<Carro> findById(@PathVariable long id){
        try {
            Carro carro = this.service.findById(id);
            return new ResponseEntity<>(carro,HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }

}
