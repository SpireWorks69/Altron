package ru.spireworks.altron.matrix;


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class MatrixUtils {

    public static Matrix<Double> sum(Matrix<? extends Number> a, Matrix<? extends Number> b) {
        if (a.size() != b.size()) {
            try {
                throw new MatrixException("Different matrix sizes");
            } catch (MatrixException e) {
                e.printStackTrace();
            }
        }

        Matrix<Double> c = a instanceof ArrayMatrix ? new ArrayMatrix<>() : new LinkedMatrix<>();
        List<Double> tempList;

        for (int i = 0; i < a.elementList.size(); i++) {
            tempList = a instanceof ArrayMatrix ? new ArrayList<>() : new LinkedList<>();
            for (int j = 0; j < a.elementList.get(i).size(); j++) {
                tempList.add((a.elementList.get(i).get(j).doubleValue() + b.elementList.get(i).get(j).doubleValue()));
            }
            c.addRow(tempList);
        }

        return c;
    }
}