public class Fracao {
    private double numerator, denominator;

    public Fracao(double numerator, double denominator) {
        this.numerator = numerator;
        this.denominator = denominator;
    }

    public double getNumerator() {
        return numerator;
    }

    public void setNumerator(double numerator) {
        this.numerator = numerator;
    }

    public double getDenominator() {
        return denominator;
    }

    public void setDenominator(double denominator) {
        this.denominator = denominator;
    }

    public Fracao add(Fracao f1, Fracao f2) {
        if (f1.denominator == f2.denominator) {
            return new Fracao((f1.numerator + f2.numerator), f1.denominator);
        }
        double newDenominator = f1.denominator * f2.denominator;
        double newNumerator = (f1.numerator * (newDenominator / f1.denominator)) + (f2.numerator * (newDenominator / f2.denominator));
        return new Fracao(newNumerator, newDenominator);
    }

    public Fracao subract(Fracao f1, Fracao f2) {
        if (f1.denominator == f2.denominator) {
            return new Fracao((f1.numerator - f2.numerator), f1.denominator);
        }
        double newDenominator = f1.denominator * f2.denominator;
        double newNumerator = (f1.numerator * (newDenominator / f1.denominator)) + (f2.numerator * (newDenominator / f2.denominator));
        return new Fracao(newNumerator, newDenominator);
    }

    public Fracao multiply(Fracao f1, Fracao f2) {

        double newDenominator = f1.denominator * f2.denominator;
        double newNumerator = f1.numerator * f2.numerator;
        return new Fracao(newNumerator, newDenominator);
    }

    public Fracao division(Fracao f1, Fracao f2) {

        double newDenominator = f1.numerator * f2.denominator;
        double newNumerator = f1.denominator * f2.numerator;
        return new Fracao(newNumerator, newDenominator);
    }

    public Fracao add(Fracao f1, int i2) {
        double newDenominator = f1.denominator;
        double newNumerator = (f1.numerator * (newDenominator / f1.denominator)) + (i2 * (newDenominator / 1));
        return new Fracao(newNumerator, newDenominator);
    }

    public Fracao subract(Fracao f1, int i2) {
        double newDenominator = f1.denominator;
        double newNumerator = (f1.numerator * (newDenominator / f1.denominator)) - (i2 * (newDenominator / 1));
        return new Fracao(newNumerator, newDenominator);
    }

    public Fracao multiply(Fracao f1, int i2) {

        double newDenominator = f1.denominator * 1;
        double newNumerator = f1.numerator * i2;
        return new Fracao(newNumerator, newDenominator);
    }

    public Fracao division(Fracao f1, int i2) {

        double newDenominator = f1.numerator * 1;
        double newNumerator = f1.denominator * i2;
        return new Fracao(newNumerator, newDenominator);
    }
}
