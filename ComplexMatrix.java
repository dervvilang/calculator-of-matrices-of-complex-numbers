import java.util.Random;

public class ComplexMatrix {

    private int row;
    private int col;
    private Complex[][] matrix;

    //конструктор 1 для задания матрицы с значениями 0
    public ComplexMatrix(int row, int col) {
        if (row <= 0 || col <= 0) {
            throw new IllegalArgumentException("Matrix dimensions must be positive.");
        }
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
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            throw new IllegalArgumentException("Matrix cannot be null or empty.");
        }
        this.row = matrix.length;
        this.col = matrix[0].length;
        this.matrix = new Complex[row][col];
        for (int i = 0; i < row; i++) {
            if (matrix[i].length != col) {
                throw new IllegalArgumentException("All rows must have the same number of columns.");
            }
            for (int j = 0; j < col; j++) {
                this.matrix[i][j] = new Complex(matrix[i][j].getReal(), matrix[i][j].getImag());
            }
        }
    }

    //сеттер элемента по строке и столбцу на значение копмл.числа
    public void setElement(int row, int col, Complex a) {
        if (row < 0 || row >= this.row || col < 0 || col >= this.col) {
            throw new IndexOutOfBoundsException("Invalid indices for matrix.");
        }
        this.matrix[row][col] = a;
    }

    //геттер элемента матрицы по строке и столбцу
    public Complex getElement(int row, int col) {
        if (row < 0 || row >= this.row || col < 0 || col >= this.col) {
            throw new IndexOutOfBoundsException("Invalid indices for matrix.");
        }
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
    public ComplexMatrix add(ComplexMatrix a) {
        ComplexMatrix result = new ComplexMatrix(this.row, this.col);
        if (this.row != a.row || this.col != a.col) {
            throw new IllegalArgumentException("The matrices must have the same size.");
        }
        else {
            for (int i = 0; i < this.row; i++) {
                for (int j = 0; j < this.col; j++) {
                    Complex sum = this.getElement(i, j).add(a.getElement(i, j));
                    result.setElement(i, j, sum);
                }
            }
        }
        return result;
    }

    //вычитание матриц
    public ComplexMatrix sub(ComplexMatrix a) {
        ComplexMatrix result = new ComplexMatrix(this.row, this.col);
        if (this.row != a.row || this.col != a.col) {
            throw new IllegalArgumentException("The matrices must have the same size.");
        }
        else {
            for (int i = 0; i < this.row; i++) {
                for (int j = 0; j < this.col; j++) {
                    Complex subt = this.getElement(i, j).sub(a.getElement(i, j));
                    result.setElement(i, j, subt);
                }
            }
            return result;
        }
    }

    //умножение матрицы на матрицу
    public ComplexMatrix mul(ComplexMatrix a) {
        ComplexMatrix result = new ComplexMatrix(this.row, this.col);
        if (this.col != a.row) {
            throw new IllegalArgumentException("The number of columns of the first matrix should be equal to the number of rows of the second matrix.");
        }
        else {
            for (int i = 0; i < this.row; i++) {
                for (int j = 0; j < a.col; j++) {
                    Complex sum = new Complex();
                    for (int k = 0; k < this.col; k++) {
                        Complex mult = this.getElement(i, k).mul(a.getElement(k, j));
                        sum = sum.add(mult);
                        result.setElement(i, j, sum);
                    }
                }
            }
            return result;
        }
    }

    //рандомайзер значений для матрицы
    public void Random(double numder) {
        Random rand = new Random();
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                matrix[i][j] = new Complex(rand.nextDouble(numder), rand.nextDouble(numder));
            }
        }
    }
    //рандомайзер интов для матрицы если надо как "int" с ,00
    public void RandomInt(int numder) {
        Random rand = new Random();
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                matrix[i][j] = new Complex(rand.nextInt(numder), rand.nextInt(numder));
            }
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

    //вычислям дополнение
    private Complex getAddit(int a, int b) {
        ComplexMatrix minor = new ComplexMatrix(row - 1, col - 1);
        int minorRow = 0;
        int minorCol = 0;

        for (int i = 0; i < row; i++) {
            if (i == a) continue;
            for (int j = 0; j < col; j++) {
                if (j == b) continue;
                minor.matrix[minorRow][minorCol] = matrix[i][j];
                minorCol++;
            }
            minorRow++;
            minorCol = 0;
        }
        return (a + b) % 2 == 0 ? minor.getDeterminant() : minor.getDeterminant().mul(new Complex(-1, 0));
    }
    //детерминант
    public Complex getDeterminant() {
        if (row != col) {
            throw new IllegalArgumentException("The matrix must have the same size.");
        }

        if (row == 1) {
            return matrix[0][0];
        }

        Complex determinant = new Complex();
        for (int i = 0; i < row; i++) {
            determinant = determinant.add(getAddit(i, 0).mul(matrix[i][0]));
        }
        return determinant;
    }

    //вывод матрицы фулл
    public void printMatrix() {
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                Complex element = matrix[i][j];
                String formattedElement;

                if (element.getImag() >= 0) {
                    formattedElement = String.format("%.2f + %.2fi", element.getReal(), element.getImag());
                } else {
                    formattedElement = String.format("%.2f - %.2fi", element.getReal(), -element.getImag());
                }

                System.out.printf("%20s", formattedElement);
            }
            System.out.println();
        }
    }
}
