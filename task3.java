// К калькулятору из предыдущего дз добавить логирование.

// package task3;
import java.io.IOException;
import java.util.logging.*;
import java.util.Scanner;

public class task3 {
    static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args){
        try{
            Logger logger = Logger.getLogger(task3.class.getName());
            FileHandler fh = new FileHandler("log2.txt");
            logger.addHandler(fh);
            SimpleFormatter sFormat = new SimpleFormatter();
            fh.setFormatter(sFormat);
            logger.setUseParentHandlers(false);
            logger.log(Level.INFO, "Start");
        }
        catch(IOException ex){
            ex.printStackTrace();
        }
        while (true){
            int num1 = numEntry();
            int num2 = numEntry();
            char operat = entryOperat();
            int res = calc(num1, num2, operat);
            System.out.println("Результат: " + res);
        }
    }

    public static int numEntry(){
        System.out.println("Введите число: ");
        int num;
        if (scanner.hasNextInt()){
        num = scanner.nextInt();
        } 
        else {
        System.out.println("Ошибка при вводе числа. Попробуйте еще раз.");
        scanner.next();
        num = numEntry();
        }
    return num;
    }

    public static char entryOperat(){
        System.out.println("Введите операцию: ");
        char operat;
        if (scanner.hasNext()){
            operat = scanner.next().charAt(0);
        }
        else{
            System.out.println("Ошибка при вводе операции. Попробуйте еще раз.");
            scanner.next();
            operat = entryOperat();
        }
        return operat;
    }

    public static int calc(int num1, int num2, char operat){
        int res;
        switch (operat){
            case '+':
                res = num1 + num2;
                break;
            case '-':
                res = num1 - num2;
                break;
            case '*':
                res = num1 * num2;
                break;
            case '/':
                res = num1 / num2;
                break;
            default:
                System.out.println("Ошибка при вводе операции. Попробуйте еще раз.");
                res = calc(num1, num2, entryOperat());
        }
    return res;
    }
}
