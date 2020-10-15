package ru.gorinych3.innohomework.homework.task5.part1;

import java.util.*;

public class PetCards {

    private List<Pet> pets;

    public PetCards() {
        pets = new ArrayList<>();
    }

    public void addPet2PetCards(Pet newPet) throws DuplicatePetException {
        for (Pet pet : pets) {
            if (pet.equals(newPet)) {
                System.out.println(newPet.toString());
                throw new DuplicatePetException("Питомец с такими данными уже существует в картотеке");
            }
        }
        pets.add(newPet);
    }

    public Pet findPetByPetName(String petName) {

        for (Pet pet : pets) {
            if (pet.getPetName().equals(petName)) {
                return pet;
            }
        }
        return null;
    }

    public Set<Pet> findPetsByPetName(String petName) {
        Set<Pet> findedPets = new HashSet<>();
        for (Pet pet : pets) {
            if (pet.getPetName().equals(petName)) {
                findedPets.add(pet);
            }
        }
        return findedPets;
    }

    public void changePetDataById(long id, int weight) {
        for (Pet pet : pets) {
            if (Objects.equals(pet.getPetId(), id)) {
                pet.setPetWeight(weight);
            }
        }
    }

    public void changePetDataById(long id, Person person) {
        for (Pet pet : pets) {
            if (Objects.equals(pet.getPetId(), id)) {
                pet.setPetOwner(person);
            }
        }
    }

    public void changePetDataById(long id, Person person, int weight) {
        for (Pet pet : pets) {
            if (Objects.equals(pet.getPetId(), id)) {
                pet.setPetOwner(person);
                pet.setPetWeight(weight);
            }
        }
    }

    public void printPetsCard() {
        pets.sort(Pet::compareTo);
        for (Pet pet : pets) {
            System.out.println(pet);
        }
    }
}
