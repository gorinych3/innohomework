package ru.gorinych3.innohomework.homework.task5.part1;

import ru.gorinych3.innohomework.homework.task2.part3.Person;
import ru.gorinych3.innohomework.homework.task2.part3.Sex;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * Разработать программу – картотеку домашних животных. У каждого животного есть уникальный идентификационный номер,
 * кличка, хозяин (объект класс Person с полями – имя, возраст, пол), вес.
 * <p>
 * Реализовать:
 * <p>
 * метод добавления животного в общий список (учесть, что добавление дубликатов должно приводить к исключительной ситуации)
 * поиск животного по его кличке (поиск должен быть эффективным)
 * изменение данных животного по его идентификатору
 * вывод на экран списка животных в отсортированном порядке. Поля для сортировки –  хозяин, кличка животного, вес.
 */
public class Main {

    List<Person> owners = new ArrayList<>();


    public static void main(String[] args) {
        Main main = new Main();

        main.generateArrPersons(10);

        PetCards petCards = new PetCards();
        petCards.printPetsCard();

        main.initPetsCard(petCards, 100);

        petCards.printPetsCard();

        petCards.addPet2PetCards(
                new Pet("НОВАЯ КЛИЧКА", main.owners.get(9), (int) (Math.random() * 10) + 1));

        System.out.println();
        System.out.println("========================================================");
        petCards.printPetsCard();


        System.out.println();
        System.out.println("===========================================");
        System.out.println(petCards.findByPetName("НОВАЯ КЛИЧКА"));

        System.out.println();
        System.out.println("======================================================");
        System.out.println(petCards.findByPetName("Том"));

        System.out.println();
        System.out.println("======================================================");
        System.out.println(petCards.findByPetName("НОВАЯ КЛИЧКА"));
        UUID id = petCards.findByPetName("НОВАЯ КЛИЧКА").get(0).getPetId();
        petCards.changePetDataById(id, new Pet("КЛИЧКА", main.owners.get(9), 5));
        System.out.println(petCards.findByPetName("КЛИЧКА"));
    }

    private void generateArrPersons(int arrSize) {

        if (arrSize > 100) arrSize = 100;
        for (int i = 0; i < arrSize; i++) {
            Person person = new Person();
            person.setSex(generateSex());
            person.setName(generateName(person.getSex()));
            person.setAge(generateAge());
            owners.add(person);
        }
    }

    private void initPetsCard(PetCards petCards, int size) {
        for (int i = 0; i < size; i++) {
            String petName = generatePetName();
            Person person = owners.get((int) (Math.random() * owners.size()));
            int petWeight = (int) (Math.random() * 10) + 1;

            petCards.addPet2PetCards(new Pet(petName, person, petWeight));
        }
    }

    private int generateAge() {
        return (int) (Math.random() * 101);
    }

    private String generateName(Sex sex) {
        String[] manNames = {"Александр", "Алексей", "Анатолий", "Андрей", "Антон", "Аркадий", "Арсений", "Артём",
                "Артур", "Борис", "Вадим", "Валентин", "Валерий", "Василий", "Виктор", "Виталий", "Владимир",
                "Владислав", "Вячеслав", "Георгий", "Глеб", "Григорий", "Даниил", "Денис", "Дмитрий", "Евгений",
                "Егор", "Иван", "Игорь", "Илья", "Кирилл", "Константин", "Лев", "Леонид", "Максим", "Марк", "Матвей",
                "Михаил", "Никита", "Николай", "Олег", "Павел", "Пётр", "Роман", "Руслан", "Сергей", "Степан", "Тимур",
                "Фёдор", "Юрий", "Ярослав"};

        String[] womanNames = {"Алиса", "Александра", "Алёна", "Алина", "Алла", "Анастасия", "Анжелика",
                "Анна", "Валентина", "Валерия", "Вера", "Вероника", "Виктория", "Галина", "Дарья", "Диана", "Ева",
                "Евгения", "Екатерина", "Алёна", "Елена", "Елизавета", "Жанна", "Инна", "Ирина", "Карина", "Кристина",
                "Ксения", "Лариса", "Любовь", "Людмила", "Маргарита", "Марина", "Мария", "Мила", "Милана", "Надежда",
                "Наталья", "Ника", "Нина", "Оксана", "Олеся", "Ольга", "Полина", "Руслана", "Светлана", "София",
                "Софья", "Тамара", "Татьяна", "Юлия", "Яна"};

        if (sex == Sex.MAN) {
            return manNames[(int) (Math.random() * manNames.length)];

        } else
            return womanNames[(int) (Math.random() * womanNames.length)];
    }

    private Sex generateSex() {
        if ((int) (Math.random() * 10) % 2 == 0) {
            return Sex.MAN;
        } else return Sex.WOMAN;
    }

    private String generatePetName() {
        String[] petNames = {"Арчи", "Алекс", "Амур", "Алтaй", "Альф", "Алмаз", "Атос", "Амиго", "Барон", "Бутч",
                "Боня", "Бим", "Джек", "Дик", "Джонни", "Деймон", "Дёма", "Джой", "Дружок", "Джерри", "Жорик", "Жан",
                "Жак", "Каспер", "Кекс", "Кузя", "Кай", "Кент", "Карат", "Клайд", "Лорд", "Лео", "Лайк", "Лари",
                "Локки", "Люцифер", "Макс", "Майло", "Марсель", "Малыш", "Майк", "Пират", "Пайк", "Патрик", "Принц",
                "Полкан", "Рэкс", "Риччи", "Рэй", "Ричард", "Рэм", "Рой", "Спайк", "Скуби Ду", "Саймон", "Стич",
                "Скай", "Султан", "Снежок", "Сириус", "Снупи", "Спартак", "Тимка", "Тошка", "Тишка", "Тимоша",
                "Тор", "Тобик", "Том", "Фокс", "Фил", "Филя", "Хатико", "Хан", "Цезарь", "Цербер", "Чарли", "Чак",
                "Чип", "Честер", "Чапик", "Шарик", "Шерхан", "Аська", "Айра", "Аврора", "Алиса", "Ада", "Альба",
                "Багира", "Берта", "Буся", "Белла", "Бусинка", "Белка", "Гретта", "Габи", "Грейс", "Гайка", "Габриель",
                "Джесси", "Дина", "Дана", "Джессика", "Дейзи", "Джина", "Жуля", "Жасмин", "Жучка", "Жаклин", "Кнопка",
                "Клёпа", "Лора", "Ляля", "Ласка", "Марта", "Молли", "Ника", "Нюша", "Найда", "Полли", "Пуговка",
                "Пантера", "Пелагея", "Пушинка", "Тори", "Тося", "Тина", "Чапа", "Шейла"};
        return petNames[(int) (Math.random() * petNames.length)];
    }
}
