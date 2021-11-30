package lesson8.firsttask;

public class Frog extends Animal {

    public Frog(String animalName, String voice) {
        super(animalName, voice);
    }

    @Override
    public void voice() {
        System.out.println(getAnimalName() + " " + getVoice());
    }
}
