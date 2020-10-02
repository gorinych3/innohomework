package ru.gorinych3.innohomework.part1.homework2.task3;

public class BubbleSort implements UserSortable{
    @Override
    public void sortArrPersons(Person [] persons, boolean genException) throws DuplicatePersonException {

        long startTimeMills = System.currentTimeMillis();

        Person person;

        for (int i = 0; i < persons.length; i++){
            for (int j = 0; j < persons.length - 1 - i; j++){
                if((persons[j].getName().compareTo(persons[j+1].getName()) > 0 &&
                        persons[j].getSex() == persons[j + 1].getSex() &&
                        persons[j].getAge() == persons[j + 1].getAge()) ||
                        (persons[j].getSex() == Sex.WOMAN && persons[j + 1].getSex() == Sex.MAN) ||
                        (persons[j].getSex() == persons[j + 1].getSex() &&
                                persons[j].getAge() < persons[j + 1].getAge())){
                    person = persons[j];
                    persons[j] = persons[j + 1];
                    persons[j + 1] = person;
                } else if (persons[j].getAge() == persons[j + 1].getAge() &&
                        persons[j].getName().equals(persons[j + 1].getName()) && genException){
                    throw new DuplicatePersonException("В списке есть дубликат пользователя! : " + persons[j].toString());
                }
            }
        }

        for(Person person1 : persons){

            System.out.println(person1.toString());
        }
        System.out.println("----------------------------------------");
        System.out.println("BubbleSort.sortArrPersons.TimeMills = " + (System.currentTimeMillis() - startTimeMills));
        System.out.println();
    }
}
