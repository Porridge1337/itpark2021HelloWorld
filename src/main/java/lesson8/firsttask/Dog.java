package lesson8.firsttask;

public class Dog extends Animal {

    public Dog(String animalName, String voice) {
        super(animalName, voice);
    }

    @Override
    public void voice() {
        System.out.println(getAnimalName() + " " + getVoice());
    }
}
