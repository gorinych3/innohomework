package ru.gorinych3.innohomework.homework.task2.part3;

/**
 * Дан массив объектов Person. Класс Person характеризуется полями age (возраст, целое число 0-100),
 * sex (пол – объект класса Sex со строковыми константами внутри MAN, WOMAN), name (имя - строка).
 * Создать два класса, методы которых будут реализовывать сортировку объектов. Предусмотреть единый интерфейс
 * для классов сортировки. Реализовать два различных метода сортировки этого массива по правилам:
 * первые идут мужчины
 * выше в списке тот, кто более старший
 * имена сортируются по алфавиту
 * Программа должна вывести на экран отсортированный список и время работы каждого алгоритма сортировки.
 * Предусмотреть генерацию исходного массива (10000 элементов и более).
 * Если имена людей и возраст совпадают, выбрасывать в программе пользовательское исключение.
 * <p>
 * ВАЖНО!!!! в методы сортировки добавлена переменная типа boolean для проверки дубликатов. Причина: при размере массива
 * более 100 человек часто появляются дубликаты и постоянно генерируется исключение
 */
public class Main {

    public static void main(String[] args) throws DuplicatePersonException {

        Main main = new Main();

        UserSortable bubbleSort = new BubbleSort();
        UserSortable selectionSort = new SelectionSort();

        boolean genException = true;
        // для тестирования гита

        bubbleSort.sortArrPersons(main.generateArrPersons(10000), genException);
        selectionSort.sortArrPersons(main.generateArrPersons(10000), genException);
    }

    /**
     * по условию размер массива должен быть от 10 000, поэтому введено условие на проверку размерности массива
     *
     * @param arrSize
     * @return
     */
    private Person[] generateArrPersons(int arrSize) {

        if (arrSize < 10000) arrSize = 10000;
        Person[] persons = new Person[arrSize];

        for (int i = 0; i < arrSize; i++) {
            Person person = new Person();
            person.setAge(generateAge());
            person.setSex(genereteSex());
            person.setName(genereteName(person.getSex()));

            persons[i] = person;
        }
        return persons;
    }

    private int generateAge() {
        return (int) (Math.random() * 101);
    }

    private String genereteName(Sex sex) {
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

    private Sex genereteSex() {
        if ((int) (Math.random() * 10) % 2 == 0) {
            return Sex.MAN;
        } else return Sex.WOMAN;
    }
}
