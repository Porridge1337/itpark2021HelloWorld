package lesson21;

import lesson12.Matrix;
import lesson12.exceptions.MyArrayDataException;
import lesson12.exceptions.MyArraySizeException;
import org.junit.Test;

import java.lang.reflect.InvocationTargetException;

public class MatrixTest {

    @Test(expected = MyArraySizeException.class)
    public void testMatrixSize() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Matrix matrix = new Matrix(3);
    }

    @Test(expected = MyArrayDataException.class)
    public void testMatrixContent(){
        Matrix matrix2 = new Matrix(4);
        matrix2.calculate();
    }
}
