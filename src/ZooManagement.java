import java.util.Scanner;

public class ZooManagement {


    public static void main(String[] args) {
        int nbrCages;
        String zooName;
        Scanner reader = new Scanner(System.in);
        System.out.print("Entrez le nom du zoo\n");
        zooName = reader.nextLine();
        Scanner reader1 = new Scanner(System.in);
        System.out.print("Entrez le nombre de cages du zoo\n");
        nbrCages = reader1.nextInt();

        System.out.println(zooName+ " comporte " + nbrCages + " cages.");
        System.out.println();
    }
}
