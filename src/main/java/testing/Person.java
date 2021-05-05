package testing;

public class Person {
    private int sum;

    public Person(int sum) {
        this.sum = sum;
    }


    public int getSum() {
        return sum;
    }

    public void setSum(int sum) {
        this.sum = sum;
    }

    public String increaseSum(int argn) {
        sum = sum + 1;
        return "sum increasted";
    }
}
