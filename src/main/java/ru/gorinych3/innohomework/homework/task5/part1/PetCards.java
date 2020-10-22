package ru.gorinych3.innohomework.homework.task5.part1;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

public class PetCards {

    private List<Pet> pets = new ArrayList<>();

    public PetCards() {
    }

    public PetCards(List<Pet> pets) {
        this.pets = pets;
    }

    public void addPet(Pet newPet) throws DuplicatePetException {
        for (Pet pet : pets) {
            if (pet.equals(newPet)) {
                System.out.println(newPet.toString());
                throw new DuplicatePetException("Питомец с такими данными уже существует в картотеке");
            }
        }
        pets.add(newPet);
    }

    public List<Pet> findByPetName(String petName) {
        List<Pet> findedPets = new ArrayList<>();
        for (Pet pet : pets) {
            if (pet.getPetName().equals(petName)) {
                findedPets.add(pet);
            }
        }
        return findedPets;
    }

    public void changePetDataById(UUID id, Pet pet) {
        for (Pet changedPet : pets) {
            if (Objects.equals(changedPet.getPetId(), id)) {
                changedPet.setPetOwner(pet.getPetOwner());
                changedPet.setPetName(pet.getPetName());
                changedPet.setPetWeight(pet.getPetWeight());
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
