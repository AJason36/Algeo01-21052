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
                elmt = scanElmt.nextDouble();
                this.matrix[i][j] = elmt;
            }
        }
    }
    
    public Matrix copyMatrix() {
        Matrix mOut = new Matrix(this.rows, this.cols);
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
    // copy sebagian matrix 
    public Matrix copy(int sRow, int fRow, int sCol, int fCol) {
        int i, j;
        Matrix mOut = new Matrix(fRow, fCol);
        for (i = 0; i < fRow; i++) {
            for (j = 0; j < fCol; j++) {
                mOut.setElmt(i, j, this.getElmt(i+sRow, j+sCol));
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
                    System.out.printf("%.2f ",this.matrix[i][j]);
                } else {
                    System.out.printf("%.2f",this.matrix[i][j]);
                }
            }
            System.out.println();
        }
    }
    
    // ********************* SELEKTOR *********************** 
    public void resize(int row, int col) {
        double[][] newMat = new double[row][col];
        int sRow,sCol;
        if (row < this.rows){
            sRow = row;
        } else{ 
            sRow = this.rows;
        }
        if (col< this.cols){
            sCol = col;
        }  else  {
            sCol = this.cols;
        }
        int i, j;

        for (i = 0; i < sRow; i++) {
            for (j = 0; j < sCol; j++) {
                newMat[i][j] = this.matrix[i][j];
            }
        }
        this.rows = row;
        this.cols = col;
        this.matrix = newMat;
    }
    
    public int getCol() {
        return this.cols;
    }

    public void setCol(int col) {
        this.resize(this.rows, col);
    }

    public int getRow() {
        return this.rows;
    }

    public void setRow(int row) {
        this.resize(row, this.cols);
    }
    public double getElmt(int i, int j) {
        return this.matrix[i][j];
    }

    public void setElmt(int i, int j, double val) {
        this.matrix[i][j] = val;
    }
    
    // ngeprint kolom / baris tertentu
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

    // cek apakah dari matriks ada kolom yang 0
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
    
    //transpose matrix
    public Matrix Transpose() {
        Matrix m= new Matrix(this.cols,this.rows);
        int i, j;
        for (i = 0; i < this.rows; i++) {
            for (j = 0; j < this.cols; j++) {
                m.setElmt(j, i, this.getElmt(i, j));
            }
        }
        return m;
    }
    
    public boolean isSegitigaAtas() {
        int i, j;
        boolean val;
        val = true;
        if (this.rows == 1 || this.cols == 1) {
            val = false;
        } else {
            for (i = 1; i < this.rows; i++) {
                for (j = 0; j < i; j++) {
                    if (this.matrix[i][j] != 0) val = false;
                }
            }
        }
        return val;
    }
    
    public Matrix extendMatrix(Matrix m1, Matrix m2) {
        Matrix m3;
        int i, j;
        m3 = new Matrix(m1.getRow(), m1.getCol()+m2.getCol());
        for (i = 0; i < m1.getRow(); i++) {
            for (j = 0; j < m1.getCol()+m2.getCol(); j++) {
                if (j < m1.getCol()) {
                    m3.setElmt(i, j, m1.getElmt(i, j));
                } else {
                    m3.setElmt(i, j, m2.getElmt(i, j - m1.getCol()));
                }
            }
        }
        return m3;
    }
    
    public double countRow(Matrix mawal, int titik, int rowReg, int colReg) {
        double sigmaRow; // Jumlah nilai x di baris
        sigmaRow = 0;
        int b;
        
        for (b = 0; b < titik; b++) {
            if (rowReg == 0) {
                sigmaRow += mawal.matrix[colReg-1][b]; // Mendapatkan sigma x1i
            } else {
                sigmaRow += mawal.matrix[rowReg-1][b]*mawal.matrix[colReg-1][b];
            }
            
        }
        return sigmaRow;
    }
}
