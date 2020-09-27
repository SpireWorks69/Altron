package ru.spireworks.altron.matrix;

import java.util.ArrayList;

public class ArrayMatrix<E> extends Matrix<E> {
    public ArrayMatrix() {
        elementList = new ArrayList<>();
    }
}
