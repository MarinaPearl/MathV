import java.util.Scanner;

public class Reader {
    private float epsilon;
    private  Integer delta;
    private float a;
    private float b;
    private float c;
    public Reader() {
        Scanner in = new Scanner(System.in);
        epsilon = in.nextFloat();
        delta = in.nextInt();
        a = in.nextFloat();
        b = in.nextFloat();
        c = in.nextFloat();
        in.close();
    }

    public float getEpsilon() {
        return epsilon;
    }

    public float getA() {
        return a;
    }

    public float getB() {
        return b;
    }

    public float getC() {
        return c;
    }

    public Integer getDelta() {
        return delta;
    }
}
