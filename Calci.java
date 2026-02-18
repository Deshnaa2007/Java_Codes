import java.util.Scanner;

class Calculator {
    int add(int a, int b){
        return a + b;
    }

    int subtract(int a, int b){
        return a - b;
    }

    int multiply(int a, int b){
        return a * b;
    }

    float divide(int a, int b){
        float result = (float) a / b;
        return result;
    }
}

public class Calci {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Calculator calc = new Calculator();
        int choice;

        do {
            System.out.println("1.Add");
            System.out.println("2.Subtract");
            System.out.println("3.Multiply");
            System.out.println("4.Divide");
            System.out.println("5.Exit");
            choice = sc.nextInt();

            if (choice >= 1 && choice <= 4) {
                int a = sc.nextInt();
                int b = sc.nextInt();

                switch (choice) {
                    case 1:
                        System.out.println(calc.add(a, b));
                        break;
                    case 2:
                        System.out.println(calc.subtract(a, b));
                        break;
                    case 3:
                        System.out.println(calc.multiply(a, b));
                        break;
                    case 4:
                        System.out.println(calc.divide(a, b));
                        break;
                }
            }
        } while (choice != 5);

        sc.close();
    }
}
