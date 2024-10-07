import java.util.Scanner;

public class ZooManagement {


    public static void main(String[] args) {
        int nbrCages , age;
        String zooName , animalName , city , family;
        boolean isMammal;
       /* Scanner reader = new Scanner(System.in);
        System.out.print("Entrez le nom du zoo\n");
        zooName = reader.nextLine();
        Scanner reader1 = new Scanner(System.in);
        System.out.print("Entrez le nombre de cages du zoo\n");
        nbrCages = reader1.nextInt();

        System.out.println(zooName+ " comporte " + nbrCages + " cages.");
        System.out.println();*/

        Scanner reader = new Scanner(System.in);
        System.out.println("donner la family du lion\n");
        family = reader.nextLine();
        Scanner reader1 = new Scanner(System.in);
        System.out.println("donner le nom du lion\n");
        animalName = reader1.nextLine();
        Scanner reader2 = new Scanner(System.in);
        System.out.println("donner l'age du lion\n");
        age = reader2.nextInt();
        Scanner reader3 = new Scanner(System.in);
        System.out.println("Est ce que le lion est Mammal ou non?\n");
        isMammal = reader3.nextBoolean();
        Animal lion = new Animal(family, animalName, age, isMammal);


        Scanner reader4 = new Scanner(System.in);
        System.out.println("donner le nom du zoo\n");
        zooName = reader4.nextLine();
        Scanner reader5 = new Scanner(System.in);
        System.out.println("donner la ville du zoo\n");
        city = reader5.nextLine();
        Scanner reader6 = new Scanner(System.in);
        System.out.println("donner le nombre de cages du zoo\n");
        nbrCages = reader6.nextInt();
        Zoo myZoo = new Zoo(zooName,city,nbrCages);

        //myZoo.displayZoo();
        System.out.println(myZoo);
        System.out.println(myZoo.toString());
    }



}
class Animal {
    String family;
    String name;
    int age;
    boolean isMammal;
    Animal(String family, String name, int age, boolean isMammal) {
        this.family = family;
        this.name = name;
        this.age = age;
        this.isMammal = isMammal;

    }

}
class Zoo {
    Animal [] animals;
    String name;
    String city;
    int nbrCages;
    Zoo(String name , String city, int nbrCages) {

        animals = new Animal[nbrCages];
        this.name = name;
        this.city = city;
        this.nbrCages = nbrCages;
    }
    void displayZoo(){
        System.out.println("Name:"+ name +"\nCity:" + city +"\nNombre de cages:" + nbrCages);
    }
    @Override
    public String toString() {
        return "Zoo Name: " + name + ", City: " + city + ", Number of Cages: " + nbrCages;
    }

}
