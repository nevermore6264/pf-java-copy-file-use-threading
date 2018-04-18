import java.util.LinkedList;
import java.util.Queue;

public class List {
    private Queue list;
    private boolean check;

    public List() {
        this(new LinkedList<String>());
    }

    public List(LinkedList<String> list) {
        this.list = list;
        this.check = false;
    }

    public boolean getCheck() {
        return list.isEmpty() && check;
    }

    public void setCheck(boolean check) {
        this.check = check;
    }

    public synchronized byte getByte() {
        try {
            while (list.isEmpty()) {
                wait();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return Byte.parseByte(list.poll().toString());
    }

    public synchronized void setByte(byte b) {
        this.list.offer(String.valueOf(b));

        notify();
    }
}