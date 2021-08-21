package profit.jikeshijian.shejimoshi;

public class SortedDynamicArray05  extends DynamicArray05 {

    @Override
    public void add(Integer e) {
        ensureCapacity();
        int i = size - 1;
        for (; i >= 0; --i) { // 保证数组中的数据有序
            if (elements[i] > e) {
                elements[i + 1] = elements[i];
            } else {
                break;
            }
        }
        elements[i + 1] = e;
        ++size;

    }

}
