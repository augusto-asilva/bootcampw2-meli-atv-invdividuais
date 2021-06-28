public class Counter {
    private int counter;

    public Counter() {
    }

    public Counter(int counter) {
        this.counter = counter;
    }

    public Counter(Counter counter) {
        this.counter = counter.counter;
    }

    public int getCounter() {
        return counter;
    }

    public void setCounter(int counter) {
        this.counter = counter;
    }

    public void increment(int toIncriment) {
        counter += toIncriment;
    }

    public void decremente(int toDecrement) {
        counter -= toDecrement;
    }

    public void incrementByOne() {
        counter += 1;
    }

    public void decrementeByOne() {
        counter -= 1;
    }
}
