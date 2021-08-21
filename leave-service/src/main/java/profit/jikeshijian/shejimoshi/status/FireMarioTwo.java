package profit.jikeshijian.shejimoshi.status;

/**
 * Created with IntelliJ IDEA.
 *
 * @Auther: huangxiaogen
 * @Date: 2020/07/19/下午8:00
 * @Description:
 */

public class FireMarioTwo implements IMarioTwo {
    private static final FireMarioTwo instance = new FireMarioTwo();
    private FireMarioTwo() {}
    public static FireMarioTwo getInstance() {
        return instance;
    }
    @Override
    public State getName() {
        return State.SMALL;
    }
    @Override
    public void obtainMushRoom(MarioStateMachineFive stateMachine) {
        // do nothing...
    }
    @Override
    public void obtainCape(MarioStateMachineFive stateMachine) {
        // do nothing...
    }
    @Override
    public void obtainFireFlower(MarioStateMachineFive stateMachine) {
        // do nothing...
    }
    @Override
    public void meetMonster(MarioStateMachineFive stateMachine) {
        stateMachine.setCurrentState(SmallMarioTwo.getInstance());
        stateMachine.setScore(stateMachine.getScore() - 300);
    }
}
