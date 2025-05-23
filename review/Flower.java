public class Flower {
    int petalCount = 0;
    String s = "null";

    public Flower(int petals) {
        this.petalCount = petals;
    }


    public Flower(String ss) {
        this.s = ss;
    }

    public Flower(String s, int petals) {
        this(petals);   
        this.s = s;     
    }

    public Flower() {
        this("hello", 47);  
    }

    public void show() {
        System.out.println("s = " + s + ", petalCount = " + petalCount);
    }

    public static void main(String[] args) {
        Flower f1 = new Flower();
        f1.show();

        Flower f2 = new Flower("Rose", 99);
        f2.show();

        Flower f3 = new Flower("Lily");
        f3.show();

        Flower f4 = new Flower(7);
        f4.show();
    }
}
