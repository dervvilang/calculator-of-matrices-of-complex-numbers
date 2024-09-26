public class ComplexMatrix {

    private int row;
    private int col;
    private Complex[][] matrix;

    //конструктор 1 для задания матрицы с значениями 0
    public ComplexMatrix(int row, int col) {
        this.row = row;
        this.col = col;
        matrix = new Complex[row][col];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                matrix[i][j] = new Complex(0, 0);
            }
        }
    }

    //конструктор 2 для задания матрицы на базе двумерного компл.массива
    public ComplexMatrix(Complex[][] matrix) {
        this.row = matrix.length;
        this.col = matrix[0].length;
        this.matrix = new Complex[row][col];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                this.matrix[i][j] = new Complex(matrix[i][j].getReal(), matrix[i][j].getImag());
            }
        }
    }

    //сеттер элемента по строке и столбцу на значение копмл.числа
    public void setElement(int row, int col, Complex a) {
        this.matrix[row][col] = a;
    }

    //геттер элемента матрицы по строке и столбцу
    public Complex getElement(int row, int col) {
        return this.matrix[row][col];
    }

    //геттер колва строк
    public int getRow() {
        return row;
    }
    //геттер колва стоблцов
    public int getCol() {
        return col;
    }

    //сложение матриц
    public static ComplexMatrix add(ComplexMatrix a, ComplexMatrix b) {
        ComplexMatrix result = new ComplexMatrix(a.row, a.col);
        if (a.row != b.row || a.col != b.col) {
            System.out.println("The matrices must have the same size.");
            return null;
        }
        else {
            for (int i = 0; i < a.row; i++) {
                for (int j = 0; j < a.col; j++) {
                    Complex sum = Complex.add(a.getElement(i, j), b.getElement(i, j));
                    result.setElement(i, j, sum);
                }
            }
        }
        return result;
    }

    //вычитание матриц
    public static ComplexMatrix sub(ComplexMatrix a, ComplexMatrix b) {
        ComplexMatrix result = new ComplexMatrix(a.row, a.col);
        if (a.row != b.row || a.col != b.col) {
            System.out.println("The matrices must have the same size.");
            return null;
        }
        else {
            for (int i = 0; i < a.row; i++) {
                for (int j = 0; j < a.col; j++) {
                    Complex subt = Complex.sub(a.getElement(i, j), b.getElement(i, j));
                    result.setElement(i, j, subt);
                }
            }
            return result;
        }
    }

    //умножение матрицы на матрицу
    public static ComplexMatrix mul(ComplexMatrix a, ComplexMatrix b) {
        ComplexMatrix result = new ComplexMatrix(a.row, a.col);
        if (a.col != b.row) {
            System.out.println("The number of columns of the first matrix should be equal to the number of rows of the second matrix.");
            return null;
        }
        else {
            for (int i = 0; i < a.row; i++) {
                for (int j = 0; j < b.col; j++) {
                    Complex sum = new Complex();
                    for (int k = 0; k < a.col; k++) {
                        Complex mult = Complex.mul(a.getElement(i, k), b.getElement(k, j));
                        sum = Complex.add(sum, mult);
                        result.setElement(i, j, sum);
                    }
                }
            }
            return result;
        }
    }

    //копирование матрицы
    public static ComplexMatrix copyMatrix(ComplexMatrix matrix) {
        ComplexMatrix newMatrix = new ComplexMatrix(matrix.row, matrix.col);
        for (int i = 0; i < matrix.row; i++) {
            for (int j = 0; j < matrix.col; j++) {
                newMatrix.setElement(i, j, matrix.getElement(i, j));
            }
        }
        return newMatrix;
    }

    //вывод матрицы фулл
    public void printMatrix() {
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (matrix[i][j].getImag() >= 0) {
                    System.out.printf("%.2f + %.2fi  ", matrix[i][j].getReal(), matrix[i][j].getImag());
                }
                else {
                    System.out.printf("%.2f - %.2fi  ", matrix[i][j].getReal(), -matrix[i][j].getImag());
                }
            }
            System.out.println();
        }
    }



    //с детерминантом что-то не то, даже через гпт решила попробовать, но не фигня:(
    /*private static void swapRows(ComplexMatrix matrix, int row1, int row2) {
        Complex[] temp = matrix.matrix[row1];
        matrix.matrix[row1] = matrix.matrix[row2];
        matrix.matrix[row2] = temp;
    }
    //детерминант матрицы
    public static double determinant(ComplexMatrix matrix) {
        if (matrix.row != matrix.col) {
            throw new IllegalArgumentException("The determinant can only be calculated for square matrices.");
        }

        double det = 1.0;
        ComplexMatrix tempMatrix = copyMatrix(matrix);

        for (int i = 0; i < tempMatrix.row; i++) {
            if (tempMatrix.getElement(i, i).getReal() == 0) {
                boolean swapped = false;
                for (int j = i + 1; j < tempMatrix.row; j++) {
                    if (tempMatrix.getElement(j, i).getReal() != 0) {
                        swapRows(tempMatrix, i, j);
                        det = -det;
                        swapped = true;
                        break;
                    }
                }
                if (!swapped) return 0;
            }
            det *= tempMatrix.getElement(i, i).getReal();
            for (int j = i + 1; j < tempMatrix.row; j++) {
                Complex ratio = new Complex(tempMatrix.getElement(j, i).getReal() / tempMatrix.getElement(i, i).getReal(), 0);
                for (int k = i; k < tempMatrix.col; k++) {
                    Complex updatedValue = Complex.sub(tempMatrix.getElement(j, k), Complex.mul(ratio, tempMatrix.getElement(i, k)));
                    tempMatrix.setElement(j, k, updatedValue);
                }
            }
        }
        return det;
    }*/
}
