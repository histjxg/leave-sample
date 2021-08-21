package profit.jikeshijian.shejimoshi.zuhemoshi;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @Auther: huangxiaogen
 * @Date: 2020/07/12/下午3:08
 * @Description:
 */

public class Department extends HumanResource {
    private List<HumanResource> subNodes = new ArrayList<>();

    public Department(long id){
        super(id);
    }

    @Override
    public double calculateSalary() {
        double totalSalary = 0;

        for (HumanResource hr:subNodes){
            totalSalary+=hr.calculateSalary();
        }
        this.salary = totalSalary;
        return totalSalary;
    }

    public void addSubNode(HumanResource hr){
        subNodes.add(hr);
    }
}
