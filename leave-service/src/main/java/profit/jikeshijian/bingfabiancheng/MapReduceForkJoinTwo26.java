package profit.jikeshijian.bingfabiancheng;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;

/**
 *
 *
 *
 统计一个文件里面每个单词的数量，
 下面我们来看看如何用Fork/Join并行计算框架来实现。
 思路：
 1。我们可以先用二分法递归地将一个文件拆分成更小的文件
 2。直到文件里只有一行数据
 3。然后统计这一行数据里单词的数量

 可以对照前面的简版分治任务模型图来理解这个过程。
 1。下面的示例程序用一个字符串数组 String[] fc 来模拟文件内容
 2。fc里面的元素与文件里面的行数据一一对应。
 3。关键的代码在 compute() 这个方法里面，这是一个递归方法
 4。前半部分数据fork一个递归任务去处理（关键代码mr1.fork()），
 5。
 *
 *
 *
 */
public class MapReduceForkJoinTwo26 {
    public static void main(String[] args){
        String[] fc = {"hello world",
                "hello me",
                "hello fork",
                "hello join",
                "fork join in world"};
        //创建ForkJoin线程池
        ForkJoinPool fjp =
                new ForkJoinPool(3);
        //创建任务
        MR mr = new MR(
                fc, 0, fc.length);
        //启动任务
        Map<String, Long> result =
                fjp.invoke(mr);
        //输出结果
        result.forEach((k, v)->
                System.out.println(k+":"+v));
    }
    //MR模拟类
    static class MR extends RecursiveTask<Map<String, Long>> {
        private String[] fc;
        private int start, end;
        //构造函数
        MR(String[] fc, int fr, int to){
            this.fc = fc;
            this.start = fr;
            this.end = to;
        }
        @Override protected
        Map<String, Long> compute(){
            if (end - start == 1) {
                return calc(fc[start]);
            } else {
                int mid = (start+end)/2;
                MR mr1 = new MR(
                        fc, start, mid);
                mr1.fork();
                MR mr2 = new MR(
                        fc, mid, end);
                //计算子任务，并返回合并的结果
                return merge(mr2.compute(),
                        mr1.join());
            }
        }
        //合并结果
        private Map<String, Long> merge(
                Map<String, Long> r1,
                Map<String, Long> r2) {
            Map<String, Long> result =
                    new HashMap<>();
            result.putAll(r1);
            //合并结果
            r2.forEach((k, v) -> {
                Long c = result.get(k);
                if (c != null)
                    result.put(k, c+v);
                else
                    result.put(k, v);
            });
            return result;
        }
        //统计单词数量
        private Map<String, Long>
        calc(String line) {
            Map<String, Long> result =
                    new HashMap<>();
            //分割单词
            String [] words =
                    line.split("\\s+");
            //统计单词数量
            for (String w : words) {
                Long v = result.get(w);
                if (v != null)
                    result.put(w, v+1);
                else
                    result.put(w, 1L);
            }
            return result;
        }
    }
}
