public class Zoo {
    Animal [] animals = new Animal[25];
    Aquatic [] aquaticAnimals = new Aquatic[10];
    private String name;
    private String city;
    private int nbrCages;
    public String getName(){
        return this.name;
    }
    public void setName(String name){
        if(name.isEmpty()){
            System.out.println("le nom ne doit pas etre vide\n");
        }
        else {
            this.name = name;
        }
    }
    public String getCity(){
        return this.city;
    }
    public void setCity(String city){
        this.city = city;
    }
    public int getNbrCages(){
        return this.nbrCages;
    }
    public void setNbrCages(int nbrCages){
        this.nbrCages = nbrCages;
    }

    public void addAquaticAnimal(Aquatic aquatic) {
        int i = 0;
        boolean flag = false;
        while (i < aquaticAnimals.length && !flag) {
            if (aquaticAnimals[i] == null) {
                aquaticAnimals[i] = aquatic;
                flag = true;
            } else {
                i++;
            }
        }
    }

    public Zoo(String name, String city, final int nbrCages) {
        this.setName(name);
        this.setCity(city);
        this.setNbrCages(nbrCages);
    }
    public void displayZoo() {
        System.out.println("Nom du zoo: " + this.getName() + "\n");
        System.out.println("Nom de la ville: " + this.getCity() + "\n");
        System.out.println("Nombre des cages: " + this.getNbrCages() + "\n");
        this.afficheAnimals();
    }
    public void afficheAnimals() {
        for (Animal animal : this.animals) {
            if(animal != null){
                System.out.println(animal.toString());
            }
        }
        System.out.println("fin du tableau. \n");
    }
    boolean addAnimal(Animal animal) {
        boolean test=false;
        int i=0;
        int j = this.searchAnimal(animal);
        if (j == -1 && this.isZooFull()==false) {
            while(!test && i<this.animals.length) {
                if (this.animals[i] == null) {
                    this.animals[i] = animal;
                    System.out.print("Ajout avec succès! \n");
                    test = true;
                } else {
                    i++;
                }
            }
        }
        return test;
    }
    int searchAnimal(Animal animal) {
        for (int i = 0; i < this.animals.length; i++) {
            if (this.animals[i] != null && this.animals[i].getName().equals(animal.getName())) {
                System.out.print("L'animal cherché est à la position: \n");
                return i;
            }
        }
        System.out.print("Animal introuvable! \n");
        return -1;
    }
    boolean removeAnimal(Animal animal) {
        int indexToRemove = this.searchAnimal(animal);
        if (indexToRemove != -1) {
            for (int i = indexToRemove; i < this.animals.length - 1; i++) {
                this.animals[i] = this.animals[i + 1];
            }
            this.animals[this.animals.length - 1] = null;
            System.out.println("Animal supprimé avec succès !");
            return true;
        }
        System.out.println("Animal introuvable, impossible de supprimer.");
        return false;
    }
    public boolean isZooFull() {
        int nbAnimals = this.nbAnimals();
        if (nbAnimals == this.nbrCages) {
            return true;
        }
        return false;
    }
    public int nbAnimals() {
        int nbAnimals = 0;
        for (int i = 0; i < this.animals.length; i++) {
            if (this.animals[i] != null) {
                nbAnimals++;
            }
        }
        return nbAnimals;
    }
    public Zoo comparerZoo(Zoo z1, Zoo z2) {
        int i = z1.nbAnimals();
        int j = z2.nbAnimals();
        if (i == j) {
            System.out.print("Les deux zoos ont le même nombre d'animaux. \n");
            return null;
        } else if (i > j) {
            System.out.print(z1.name + " a le plus d'animaux. \n");
            return z1;
        }
        else {
            System.out.print(z2.name + " a le plus d'animaux. \n");
            return z2;
        }
    }
    @Override
    public String toString() {
        return "Zoo Name: " + name + ", City: " + city + ", Number of Cages: " + nbrCages;
    }
    public float maxPenguinSwimmingDepth(){
        float maxDepth = 0;

        for (Aquatic animal : aquaticAnimals) {
            if (animal instanceof Penguin) {
                Penguin penguin = (Penguin) animal;
                if (penguin.getSwimmingDepth() > maxDepth) {
                    maxDepth = penguin.getSwimmingDepth();
                }
            }
        }
        return maxDepth;
    }
    public void displayNumberOfAquaticsByType(){
        int penguins = 0;
        int dolphins = 0;
        for (Aquatic animal : aquaticAnimals) {
            if (animal instanceof Penguin) {
                penguins++;
            }
            else if (animal instanceof Dolphin) {
                dolphins++;
            }
        }
        System.out.println("Number Of Penguins : " + penguins);
        System.out.println("Number Of Dolphins : " + dolphins);
    }

}