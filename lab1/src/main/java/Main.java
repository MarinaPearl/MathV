public class Main {
    public static void main(String[] args) {
            Reader reader = new Reader();
            Calculator calculator = new Calculator(
                    reader.getEpsilon(), reader.getDelta(), reader.getA(),
                    reader.getB(), reader.getC());
    }
}