package lesson8.firsttask;

public class Cat extends Animal {

    public Cat(String animalName, String voice) {
        super(animalName, voice);
    }

    @Override
    public void voice() {
        System.out.println(getAnimalName() + " " + getVoice());
    }
}
