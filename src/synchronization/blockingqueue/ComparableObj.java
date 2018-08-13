package synchronization.blockingqueue;


public class ComparableObj implements Comparable {

    private String msg;

    public ComparableObj(String msg) {
        this.msg = msg;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    @Override
    public int compareTo(Object o) {
        return msg.compareTo(o.toString());
    }
}
