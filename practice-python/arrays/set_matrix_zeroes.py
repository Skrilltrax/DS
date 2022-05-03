from typing import List, Dict, Set


# noinspection PyMethodMayBeStatic
class Solution:

    def set_zeroes(self, matrix: List[List[int]]) -> None:
        """
        Do not return anything, modify matrix in-place instead.
        """
        row_set: Set[int] = set()
        col_set: Set[int] = set()

        for i in range(0, len(matrix)):
            for j in range(0, len(matrix[0])):
                if matrix[i][j] == 0:
                    row_set.add(i)
                    col_set.add(j)

        for i in range(0, len(matrix)):
            for j in range(0, len(matrix[0])):
                if i in row_set or j in col_set:
                    matrix[i][j] = 0

    def set_zeroes_without_space(self, matrix: List[List[int]]) -> None:
        """
        Do not return anything, modify matrix in-place instead.
        """
        # Ideally we need two storage spaces per cell to set its row and column to be 0. However, for the first row
        # and the first column we only have one cell, that is matrix[0][0]. Therefore, to store more information,
        # we create two new variables which specify if the first row contained any zero or the first column contained
        # any zero.
        is_first_row_zero: bool = False
        is_first_col_zero: bool = False
        rows: int = len(matrix)
        cols: int = len(matrix[0])

        # Check if the first row contains zero
        for i in range(rows):
            if matrix[i][0] == 0:
                is_first_row_zero = True

        # Check if the first column contains zero
        for j in range(cols):
            if matrix[0][j] == 0:
                is_first_col_zero = True

        # From the second row/column mark the top row/column to be zero. This acts as a marker for us. It means that we
        # want to make the whole row/column to be zero during our second pass.
        for i in range(1, rows):
            for j in range(1, cols):
                if matrix[i][j] == 0:
                    matrix[i][0] = 0
                    matrix[0][j] = 0

        # This is the second pass, check if the cell's first row or first column is zero. If it is, mark the cell as 0.
        for i in range(1, rows):
            for j in range(1, cols):
                if matrix[i][0] == 0 or matrix[0][j] == 0:
                    matrix[i][j] = 0

        # If the first row contained a zero initially, mark the whole first row to be 0.
        if is_first_row_zero:
            for i in range(rows):
                matrix[i][0] = 0

        # If the first column contained a zero initially, mark the whole first column to be 0.
        if is_first_col_zero:
            for j in range(cols):
                matrix[0][j] = 0
