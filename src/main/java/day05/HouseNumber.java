package day05;

public class HouseNumber {

    private int odd;
    private int even;

    public HouseNumber() {
        this.odd = -1;
        this.even = 0;
    }

    public int getOdd() {
        odd += 2;
        return odd;
    }

    public int getEven() {
        even +=2;
        return even;
    }
}
