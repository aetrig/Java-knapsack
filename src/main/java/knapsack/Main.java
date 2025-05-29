package knapsack;

public class Main {
    public static void main(String[] args) {
        Problem p = new Problem(10, 1, 1, 10);
        System.out.println(p);
        System.out.println(p.solve(15));
    }
}