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


        Complex resAddC = complex1.add(complex2);
        System.out.print("Addition of complex1 and complex2: ");
        resAddC.printComplex();
        Complex resSubC = complex1.sub(complex2);
        System.out.print("Subtraction of complex1 and complex2: ");
        resSubC.printComplex();
        Complex resMulC = complex1.mul(complex2);
        System.out.print("Multiplication of complex1 and complex2: ");
        resMulC.printComplex();
        Complex resDivC = complex1.div(complex2);
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

        ComplexMatrix resAddM = matrix1.add(matrix2);
        System.out.println("Addition of matrix1 and matrix2: ");
        resAddM.printMatrix();
        ComplexMatrix resSubM = matrix1.sub(matrix2);
        System.out.println("Subtraction of matrix1 and matrix2: ");
        resSubM.printMatrix();
        ComplexMatrix resMulM = matrix1.mul(matrix2);
        System.out.println("Multiplication of matrix1 and matrix2: ");
        resMulM.printMatrix();

    }
}
