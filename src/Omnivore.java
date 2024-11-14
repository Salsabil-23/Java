enum Food{MEAT, PLANT, BOTH}
public interface Omnivore<T> extends Carnivore, Herbivore {
    public void eatPlantAndMeet(T food);
}
