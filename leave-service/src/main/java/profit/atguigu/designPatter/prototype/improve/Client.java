package profit.atguigu.designPatter.prototype.improve;


public class Client {
    public static void main(String[] args) {
        System.out.println("原型模式的创建");
        Sheep sheep = new Sheep("tome",1,"白色");
        sheep.friend = new Sheep("jack",2,"黑色");
        Sheep sheep2 = (Sheep) sheep.clone();
        Sheep sheep3 = (Sheep) sheep.clone();
        Sheep sheep4 = (Sheep) sheep.clone();
        Sheep sheep5 = (Sheep) sheep.clone();
        sheep.setAge(3);
        sheep.setColor("红色");
        System.out.println(sheep+"sheep.friend="+sheep.friend.hashCode());
        System.out.println(sheep2+"sheep2.friend="+sheep2.friend.hashCode());
        System.out.println(sheep3+"sheep3.friend="+sheep3.friend.hashCode());
        System.out.println(sheep4+"sheep4.friend="+sheep4.friend.hashCode());
        System.out.println(sheep5+"sheep5.friend="+sheep5.friend.hashCode());

    }
}
