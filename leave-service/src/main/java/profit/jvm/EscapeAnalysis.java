package profit.jvm;

import java.io.IOException;

public class EscapeAnalysis {
    private  int count = 1000000;

    public static void main(String[] args) throws InterruptedException, IOException {
        EscapeAnalysis escapeAnalysis = new EscapeAnalysis();
        for (int i = 0; i < escapeAnalysis.count ; i++) {
            escapeAnalysis.getAge();
        }
        Thread.sleep(500);
        for (int i = 0; i < escapeAnalysis.count ; i++) {
            escapeAnalysis.getAge();
        }
        System.in.read();
    }
//--183740  5879680
    //156772
    //-103257  3304224

    public int  getAge(){
        Person person = new Person("小明",18,28.1);
        return person.getAge();
    }

    class Person {

        private String name;

        private int age;

        private double weight;

        public Person(String name, int age, double weight) {
            super();
            this.name = name;
            this.age = age;
            this.weight = weight;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }

        public double getWeight() {
            return weight;
        }

        public void setWeight(double weight) {
            this.weight = weight;
        }
    }

}
