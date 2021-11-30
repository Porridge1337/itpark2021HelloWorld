package lesson8.firsttask;

public class AnimalMain {

    public static void main(String[] args) {
        Animal[] animals = new Animal[]{new Cat("Барсик", "Мяу"),
                new Dog("Бобик", "Гав"),
                new Parrot("Кеша", "Чик-Чирик"),
                new Frog("Раш", "Ква")};

        for (int i = 0; i <= animals.length - 1; i++) {
           animals[i].voice();
        }

    }

}
