package assignment4.assignment4.animals;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AnimalRepository extends JpaRepository<Animal, Integer> {

    @Query(value = "select * from animals where name like concat ('%', ?1, '%')", nativeQuery = true)
    List<Animal> getAnimalName(String name);

    @Query(value = "select * from animals where description like concat ('%', ?1, '%')" ,nativeQuery = true)
    List<Animal> getDescription(String description);

    @Query(value = "select * from animals where diet = ?1", nativeQuery = true)
    List<Animal> getAnimalsByDiet(String diet);
}
