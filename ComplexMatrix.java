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
    public ComplexMatrix add(ComplexMatrix a) {
        ComplexMatrix result = new ComplexMatrix(this.row, this.col);
        if (this.row != a.row || this.col != a.col) {
            System.out.println("The matrices must have the same size.");
            return null;
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
            System.out.println("The matrices must have the same size.");
            return null;
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
            System.out.println("The number of columns of the first matrix should be equal to the number of rows of the second matrix.");
            return null;
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
}
