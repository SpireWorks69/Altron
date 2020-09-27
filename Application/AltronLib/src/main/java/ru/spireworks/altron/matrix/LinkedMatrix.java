package ru.spireworks.altron.matrix;

import java.util.LinkedList;

public class LinkedMatrix<E> extends Matrix<E> {
    public LinkedMatrix() {
        elementList = new LinkedList<>();
    }
}
