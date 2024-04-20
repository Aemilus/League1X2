package app.league1x2.utils;

import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("Convert2Diamond")
public class CartesianProduct<E> {

    public List<List<E>> getCartesianProduct(List<List<E>> sets) {
        List<List<E>> result = new ArrayList<>();
        getCartesianProductHelper(sets, 0, new ArrayList<E>(), result);
        return result;
    }

    private void getCartesianProductHelper(List<List<E>> sets, int index, List<E> current, List<List<E>> result) {
        if (index == sets.size()) {
            result.add(new ArrayList<E>(current));
            return;
        }
        List<E> currentSet = sets.get(index);
        int lastIndex;
        for (E element: currentSet) {
            current.add(element);
            getCartesianProductHelper(sets, index+1, current, result);
            lastIndex = current.size() - 1;
            current.remove(lastIndex);
        }
    }
}
