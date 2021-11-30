package lesson8.firsttask;

public abstract class Animal {

    private String animalName;
    private String voice;

    public Animal(String animalName, String voice) {
        this.animalName = animalName;
        this.voice = voice;
    }

    public abstract void voice();

    public String getAnimalName() {
        return animalName;
    }

    public void setAnimalName(String animalName) {
        this.animalName = animalName;
    }
    public String getVoice() {
        return voice;
    }

    public void setVoice(String voice) {
        this.voice = voice;
    }


}
