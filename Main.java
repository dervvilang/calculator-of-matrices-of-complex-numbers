//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        //комплексные числа
        Complex complex1 = new Complex();
        complex1.setReal(1.5);
        complex1.setImag(4);
        Complex complex2 = new Complex(1, 2);
        complex2.setReal(complex1.getReal());
        complex1.printComplex();
        complex2.printComplex();


        Complex resAddC = Complex.add(complex1, complex2);
        System.out.print("Addition of complex1 and complex2: ");
        resAddC.printComplex();
        Complex resSubC = Complex.sub(complex1, complex2);
        System.out.print("Subtraction of complex1 and complex2: ");
        resSubC.printComplex();
        Complex resMulC = Complex.mul(complex1, complex2);
        System.out.print("Multiplication of complex1 and complex2: ");
        resMulC.printComplex();
        Complex resDivC = Complex.div(complex1, complex2);
        System.out.print("Division of complex1 and complex2: ");
        resDivC.printComplex();
        System.out.println();

        //матрицы
        ComplexMatrix matrix1 = new ComplexMatrix(3, 3);
        for (int i = 0; i < matrix1.getRow(); i++) {
            for (int j = 0; j < matrix1.getCol(); j++) {
                matrix1.setElement(i, j, complex1);
            }
        }
        Complex[][] arrayForMatr2 = {
                {new Complex(9, 8), new Complex(7, 6), new Complex(3, 2)},
                {new Complex(5, 4), new Complex(3, 2), new Complex(7, 6)},
                {new Complex(4, 3), new Complex(2, 1), new Complex(2, 5)},
        };
        ComplexMatrix matrix2 = new ComplexMatrix(arrayForMatr2);
        System.out.println("First matrix:");
        matrix1.printMatrix();
        System.out.println("Second matrix:");
        matrix2.printMatrix();
        ComplexMatrix matrix3 = ComplexMatrix.copyMatrix(matrix2);
        System.out.println("Third matrix:");
        matrix3.printMatrix();

        ComplexMatrix resAddM = ComplexMatrix.add(matrix1, matrix2);
        System.out.println("Addition of complex1 and complex2: ");
        resAddM.printMatrix();
        ComplexMatrix resSubM = ComplexMatrix.sub(matrix1, matrix2);
        System.out.println("Subtraction of complex1 and complex2: ");
        resSubM.printMatrix();
        ComplexMatrix resMulM = ComplexMatrix.mul(matrix1, matrix2);
        System.out.println("Multiplication of complex1 and complex2: ");
        resMulM.printMatrix();

    }
}