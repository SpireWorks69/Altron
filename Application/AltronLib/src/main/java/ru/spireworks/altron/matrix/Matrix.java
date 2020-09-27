package ru.spireworks.altron.matrix;

import java.util.Arrays;
import java.util.List;

public abstract class Matrix<E> {
    protected List<List<E>> elementList;

    public abstract void addRow(E[] array);

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();

        for (List<E> subList : elementList) {
            result.append("| ");
            for (E element : subList) {
                result.append(element).append(" ");
            }
            result.append(" |").append("\n");
        }

        return result.toString();
    }
}
