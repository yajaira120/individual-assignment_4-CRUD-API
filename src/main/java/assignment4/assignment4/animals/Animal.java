package assignment4.assignment4.animals;


import jakarta.persistence.*;

@Entity
@Table (name = "animals")
public class Animal {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int animalId;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String description;

    @Column(nullable = false)
    private String diet;

    // Constructor
    public Animal(){
    }

    // animalId
    public int getAnimalId() {
        return animalId;
    }

    public void setAnimalId(int animalId){
        this.animalId = animalId;
    }

    // name
    public String getName(){
        return name;
    }

    public void setName(String name){
        this.name = name;
    }

    // description
    public String getDescription(){
        return description;
    }

    public void setDescription(String description){
        this.description = description;
    }

    //diet
    public String getDiet(){
        return diet;
    }

    public void setDiet(String diet){
        this.diet = diet;
    }
}
