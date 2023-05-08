/* Реалезуйте алгоритм сортировки пузырьком числового 
массива, результат после каждой итерации запишите в лог-файл. */

import java.util.Arrays;
import java.util.logging.*;

public class task2 {
    static Logger logger = Logger.getLogger(task2.class.getName());
    public static void main(String[] args) throws Exception{
        FileHandler fh = new FileHandler("log.txt");
        logger.addHandler(fh);
        SimpleFormatter sFormat = new SimpleFormatter();
        fh.setFormatter(sFormat);
        logger.setUseParentHandlers(false);
        logger.log(Level.INFO, "Начало");
        int [] mas = {-1,11, 3, 14, 16, 7};
        boolean isSorted = false;
        int buf;
        while(!isSorted) {
            isSorted = true;
            for (int i = 0; i < mas.length-1; i++) {
                if(mas[i] > mas[i+1]){
                    isSorted = false;
 
                    buf = mas[i];
                    mas[i] = mas[i+1];
                    mas[i+1] = buf;
                            }
                        }
                    }
    System.out.println(Arrays.toString(mas));
    // logger.log("processing car:");
    }
} 
