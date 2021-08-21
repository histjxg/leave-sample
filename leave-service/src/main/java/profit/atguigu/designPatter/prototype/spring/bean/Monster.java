package profit.atguigu.designPatter.prototype.spring.bean;

import lombok.Data;

@Data
public class Monster {
    private Integer id =10;
    private String nickName = "牛魔王";
    private String skill = "芭蕉扇";
    public Monster(){
        System.out.println("创建 。。。。。");
    }

    public Monster(Integer id, String nickName, String skill) {
        this.id = id;
        this.nickName = nickName;
        this.skill = skill;
    }

    @Override
    public String toString() {
        return "Monster{" + "id=" + id + ", nickName='" + nickName + '\'' + ", skill='" + skill + '\'' + '}';
    }
}
