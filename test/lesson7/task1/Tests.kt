package lesson7.task1

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Tag
import org.junit.jupiter.api.Test

class Tests {
    @Test
    @Tag("Easy")
    fun createMatrix() {
        val matrix = createMatrix(4, 6, 0.0)
        assertEquals(4, matrix.height)
        assertEquals(6, matrix.width)
    }

    @Test
    @Tag("Normal")
    fun getSetInt() {
        val matrix = createMatrix(3, 2, 0)
        var value = 0
        for (row in 0 until matrix.height) {
            for (column in 0 until matrix.width) {
                matrix[row, column] = value++
            }
        }
        value = 0
        for (row in 0 until matrix.height) {
            for (column in 0 until matrix.width) {
                assertEquals(value++, matrix[Cell(row, column)])
            }
        }
    }

    @Test
    @Tag("Normal")
    fun getSetString() {
        val matrix = createMatrix(2, 2, "")
        val strings = listOf("alpha", "beta", "gamma", "omega")
        var index = 0
        for (row in 0 until matrix.height) {
            for (column in 0 until matrix.width) {
                matrix[Cell(row, column)] = strings[index++]
            }
        }
        index = 0
        for (row in 0 until matrix.height) {
            for (column in 0 until matrix.width) {
                assertEquals(strings[index++], matrix[row, column])
            }


        }
    }

    @Test
    fun matrixEquals() {
        val matrix1 = createMatrix(40, 50, "333")
        val matrix2 = createMatrix(40, 50, "333")
        val matrix3 = createMatrix(40, 50, 14)
        val matrix4 = createMatrix(40, 50, 0)

        assertTrue(matrix1 == matrix2)
        assertFalse(matrix1 == matrix3)
        assertFalse(matrix3 == matrix4)
    }
}