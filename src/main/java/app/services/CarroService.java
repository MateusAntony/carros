package app.services;

import app.entity.Carro;
import app.entity.Marca;
import app.repository.CarroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarroService {

    @Autowired
    private CarroRepository repository;

    public CarroService(CarroRepository repository){
        this.repository= repository;
    }

    public String save(Carro carro){
        repository.save(carro);
        return "Carro salvo com Sucesso";
    }

    public String update(Carro carro, long id){
        carro.setId(id);
        repository.save(carro);
        return "Carro alterado com Sucesos";
    }

    public String delete(long id){
        repository.deleteById(id);
        return "Carro deletado com Sucesso";
    }

    public List<Carro> findAll(){
        List<Carro> lista = repository.findAll();
        return lista;
    }

    public Carro findById(long id){
        Carro carro = repository.findById(id).get();
        return carro;
    }

    public List<Carro> findByNome(String nome){
        return repository.findByNome(nome);
    }

    public List<Carro> findByMarca(long idMarca){
        Marca marca = new Marca();
        marca.setId(idMarca);
        return repository.findByMarca(marca);
    }

    public List<Carro> findAcimaAno(int ano){
        return repository.findAcimaAno(ano);
    }



}
