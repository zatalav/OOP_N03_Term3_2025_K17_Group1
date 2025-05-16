public class Flower {
    int petalCount = 0;
    String s = new String("null");

    // Constructor 1: chỉ petalCount
    Flower(int petals) {
        petalCount = petals;
    }

    // Constructor 2: chỉ s
    Flower(String ss) {
        s = ss;
    }

    // Constructor 3: cả s và petalCount
    Flower(String s, int petals) {
        this(s);
        this.petalCount = petals;
        // hoặc: this.s = s;
        // không thể gọi this() nhiều lần trong cùng constructor
    }

    // Constructor mặc định không có tham số
    Flower() {
        this("hello", 47);
    }
}