package coll.Matrix;

import java.util.*;

/**
 * A generic 2D-matrix.
 *
 */
public class Matrix<E> implements Iterable {
    private E[][] matrix;
    private int columns;
    private int rows;
    /**
     * Constructs a Matrix.
     *
     * @param rows - the number of rows.
     * @param columns - the number of columns.
     */
    public Matrix(int rows, int columns) {
        matrix = (E[][]) new Object[rows][columns];
        this.rows = rows;
        this.columns = columns;

    }

    /**
     * Assigns a value to a given cell, specified by its row, column coordinates.
     *
     * @param row - the row index with 0-based indexing.
     * @param column - the column index with 0-based indexing.
     * @param value - the value to be assigned to the given cell.
     */
    public void insert(int row, int column, E value) {
        matrix[row][column] = value;

    }

    /**
     * Gets the value at a given cell, specified by its row, column coordinates.
     *
     * @param row - the row index with 0-based indexing.
     * @param column - the column index with 0-based indexing.
     * @return the value located at the given cell.
     */
    public E get(int row, int column) {
        return matrix[row][column];
    }

    /**
     * Gets the total number of cells in the matrix.
     *
     * @return an int equal to the total number of cells in the matrix.
     */
    public int size() {
        return columns * rows;
    }

    /**
     * Converts the matrix to String format.
     *
     * @return a String representation of the matrix.
     */
    public String toString() {
        StringBuilder mapAsString = new StringBuilder("");
        for(int i = 0; i < matrix.length; i++){
            for (int j = 0; j < matrix[0].length; j++){
                //add Value in current row and column and append to StringBuilder
                mapAsString.append(matrix[i][j]);
                //add tab character to separate row entries if not end of row
                if (j != (matrix[0].length - 1)){
                    mapAsString.append("\t");
                }
            }
            //add new line character to separate columns
            if (i != matrix.length - 1){
                mapAsString.append("\n");
            }
        }
        return mapAsString.toString();
    }

    /**
     * Gets an iterator for the matrix. The iterator follows column-major order.
     *
     * @return an iterator for the matrix.
     */
    public Iterator<E> iterator() {
        return new Iterator<E>() {

            int rowIndex = -1;
            int columnIndex = 0;
            @Override
            public boolean hasNext() {
                return rowIndex < matrix.length - 1 || columnIndex < matrix[0].length - 1;
            }

            @Override
            public E next() {
                if (rowIndex < matrix.length - 1){
                    rowIndex++;
                    return matrix[rowIndex][columnIndex];
                } else {
                    if (columnIndex < matrix[0].length - 1){
                        rowIndex = 0;
                        columnIndex++;
                        return matrix[rowIndex][columnIndex];
                    } else {
                        return null;
                    }
                }
            }
        };

    }


}