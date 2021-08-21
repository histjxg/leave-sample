package profit.jikeshijian.shejimoshi.zuhemoshi;

/**
 * Created with IntelliJ IDEA.
 *
 * @Auther: huangxiaogen
 * @Date: 2020/07/12/下午3:05
 * @Description:
 */

public abstract class HumanResource {
    protected long id;
    protected double salary;

    public HumanResource(long id){
        this.id = id;
    }

    public long getId() {
        return id;
    }

    public abstract double calculateSalary();
}
