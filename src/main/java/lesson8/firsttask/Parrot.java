package lesson8.firsttask;

public class Parrot extends Animal {

    public Parrot(String animalName, String voice) {
        super(animalName, voice);
    }

    @Override
    public void voice() {
        System.out.println(getAnimalName() + " " + getVoice());
    }


}
