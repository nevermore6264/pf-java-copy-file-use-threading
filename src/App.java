import java.util.Scanner;

public class App {
    public static String changePath(String pathStart) {
        return pathStart.substring(0, pathStart.lastIndexOf("\\") + 1);
    }

    public static String changePath(String path, String pathStart, String pathEnd) {
        return path.replace(pathStart, pathEnd);
    }

    public static void copy(String pathStart, String pathEnd) {
        List list = new List();
        Read read = new Read(list, pathStart);
        Write write = new Write(list, changePath(pathStart, changePath(pathStart), pathEnd));

        read.start();
        write.start();
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String pathStart = "";
        String pathEnd = "";

        System.out.print("Enter URL file: ");
        pathStart = input.nextLine();

        System.out.print("Enter URL file to copy: ");
        pathEnd = input.nextLine();

        copy(pathStart, pathEnd);
    }
}
