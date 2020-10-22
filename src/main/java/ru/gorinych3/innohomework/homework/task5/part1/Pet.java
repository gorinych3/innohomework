package ru.gorinych3.innohomework.homework.task5.part1;

import ru.gorinych3.innohomework.homework.task2.part3.Person;

import java.util.UUID;

public class Pet implements Comparable<Pet> {

    private final UUID petId;

    private String petName;

    private Person petOwner;

    private int petWeight;

    public Pet(String petName, Person owner, int petWeight) {
        this.petName = petName;
        this.petOwner = owner;
        this.petWeight = petWeight;
        petId = UUID.randomUUID();
    }

    public UUID getPetId() {
        return this.petId;
    }

    public String getPetName() {
        return petName;
    }

    public void setPetName(String petName) {
        this.petName = petName;
    }

    public Person getPetOwner() {
        return petOwner;
    }

    public void setPetOwner(Person petOwner) {
        this.petOwner = petOwner;
    }

    public int getPetWeight() {
        return petWeight;
    }

    public void setPetWeight(int petWeight) {
        this.petWeight = petWeight;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Pet)) return false;
        Pet pet = (Pet) o;
        return Double.compare(pet.petWeight, petWeight) == 0 &&
                petName.equals(pet.petName) &&
                petOwner.equals(pet.petOwner);
    }

    @Override
    public int hashCode() {
        return (int) petId.getMostSignificantBits();
    }

    @Override
    public int compareTo(Pet o) {
        int result = this.petOwner.compareTo(o.petOwner);
        if (result == 0) {
            result = this.petName.compareTo(o.petName);
        }
        if (result == 0) {
            return this.petWeight - o.petWeight;
        }
        return result;
    }

    @Override
    public String toString() {
        return "Pet{" +
                "petId=" + petId +
                ", petName='" + petName + '\'' +
                ", petOwner=" + petOwner +
                ", petWeight=" + petWeight +
                '}';
    }
}
