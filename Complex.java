public class Complex {

    private double real;
    private double imag;

    //конструктор 1 с записью значений
    public Complex(double real, double imag) {
        this.real = real;
        this.imag = imag;
    }

    //конструктор 2 с базой в виде 0 + 0i
    public Complex() {
        this.real = 0.0;
        this.imag = 0.0;
    }

    //сеттер для реал
    public void setReal(double real) {
        this.real = real;
    }
    //сеттер для имаг
    public void setImag(double imag) {
        this.imag = imag;
    }

    //геттер для реал
    public double getReal() {
        return real;
    }
    //геттер для имаг
    public double getImag() {
        return imag;
    }

    //сложение
    public Complex add(Complex a) {
        return new Complex(this.real + a.real, this.imag + a.imag);
    }

    //вычитание
    public Complex sub(Complex a) {
        return new Complex(this.real - a.real, this.imag - a.imag);
    }

    //умножение
    public Complex mul(Complex a) {
        return new Complex(this.real * a.real - this.imag * a.imag, this.real * a.imag + this.imag * a.real);
    }

    //деление
    public Complex div(Complex a) {
        double root = a.real * a.real + a.imag * a.imag;

        if (root == 0.0) {
            System.out.println("It cannot be divided by zero.");
            return null;
        }
        else return new Complex((this.real * a.real + this.imag * a.imag) / root, (this.imag * a.real - this.real * a.imag) / root);
    }

    //вывод компл.числа
    public void printComplex() {
        if (imag >= 0) {
            System.out.printf("%.2f + %.2fi\n", real, imag);
        }
        else {
            System.out.printf("%.2f - %.2fi\n", real, -imag);
        }
    }
}
