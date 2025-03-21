package assignment4.assignment4.animals;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AnimalService {

    @Autowired
    private AnimalRepository animalRepository;

    /**
     * Fetch all Animals
     * @return list of all animals
     */

    public List<Animal> getAllAnimals(){
        return animalRepository.findAll();
    }

    /**
     * Fetch animal by Id
     * @param animalId
     * @return a unique animal
     */

    public Animal getAnimalById(int animalId){
        return animalRepository.findById(animalId).orElse(null);
    }

    /**
     * Add new animal
     * @param animal to add
     */

    public void addNewAnimal(Animal animal){
        animalRepository.save(animal);
    }

    /**
     * Update existing animal
     * @param animalId
     * @param animal
     */
    public void updateAnimal(int animalId, Animal animal){
        Animal existing = getAnimalById(animalId);
        existing.setName(animal.getName());
        existing.setDescription(animal.getDescription());
        existing.setDiet(animal.getDiet());

        animalRepository.save(existing);
    }

    /**
     * Delete existing animal
     * @param animalId
     */

    public void deleteAnimalById(int animalId){
        animalRepository.deleteById(animalId);
    }

    /**
     * Get all animals that have a certain diet
     */
    public List<Animal> getAnimalsByDiet(String diet){
        return animalRepository.getAnimalsByDiet(diet);
    }

    /**
     * Get all animals whose name contains a given string
     * @param  name
     * @return list of matcjing students
     */
    public List<Animal> getAnimalsByName(String name){
        return animalRepository.getAnimalName(name);
    }

}
