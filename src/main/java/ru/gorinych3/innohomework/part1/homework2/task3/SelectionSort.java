package ru.gorinych3.innohomework.part1.homework2.task3;

public class SelectionSort implements UserSortable {
    @Override
    public void sortArrPersons(Person[] persons, boolean genException) throws DuplicatePersonException {

        long startTimeMills = System.currentTimeMillis();

        for(int i = 0; i < persons.length; i++){

            Person firstPerson = persons[i];
            int min = i;

            for(int j = i + 1; j < persons.length; j++){
                if ((firstPerson.getName().compareTo(persons[j].getName()) > 0 &&
                        firstPerson.getSex() == persons[j].getSex() &&
                        firstPerson.getAge() == persons[j].getAge()) ||
                        (firstPerson.getSex() == Sex.WOMAN && persons[j].getSex() == Sex.MAN) ||
                        (firstPerson.getSex() == persons[j].getSex() && firstPerson.getAge() < persons[j].getAge())){
                    firstPerson = persons[j];
                    min = j;
                } else if (firstPerson.getAge() == persons[j].getAge() &&
                        firstPerson.getName().equals(persons[j].getName()) && genException) {
                    throw new DuplicatePersonException("В списке есть дубликат пользователя! : " + firstPerson.toString());
                }
            }

            if (i != min){
                Person tempPerson = persons[i];
                persons[i] = firstPerson;
                persons[min] = tempPerson;
            }
        }

        for(Person person1 : persons){
            System.out.println(person1.toString());
        }
        System.out.println("----------------------------------------");
        System.out.println("Selection.sortArrPersons.TimeMills = " + (System.currentTimeMillis() - startTimeMills));
        System.out.println();
    }
}
