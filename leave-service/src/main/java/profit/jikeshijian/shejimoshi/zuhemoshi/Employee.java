package profit.jikeshijian.shejimoshi.zuhemoshi;

import profit.jikeshijian.shejimoshi.zuhemoshi.HumanResource;

/**
 * Created with IntelliJ IDEA.
 *
 * @Auther: huangxiaogen
 * @Date: 2020/07/12/下午3:06
 * @Description:
 */

public class Employee extends HumanResource {
    public Employee(Long id,Double salary){
        super(id);
        this.salary = salary;
    }
    @Override
    public double calculateSalary() {
        return salary;
    }

}
