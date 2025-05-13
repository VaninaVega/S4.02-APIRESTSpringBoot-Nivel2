package cat.itacademy.s04.t02.n02.services;

import cat.itacademy.s04.t02.n02.exceptions.FruitDoesNotExistException;
import cat.itacademy.s04.t02.n02.exceptions.FruitNotFoundException;
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

    //public Optional<Fruit> findById(Integer id) {

    public Fruit getFruitById(Integer id) {
        return repository.findById(id)
                .orElseThrow(() -> new FruitNotFoundException("Fruit with ID " + id + " not found."));
    }

    public List<Fruit> findAll() {
        return repository.findAll();
    }

    public Fruit update(Fruit fruit) {
        if (!repository.existsById(fruit.getId())) {
            throw new FruitDoesNotExistException("Fruit with ID " + fruit.getId() + " does not exist.");
        }
        return repository.save(fruit);
    }

    public void deleteById(int id) {

        if (!repository.existsById(id)) {
            throw new FruitDoesNotExistException("Cannot be removed: fruit with ID " + id + " does not exist.");
        }
        repository.deleteById(id);
    }
}

