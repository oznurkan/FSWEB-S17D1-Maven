package com.workintech.fswebs17d1.controller;

import com.workintech.fswebs17d1.entity.Animal;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/workintech/animal")
public class AnimalController {

    private Map<Integer, Animal> animals = new HashMap<>();


    @GetMapping("")
    public List<Animal> getAnimalValue(){
        return animals.values().stream().toList();
    }

    @GetMapping("/{id}")
    public Animal getById(@PathVariable("id") int id) {
        if (id<0) {
            System.out.println("Id bulunamadı: " + id);
            return null;
        }
        return animals.get(id);
    }

    @PostMapping("")
    public Animal createAnimal(@RequestBody Animal animal) {
        animals.put(animal.getId(), animal);
        return animal;
    }


    @PutMapping("/{id}")
    public Animal updateAnimal(@PathVariable Integer id, @RequestBody Animal animal){
        animals.put(id, new Animal(id, animal.getName()));
        return animals.get(id);
    }

    @DeleteMapping("/{id}")
    public Animal shouldDeleteAnimal(@PathVariable Integer id){
        return animals.remove(id);
    }


}
