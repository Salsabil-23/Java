import java.io.Serializable;

public class Employe implements Comparable<Employe>{
    private int id;
    private String nom;
    private String prenom;
    private String departement;
    private int grade;
    //constructeurs
    public Employe() {}
    public Employe(int id, String nom, String prenom, String departement, int grade) {
        this.id = id;
        this.nom = nom;
        this.prenom = prenom;
        this.departement = departement;
        this.grade = grade;
    }
    //Getters
    public int getId() {
        return this.id;
    }
    public String getNom() {
        return this.nom;
    }
    public String getPrenom() {
        return this.prenom;
    }
    public String getDepartement() {
        return this.departement;
    }
    public int getGrade() {
        return this.grade;
    }
    //Setters
    public void setId(int id) {
        this.id = id;
    }
    public void setNom(String nom) {
        this.nom = nom;
    }
    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }
    public void setDepartement(String departement) {
        this.departement = departement;
    }
    public void setGrade(int grade) {
        this.grade = grade;
    }
    @Override
    public boolean equals(Object o) {
        if (null == o) return false;
        if (o instanceof Employe e) {
            return this.id == e.id && this.nom.equals(e.nom);
        }
        return false;
    }
    @Override
    public String toString() {
        return "ID: "+this.id+", "+"Nom: "+this.nom+", "+"Prenom: "+this.prenom+", "+"Departement: "+this.departement+", "+"Grade: "+this.grade;
    }
    public int compareTo(Employe e) {
        return this.id - e.id;
    }
}
