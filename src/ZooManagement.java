import java.util.Scanner;
public class ZooManagement {

    public static void main(String[] args) {
        int nbrCages, animalAge, nbAnimals,choix;
        boolean animalMammal;
        String zooName, animalFamily, animalName, city, animalName2, animalName3;


        System.out.print("Entrez les informations du zoo: \n");
        do {
            Scanner reader5 = new Scanner(System.in);
            System.out.print("Entrez le nom du zoo : \n");
            zooName = reader5.nextLine();
        }while (zooName.equals(""));
        Scanner reader6 = new Scanner(System.in);
        System.out.print("Entrez le nom de la ville : \n");
        city = reader6.nextLine();
        do {
            Scanner reader7 = new Scanner(System.in);
            System.out.print("Entrez le nombre de cages (entre 1 et 25) : \n");
            nbrCages = reader7.nextInt();
        }while (nbrCages <=0 || nbrCages > 25);
        Zoo myZoo = new Zoo(zooName,city,nbrCages);
        System.out.println(myZoo.toString());


        do {
            System.out.println("Welcome to the Zoo Management!");
            System.out.println("1. Ajouter un animal au zoo");
            System.out.println("2. Chercher un animal dans le zoo");
            System.out.println("3. Supprimer un animal du zoo");
            System.out.println("4. Afficher les animaux du zoo ");
            System.out.println("0. Quitter");
            do {
                Scanner sc = new Scanner(System.in);
                System.out.println("Entrez votre choix: ");
                choix = sc.nextInt();
            }while (choix < 0 || choix > 4);
            switch (choix) {
                case 1:
                    System.out.println("Entrez les informations de l'animal: ");
                    Scanner reader1 = new Scanner(System.in);
                    System.out.println("Entrez la famille de l'animal: ");
                    animalFamily = reader1.nextLine();
                    Scanner reader2 = new Scanner(System.in);
                    System.out.println("Entrez le nom de l'animal: ");
                    animalName = reader2.nextLine();
                    do {
                        Scanner reader3 = new Scanner(System.in);
                        System.out.println("Entrez l'age de l'animal: ");
                        animalAge = reader3.nextInt();
                    }while (animalAge <0);
                    Scanner reader4 = new Scanner(System.in);
                    System.out.println("Est ce que cet animal est mammal?(mammal: true, non mammal: false): ");
                    animalMammal = reader4.nextBoolean();
                    Animal animal = new Animal(animalFamily,animalName,animalAge,animalMammal);
                    System.out.println(myZoo.addAnimal(animal));

                    break;
                    case 2:
                        Scanner animName = new Scanner(System.in);
                        System.out.print("Entrez le nom de l'animal à chercher: \n");
                        animalName2 = animName.nextLine();
                        Animal anim = new Animal(animalName2);
                        System.out.println(myZoo.searchAnimal(anim));
                        break;
                    case 3:
                        Scanner animNams = new Scanner(System.in);
                        System.out.print("Entrez le nom de l'animal à supprimer: \n");
                        animalName3 = animNams.nextLine();
                        Animal anim1 = new Animal(animalName3);
                        System.out.println(myZoo.removeAnimal(anim1));
                        break;
                    case 4:
                        myZoo.displayZoo();

                        break;


            }
        }while(choix != 0);

    }


}

class Animal {
    private String family;
    private String name;
    private int age;
    private boolean isMammal;
    public String getFamily() {
        return this.family;
    }
    public void setFamily(String family) {
        this.family = family;
    }
    public String getName() {
        return this.name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getAge() {
        return this.age;
    }
    public void setAge(int age) {
        if (age < 0){
            System.out.println("l'age ne peut pas etre negatif.\n");
        }
        else {
            this.age = age;
        }

    }
    public boolean isMammal() {
        return this.isMammal;
    }
    public void setMammal(boolean isMammal) {
        this.isMammal = isMammal;
    }


    public Animal(String family, String name, int age, boolean isMammal) {
        this.setFamily(family) ;
        this.setName(name);
        this.setAge(age);
        this.setMammal(isMammal);
    }
    public Animal(String name) {
        this.family = "";
        this.setName(name);
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
    private String name;
    private String city;
    private int nbrCages;
    public String getName(){
        return this.name;
    }
    public void setName(String name){
        if("" == name){
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
}