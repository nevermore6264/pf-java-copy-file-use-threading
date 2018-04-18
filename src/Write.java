import java.io.DataOutputStream;
import java.io.FileOutputStream;

public class Write extends Thread {
    private List list;
    private String path;

    public Write(String path) {
        this(new List(), path);
    }

    public Write(List list, String path) {
        this.list = list;
        this.path = path;
    }

    @Override
    public void run() {
        writeFile();
    }

    public void writeFile() {
        try {
            DataOutputStream dos = new DataOutputStream(new FileOutputStream(path));

            while (!list.getCheck()) {
                dos.writeByte(list.getByte());
            }

            dos.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}