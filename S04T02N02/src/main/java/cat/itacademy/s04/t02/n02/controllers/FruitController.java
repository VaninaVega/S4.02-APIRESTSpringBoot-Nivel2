package cat.itacademy.s04.t02.n02.controllers;

import cat.itacademy.s04.t02.n02.model.Fruit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import cat.itacademy.s04.t02.n02.services.FruitService;

import java.util.List;
import java.util.Optional;


    @RestController
    @RequestMapping("/fruits")
    public class FruitController {
        @Autowired
        private final FruitService service;

        public FruitController(FruitService service) {
            this.service = service;
        }

        @PostMapping
        public ResponseEntity<Fruit> addFruit(@RequestBody Fruit fruit) {
            return ResponseEntity.ok(service.save(fruit));
        }

        @GetMapping("/{id}")
        public ResponseEntity<Fruit> getFruit(@PathVariable Integer id) {
            return service.findById(id)
                    .map(ResponseEntity::ok)
                    .orElse(ResponseEntity.notFound().build());
        }

        @GetMapping
        public ResponseEntity<List<Fruit>> getAll() {
            return ResponseEntity.ok(service.findAll());
        }

        @PutMapping("/{id}")
        public ResponseEntity<Fruit> updateFruit(@PathVariable Integer id, @RequestBody Fruit fruit) {
            return service.findById(id).map(existing -> {
                fruit.setId(id);
                return ResponseEntity.ok(service.update(fruit));
            }).orElse(ResponseEntity.notFound().build());
        }

        @DeleteMapping("/{id}")
        public Optional<ResponseEntity<String>> delete(@PathVariable int id) {
            return service.findById(id).map(existing -> {
                service.deleteById(id);
                return ResponseEntity.ok("Deleted successfully");
            });

        }
}