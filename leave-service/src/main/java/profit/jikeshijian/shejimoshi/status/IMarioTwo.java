package profit.jikeshijian.shejimoshi.status;

/**
 * Created with IntelliJ IDEA.
 *
 * @Auther: huangxiaogen
 * @Date: 2020/07/19/下午7:52
 * @Description:
 */

public interface IMarioTwo {
    State getName();
    void obtainMushRoom(MarioStateMachineFive stateMachine);
    void obtainCape(MarioStateMachineFive stateMachine);
    void obtainFireFlower(MarioStateMachineFive stateMachine);
    void meetMonster(MarioStateMachineFive stateMachine);
}
