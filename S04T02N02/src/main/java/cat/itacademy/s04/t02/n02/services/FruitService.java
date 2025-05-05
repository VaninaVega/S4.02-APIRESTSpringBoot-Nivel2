package cat.itacademy.s04.t02.n02.services;

import cat.itacademy.s04.t02.n02.model.Fruit;
import cat.itacademy.s04.t02.n02.repository.FruitRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FruitService {

    @Autowired
    private final FruitRepository repository;

    public FruitService(FruitRepository repo) {
        this.repository = repo;
    }

    public Fruit save(Fruit fruit) {
        return repository.save(fruit);
    }

    public Optional<Fruit> findById(Integer id) {
        return repository.findById(id);
    }

    public List<Fruit> findAll() {
        return repository.findAll();
    }

    public Fruit update(Fruit fruit) {
        return repository.save(fruit);
    }

    public void deleteById(int id) {
        repository.deleteById(id);
    }
}

