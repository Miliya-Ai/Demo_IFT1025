package v1;

public class Main {
    public static void main(String[] args) {
        Villageois jean = new Villageois("Jean", "Til", 38);
        System.out.println(jean.getAge());
        jean.vieillir(10);
        System.out.println(jean.getAge());
    }
}
