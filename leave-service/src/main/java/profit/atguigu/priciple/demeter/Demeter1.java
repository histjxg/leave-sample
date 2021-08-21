package profit.atguigu.priciple.demeter;

import java.util.ArrayList;
import java.util.List;

public class Demeter1 {
    public static void main(String[] args){
        SchoolManager e = new SchoolManager();
        e.printAllEmployee(new CollegeSchoolManager());
    }
}

//总公司员工
class Employee{
    private String id;
    public void setId(String id){
        this.id = id;
    }
    public String getId(){
        return id;
    }
}

//学院员工
class CollegeEmployee{
    private String id;
    public void setId(String id){
        this.id = id;
    }
    public String getId(){
        return id;
    }
}

//学院管理类
class CollegeSchoolManager{
    public List<CollegeEmployee> getAllEmployee(){
        List<CollegeEmployee> list = new ArrayList<>();
        for(int i=0; i<10 ; i++){
            CollegeEmployee emp = new CollegeEmployee();
            //为分公司人员按顺序分配一个ID
            emp.setId("分公司"+i);
            list.add(emp);
        }
        return list;
    }
}

//学校管理类
//分析schoolManger 类的直接朋友类有那些Employee，CollegeManger
//CoolegeEmployee 不是直接朋友，而是一个陌生类（局部变量），这样违背了迪米特法则
class SchoolManager{

    public List<Employee> getAllEmployee(){
        List<Employee> list = new ArrayList<Employee>();
        for(int i=0; i<5; i++){
            Employee emp = new Employee();
            //为总公司人员按顺序分配一个ID
            emp.setId("总公司"+i);
            list.add(emp);
        }
        return list;
    }

    public void printAllEmployee(CollegeSchoolManager sub){
        //不是直接朋友CollegeEmployee 不是SchoolManager的直接朋友
        //CollegeEmployee是以局部变量的出现在
        //违法了迪米特法则
        List<CollegeEmployee> list1 = sub.getAllEmployee();
        for(CollegeEmployee e:list1){
            System.out.println(e.getId());
        }

        List<Employee> list2 = this.getAllEmployee();
        for(Employee e:list2){
            System.out.println(e.getId());
        }
    }
}

