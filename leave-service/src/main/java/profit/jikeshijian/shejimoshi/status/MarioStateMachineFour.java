package profit.jikeshijian.shejimoshi.status;

/**
 * Created with IntelliJ IDEA.
 *
 * @Auther: huangxiaogen
 * @Date: 2020/07/19/下午7:39
 * @Description:
 */

/**
 *
 * 1.上面的代码实现不难看懂，我只强调其中的一点，即 MarioStateMachine 和各个状态类之 间是双向依赖关系。
 * 2.MarioStateMachine 依赖各个状态类是理所当然的，但是，反过来， 各个状态类为什么要依赖 MarioStateMachine 呢?
 * 原因：
 *   这是因为，各个状态类需要更新 MarioStateMachine 中的两个变量，score 和 currentState。
 *
 *
 *
 *
 *
 *
 *
 */
public class MarioStateMachineFour {
    private int score;
    private IMario currentState; // 不再使用枚举来表示状态
    public MarioStateMachineFour() {
        this.score = 0;
        this.currentState = new SmallMario(this);
    }
    public void obtainMushRoom() {
        this.currentState.obtainMushRoom();
    }
    public void obtainCape() {
        this.currentState.obtainCape();
    }
    public void obtainFireFlower() {
        this.currentState.obtainFireFlower();
    }
    public void meetMonster() {
        this.currentState.meetMonster();
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
    public void setCurrentState(IMario currentState) {
        this.currentState = currentState;
    }
}
