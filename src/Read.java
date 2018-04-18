

import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.File;

public class Read extends Thread {
    private List list;
    private String path;

    public Read(String path) {
        list = new List();
    }

    public Read(List list, String path) {
        this.list = list;
        this.path = path;
    }

    @Override
    public void run() {
        readFile();
    }

    public void readFile() {
        try {
            File file = new File(path);

            if (file.exists()) {
                DataInputStream dis = new DataInputStream(new FileInputStream(file));
                int n = dis.available();

                for (int i = 0; i < n; i++) {
                    list.setByte(dis.readByte());
                }

                list.setCheck(true);

                dis.close();
            } else {
                System.out.println("File not found!");
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}