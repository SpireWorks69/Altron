package ru.spireworks.altron.matrix;

import java.util.ArrayList;
import java.util.Arrays;

public class ArrayMatrix<E> extends Matrix<E> {
    public ArrayMatrix() {
        elementList = new ArrayList<>();
    }

    @Override
    public void addRow(E[] array) {
        elementList.add(Arrays.asList(array));
    }
}
