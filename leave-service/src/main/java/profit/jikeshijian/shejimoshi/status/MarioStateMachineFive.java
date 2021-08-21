package profit.jikeshijian.shejimoshi.status;

/**
 * Created with IntelliJ IDEA.
 *
 * @Auther: huangxiaogen
 * @Date: 2020/07/19/下午7:53
 * @Description:
 */

public class MarioStateMachineFive {
    private int score;
    private IMarioTwo currentState;
    public MarioStateMachineFive() {
        this.score = 0;
        this.currentState = SmallMarioTwo.getInstance();
    }
    public void obtainMushRoom() {
        this.currentState.obtainMushRoom(this);
    }
    public void obtainCape() {
        this.currentState.obtainCape(this);
    }
    public void obtainFireFlower() {
        this.currentState.obtainFireFlower(this);
    }
    public void meetMonster() {
        this.currentState.meetMonster(this);
    }
    public int getScore() {
        return this.score;
    }
    public State getCurrentState() {
        return this.currentState.getName();
    }
    public void setScore(int score) {
        this.score = score;
    }
    public void setCurrentState(IMarioTwo currentState) {
        this.currentState = currentState;
    }
}
