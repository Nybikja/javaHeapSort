import com.company.SortOrder;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import com.company.HeapSort;

public class HeapSortTest {

    private static HeapSort createObject(int[] arr) {
        return new HeapSort(arr);
    }

    @Test
    public void testSortDescending() {
        HeapSort heapSort = createObject(new int[]{7, 10, 1, 5, 0, 2});
        int[] expectedArr = {10, 7, 5, 2, 1, 0};

        heapSort.setOrder(SortOrder.DESCENDING);
        Assert.assertArrayEquals(expectedArr, heapSort.check());
    }

    @Test
    public void testSortDescendingSorted() {
        HeapSort heapSort = createObject(new int[]{10, 7, 5, 2, 1, 0});
        int[] expectedArr = {10, 7, 5, 2, 1, 0};
        heapSort.setOrder(SortOrder.DESCENDING);
        Assert.assertArrayEquals(expectedArr, heapSort.check());
    }

    @Test
    public void testSortAscending() {
        HeapSort heapSort = createObject(new int[]{5, 1, 2, 10, 7, 0});
        int[] expectedArr = {0, 1, 2, 5, 7, 10};
        Assert.assertArrayEquals(expectedArr, heapSort.check());
    }

    @Test
    public void testSortAscendingSorted() {
        HeapSort heapSort = createObject(new int[]{0, 1, 2, 5, 7, 10});
        int[] expectedArr = {0, 1, 2, 5, 7, 10};
        Assert.assertArrayEquals(expectedArr, heapSort.check());
    }
}
