package ru.spireworks.altron.matrix;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.stream.Collectors;

public class LinkedMatrix<E> extends Matrix<E> {
    public LinkedMatrix() {
        elementList = new LinkedList<>();
    }

    @Override
    public void addRow(E[] array) {
        elementList.add(Arrays.stream(array).collect(Collectors.toCollection(LinkedList::new)));
    }
}
