import java.io.*;//импорт пакета, содержащего классы для
// ввода/вывода
import java.net.*;//импорт пакета, содержащего классы для
import java.util.Scanner;

// работы в сети
// разбираемся с гит
public class client {
    private static int[][] matrix = new int[3][3];
    private static void SetArray()
    {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter elements of new array:");
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print("Element [" + i + "][" + j + "]: ");
                matrix[i][j] = scanner.nextInt();
            }
        }
        // Выводим массив на экран
        System.out.println("Array:");
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println(); // Переход на новую строку после каждой строки матрицы
        }
        scanner.close();
    }
    private static void hi(){
        System.out.println("HI");
    }

    public static void main(String[] arg) {
        try {
            System.out.println("server connecting....");
            Socket clientSocket = new Socket("127.0.0.1",2525);//установление //соединения между локальной машиной и указанным портом узла сети
            System.out.println("connection established....");
            BufferedReader stdin = new BufferedReader(new InputStreamReader(System.in));//создание//буферизированного символьного потока ввода
            ObjectOutputStream coos = new ObjectOutputStream(clientSocket.getOutputStream());//создание//потока вывода
            ObjectInputStream  cois = new ObjectInputStream(clientSocket.getInputStream());//создание//потока ввода
            //System.out.println("Enter any string to send to server \n\t('quite' − programme terminate)");
            //String clientMessage = stdin.readLine();
           // System.out.println("you've entered: "+clientMessage);
           // while(!clientMessage.equals("quite")) {//выполнение цикла, пока строка //не будет равна «quite»
                SetArray();
                for (int i = 0; i < 3; i++)
                {
                    for (int j = 0; j < 3; j++)
                    {
                        coos.writeObject(Integer.toString(matrix[i][j]));
                    }
                }
              //  coos.writeObject(clientMessage);//потоку вывода присваивается //значение строковой переменной (передается серверу)
             //   System.out.println("~server~: "+cois.readObject());//выводится на //экран со-держимое потока ввода (переданное сервером)
             //   System.out.println("---------------------------");
            //    clientMessage = stdin.readLine();//ввод текста с клавиатуры
          //      System.out.println("you've entered: "+clientMessage);//вывод в
//консоль строки и значения строковой переменной
           // }
            coos.close();//закрытие потока вывода
            cois.close();//закрытие потока ввода
            clientSocket.close();//закрытие сокета
        }catch(Exception e)	{
            e.printStackTrace();//выполнение метода исключения е
        }
    }
}

