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

    //слодение
    public static Complex add(Complex a, Complex b) {
        return new Complex(a.real + b.real, a.imag + b.imag);
    }
    //вычитание
    public static Complex sub(Complex a, Complex b) {
        return new Complex(a.real - b.real, a.imag - b.imag);
    }
    //умножение
    public static Complex mul(Complex a, Complex b) {
        return new Complex(a.real * b.real - a.imag * b.imag, a.real * b.imag + a.imag * b.real);
    }
    //деление
    public static Complex div(Complex a, Complex b) {
        double root = b.real * b.real + b.imag * b.imag;

        if (root == 0) {
            System.out.println("It cannot be divided by zero.");
            return null;
        }
        else {
            return new Complex((a.real * b.real + a.imag * b.imag) / root, (a.imag * b.real - a.real * b.imag) / root);
        }
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
