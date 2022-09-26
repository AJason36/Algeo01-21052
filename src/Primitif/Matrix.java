package Primitif;
import java.util.Scanner;

/**
13521052 Melvin Kent
13521064 Bill Clinton
13521100 Alexander Jason
 */

public class Matrix {
    int rows;
    int cols;
    double[][] matrix;
    final double MARK = Double.NaN;
    Scanner scanElmt = new Scanner(System.in);

// ********************* Matrix Constructor ************************
    public Matrix(int row, int col) {
        this.rows = row;
        this.cols = col;
        this.matrix = new double[row][col];
    }

    // Read Matrix
    public void readMatrix(int row, int col) {
        double elmt;
        int i, j;

        Scanner scanElmt = new Scanner(System.in);
        this.rows = row;
        this.cols = col;
        for (i = 0; i < row; i++) {
            for (j = 0; j < col; j++) {
                System.out.print("Masukkan nilai pada baris ke-" + (i + 1) + " dan kolom ke-" + (j + 1) + ": ");
                elmt = scanElmt.nextDouble();
                this.matrix[i][j] = elmt;
            }
        }
    }
    
    public Matrix copyMatrix(){
        Matrix mOut= new Matrix(this.rows,this.cols);
        int i, j;
        mOut.rows = this.rows;
        mOut.cols = this.cols;
        for (i = 0; i < this.rows; i++) {
            for (j = 0; j < this.cols; j++) {
                mOut.matrix[i][j] = this.matrix[i][j];
            }
        }
        return mOut;
    }
    // Display Matrix
    public void displayMatrix() {
        int i, j;
        for (i = 0; i < this.rows; i++) {
            for (j = 0; j < this.cols; j++) {
                if (j < (this.cols - 1)) {
                    System.out.print(this.matrix[i][j] + " ");
                } else {
                    System.out.print(this.matrix[i][j]);
                }
            }
            System.out.println();
        }
    }
    
// ********************* SELEKTOR ********************* 
    //ngubah jd public
    public int getCol() {
        return this.cols;
    }

    public int getRow() {
        return this.rows;
    }
    public double getElmt(int i, int j) {
        return this.matrix[i][j];
    }

    public void setElmt(int i, int j, double val) {
        this.matrix[i][j] = val;
    }

    public void getCol(int i) {
        int j;
        for (j = 0; j < this.cols; j++) {
            if (j < (this.cols-1)) {
                System.out.print(getElmt(i, j) + " ");
            } else {
                System.out.print(getElmt(i, j));
            }
            
        }
        System.out.println();
    }
    
    public void getRow(int j) {
        int i;
        for (i = 0; i < this.rows; i++) {
            System.out.println(getElmt(i, j));
        }
    }

    // *********************** Identitas *************************
    // cek apakah dari matrix ada baris yang 0
    public boolean isRowZero() {
        int i, j;
        boolean row_val, val;
        i = 0;
        j = 0;
        row_val = true;
        val = false;
        for (i = 0; i < this.rows; i++) {
            for (j = 0; j < this.cols; j++) {
                if (getElmt(i, j) != 0) {
                    row_val = false;
                }
            }
            if (row_val) {
                val = true;
            }
            row_val = true;
        }
        return val;
    }

    //cek apakah dari matriks ada kolom yang 0
    public boolean isColZero() {
        int i, j;
        boolean col_val, val;
        i = 0;
        j = 0;
        col_val = true;
        val = false;
        for (j = 0; j < this.cols; j++) {
            for (i = 0; i < this.rows; i++) {
                if (getElmt(i, j) != 0) {
                    col_val = false;
                }
            }
            if (col_val) {
                val = true;
            }
            col_val = true;
        }
        return val;
    }

    public boolean isSquare() {
        return this.rows == this.cols;
    }

    public boolean isIdentity() {
        int i, j;
        for (i = 0; i < this.rows; i++) {
            for (j = 0; j < this.rows; j++) {
                if (i == j) {
                    if (this.matrix[i][j] != 1) {
                        return false;
                    }
                } else {
                    if (this.matrix[i][j] != 0) {
                        return false;
                    }
                }
            }
        }
        return true;
    }
    
// ********************** PRIMITIF LAIN LAIN *********************
    public void swapRow(int i1, int i2) { // Swap baris index i1 dan i2
        int j;
        double temp;
        for (j = 0; j < this.cols; j++) {
            temp = this.matrix[i1][j];
            this.matrix[i1][j] = this.matrix[i2][j];
            this.matrix[i2][j] = temp;
        }
    }

    public void swapCol(int j1, int j2) { // Swap kolom index j1 dan j2
        int i;
        double temp;
        for (i = 0; i < this.rows; i++) {
            temp =this.matrix[i][j1];
            this.matrix[i][j1] = this.matrix[i][j2];
            this.matrix[i][j2] = temp;
        }
    }

    public Matrix plusminusMatrix(Matrix m1, Matrix m2, boolean value) {
        int i, j;
        Matrix mOut = new Matrix(m1.rows, m1.cols);
        if (value) {
            for (i = 0; i < mOut.rows; i++) {
                for(j = 0; j < mOut.cols; j++) {
                    mOut.matrix[i][j] = m1.matrix[i][j] + m2.matrix[i][j];
                }
            }
        } else {
            for (i = 0; i < mOut.rows; i++) {
                for(j = 0; j < mOut.cols; j++) {
                    mOut.matrix[i][j] = m1.matrix[i][j] - m2.matrix[i][j];
                }
            }
        }
        return mOut;
    }

    public Matrix multiplyMatrix(Matrix m1, Matrix m2) {
        Matrix mOut = new Matrix(m1.rows, m2.cols);
        if (m1.cols == m2.rows) {
            int i, j, k;
            double result;
            for (i = 0; i < m1.rows; i++) {
                for (j = 0; j < m2.cols; j++) {
                    result = 0;
                    for (k = 0; k < m1.cols; k++) {
                        result += m1.matrix[i][k] * m2.matrix[k][j];
                    }
                    mOut.matrix[i][j] = result;
                }
            }
        }
        return mOut;
    }
    //transpose matrix
    public Matrix Transpose() {
        Matrix m= new Matrix(this.rows,this.cols);
        int i, j;
        for (i = 0; i < this.rows; i++) {
            for (j = 0; j < this.cols; j++) {
                m.setElmt(j, i, this.getElmt(i, j));
            }
        }
        return m;
    }

}