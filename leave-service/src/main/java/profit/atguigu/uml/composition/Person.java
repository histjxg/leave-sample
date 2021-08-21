package profit.atguigu.uml.composition;

public class Person {
    private IDCard idCard;//聚合
    private Head head = new Head();//组合关系
}
