package assignment4.assignment4.animals;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


/**
 * AnimalController.java
 * Includes all REST API endpoint mappings for the Animal object.
 */

@RestController
@RequestMapping("/animals")
public class AnimalController {

    @Autowired
    private AnimalService service;

    /**
     * Get a list of Animals in database.
     * http://localhost:8080/animals/all
     * @return a list of Animals objects
     */

    @GetMapping("/all")
    public Object getAllAnimals(){
        return new ResponseEntity<>(service.getAllAnimals(), HttpStatus.OK);
    }

    /**
     * Get an animal by Id
     * http://localhost:8080/animals/2
     *
     * @param animalId unique id for student
     * @return animal
     */

    @GetMapping("/{animalId}")
    public Object getChosenStudent(@PathVariable int animalId){
        return new ResponseEntity<>(service.getAnimalById(animalId), HttpStatus.OK);
    }

    /**
     * Add a new animal
     * http://localhost:8080/animals/new --data '{"name": tiger, "description": "...", "diet": "carnivore"}'
     * @param animal new animal object
     * @return updated list of animals
     */

    @PostMapping("/new")
    public Object addNewAnimal(@RequestBody Animal animal){
        service.addNewAnimal(animal);
        return new ResponseEntity<>(service.getAllAnimals(), HttpStatus.CREATED);
    }

    /**
     * Update an existing animal object
     * http://localhost:8080/animals/update/2 --data '{"studentId": 1, "name": "tiger", "description": "...", "diet": "carnivore"}'
     * @param animalId and animal
     * @return updated animal object
     */

    @PutMapping("/update/{animalId}")
    public Object updateAnimal(@PathVariable int animalId, @RequestBody Animal animal){
        service.updateAnimal(animalId, animal);
        return new ResponseEntity<>(service.getAnimalById(animalId), HttpStatus.CREATED);
    }

    /**
     * Delete existing animal
     * http://localhost:8080/animals/delete/2
     * @param animalId
     * @return updated list of Animals
     */
    @DeleteMapping("/delete/{animalId}")
    public Object deleteAnimalById(@PathVariable int animalId){
        service.deleteAnimalById(animalId);
        return new ResponseEntity<>(service.getAllAnimals(),HttpStatus.OK);
    }

    /**
     * Get all animals by their diet
     * http://localhost:8080/animals/diet/carnivore
     * @param diet
     * @return list of animals who match the diet
     */

    @GetMapping("/diet/{diet}")
    public Object getAnimalsByDiet(@PathVariable String diet){
        return new ResponseEntity<>(service.getAnimalsByDiet(diet), HttpStatus.OK);
    }

    /**
     * Get animals whose name contains a string
     * http://localhost:8080/animals/name?search=tiger
     * @param search
     * @return list of animals that match the search
     */
    @GetMapping("/name")
    public Object getAnimalsByName(@RequestParam(name = "search", defaultValue= "")String search){
        return new ResponseEntity<>(service.getAnimalsByName(search), HttpStatus.OK);
    }



}
