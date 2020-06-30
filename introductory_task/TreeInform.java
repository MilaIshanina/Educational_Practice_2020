public class TreeInform {
    private int err;
    private int ptr;
    private int t;

    public TreeInform(int err, int ptr, int t) {
        this.err = err;
        this.ptr = ptr;
        this.t = t;
    }

    public void IncreatePtr() {
        ptr++;
    }

    public int getErr() {
        return err;
    }

    public void setErr(int err) {
        this.err = err;
    }

    public int getPtr() {
        return ptr;
    }

    public void setPtr(int ptr) {
        this.ptr = ptr;
    }

    public int getT() {
        return t;
    }

    public void setT(int t) {
        this.t = t;
    }
}