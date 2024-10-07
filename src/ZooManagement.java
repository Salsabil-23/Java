import java.util.Scanner;
public class ZooManagement {

    public static void main(String[] args) {
        int nbrCages, animalAge, nbAnimals;
        boolean animalMammal;
        String zooName, animalFamily, animalName, city, animalName2, animalName3;

        System.out.print("Entrez les informations du zoo: \n");
        Scanner reader5 = new Scanner(System.in);
        System.out.print("Entrez le nom du zoo : \n");
        zooName = reader5.nextLine();
        Scanner reader6 = new Scanner(System.in);
        System.out.print("Entrez le nom de la ville : \n");
        city = reader6.nextLine();
        do {
            Scanner reader7 = new Scanner(System.in);
            System.out.print("Entrez le nombre de cages (entre 1 et 25) : \n");
            nbrCages = reader7.nextInt();
        }while (nbrCages <=0 || nbrCages > 25);
        Zoo myZoo = new Zoo(zooName,city,nbrCages);

        do{
            Scanner sc = new Scanner(System.in);
            System.out.print("Entrez le nombre des animaux: \n");
            nbAnimals = sc.nextInt();
        }while(nbAnimals>nbrCages || nbAnimals<=0);
        for(int i = 0; i < nbAnimals; i++){
            System.out.print("Entrez les informations de l'animal: \n");
            Scanner reader1 = new Scanner(System.in);
            System.out.print("Entrez la famille de l'animal: \n");
            animalFamily = reader1.nextLine();
            Scanner reader2 = new Scanner(System.in);
            System.out.print("Entrez le nom de l'animal: \n");
            animalName = reader2.nextLine();
            Scanner reader3 = new Scanner(System.in);
            System.out.print("Entrez l'age de l'animal: \n");
            animalAge = reader3.nextInt();
            Scanner reader4 = new Scanner(System.in);
            System.out.print("Est ce que cet animal est mammal?(mammal: true, non mammal: false): \n");
            animalMammal = reader4.nextBoolean();

            Animal animal = new Animal(animalFamily,animalName,animalAge,animalMammal);
            System.out.println(myZoo.addAnimal(animal));
        }
        System.out.println(myZoo.toString());
        myZoo.afficheAnimals();
        Scanner animName = new Scanner(System.in);
        System.out.print("Entrez le nom de l'animal à chercher: \n");
        animalName2 = animName.nextLine();
        Animal anim = new Animal(animalName2);
        System.out.println(myZoo.searchAnimal(anim));
        Scanner animNams = new Scanner(System.in);
        System.out.print("Entrez le nom de l'animal à supprimer: \n");
        animalName3 = animNams.nextLine();
        Animal anim1 = new Animal(animalName3);
        System.out.println(myZoo.removeAnimal(anim1));
        System.out.println(myZoo.toString());
        //myZoo.displayZoo();
        myZoo.afficheAnimals();
    }
}

class Animal {
    String family;
    String name;
    int age;
    boolean isMammal;
    public Animal(String family, String name, int age, boolean isMammal) {
        this.family = family;
        this.name = name;
        this.age = age;
        this.isMammal = isMammal;
    }
    public Animal(String name) {
        this.family = "";
        this.name = name;
        this.age = 0;
        this.isMammal = false;
    }
    @Override
    public String toString() {
        return "Animal Name: " + name + ", Family: " + family + ", Age: " + age + ", Mammal: " + isMammal;
    }
}

class Zoo {
    Animal [] animals = new Animal[25];
    String name;
    String city;
    final int nbrCages;

    public Zoo(String name, String city, final int nbrCages) {
        this.name = name;
        this.city = city;
        this.nbrCages = nbrCages;
    }
    public void displayZoo() {
        System.out.println("Nom du zoo: " + this.name + "\n");
        System.out.println("Nom de la ville: " + this.city + "\n");
        System.out.println("Nombre des cages: " + this.nbrCages + "\n");
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
        if (j == -1) {
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
            if (this.animals[i] != null && this.animals[i].name.equals(animal.name)) {
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
        int nbAnimals = 0;
        for (int i = 0; i < this.animals.length; i++) {
            if (this.animals[i] != null) {
                nbAnimals++;
            }
        }
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
}