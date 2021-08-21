package profit.jikeshijian.shujujiegou.queue;

/**
分析：
 1。需要两个指针:一个是head指针，指向队头;一个是tail指针，指向队尾。
 2。
 3。
 */
// 用数组实现的队列
public class ArrayQueue09 {
  // 数组：items，数组大小：n
  private String[] items;
  private int n = 0;
  // head表示队头下标，tail表示队尾下标
  private int head = 0;
  private int tail = 0;

  // 申请一个大小为capacity的数组
  public ArrayQueue09(int capacity) {
    items = new String[capacity];
    n = capacity;
  }

  // 入队
  //缺点：

  /**
   *
   *
   缺点：
     1。随着不停地进行入队、出队操作，head和tail都会持续往后移动。
     2。当tail移动到最右边，即使数组中还有空闲空间，也无法继续往队列中添加数据了
   */
  public boolean enqueue01(String item) {
    // 如果tail == n 表示队列已经满了
    if (tail == n)
      return false;
    items[tail] = item;
    ++tail;
    return true;
  }
  //优化之后
  // 入队操作，将item放入队尾,
  //思路：我们在出队时可以不用搬移数据。
  // 如果没有空闲空间了，我们只需要在入队时，再集中触发一次数据的搬移操作
  public boolean enqueue02(String item) {
    // tail == n表示队列末尾没有空间了
    if (tail == n) {
      // tail ==n && head==0，表示整个队列都占满了
      if (head == 0)
        return false;
      // 数据搬移
      for (int i = head; i < tail; ++i)

      {
        // 搬移完之后重新更新head和tail
        items[i - head] = items[i];
      }
      tail -= head;
      head = 0;
    }
      items[tail] = item;
      ++tail;
      return true;
    }


  // 出队
  public String dequeue() {
    // 如果head == tail 表示队列为空
    if (head == tail) return null;
    // 为了让其他语言的同学看的更加明确，把--操作放到单独一行来写了
    String ret = items[head];
    ++head;
    return ret;
  }



  public void printAll() {
    for (int i = head; i < tail; ++i) {
      System.out.print(items[i] + " ");
    }
    System.out.println();
  }
}
