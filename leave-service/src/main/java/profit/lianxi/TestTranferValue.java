package profit.lianxi;

public class TestTranferValue {
    public void changeValue1(int age ){
        age =30;
    }
    public void changeValue2(Person person ){
        person.setPersonName("XXXX");
    }
    public void changeValue3(String str ){
        str = "XXX";
    }

    public static void main(String[] args) {
        TestTranferValue testTranferValue = new TestTranferValue();
        int age =20;
        testTranferValue.changeValue1(20);
        System.out.println("age--------"+age);
        Person person = new Person("abc");
        testTranferValue.changeValue2(person);
        System.out.println("personName========="+person.getPersonName());
        String string = "xXX";
        testTranferValue.changeValue3(string);
        //String是一个比较特殊的类型
        System.out.println("string====="+string);
    }
}
