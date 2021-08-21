package profit.jikeshijian.shejimoshi.status;

/**
 * Created with IntelliJ IDEA.
 *
 * @Auther: huangxiaogen
 * @Date: 2020/07/19/下午7:02
 * @Description:
 */

/**
 *1。我写了一个骨架代码，如下所示。其中，obtainMushRoom()、obtainCape()、 obtainFireFlower()、meetMonster() 这几个函数
 * 2。能够根据当前的状态和事件，更新状 态和增减积分。
 * 3。
 * 4。
 *
 *
 */
public class MarioStateMachine {
    private int score;
    private State currentState;

    public MarioStateMachine(){
        this.score = 0;
        this.currentState = State.SMALL;
    }

    public void obtainMushRoom() {
        //TODO
    }
    public void obtainCape() {
        //TODO
    }
    public void obtainFireFlower() {
        //TODO
    }
    public void meetMonster() {
        //TODO
    }

    public int getScore() {
        return score;
    }

    public State getCurrentState() {
        return currentState;
    }
}
