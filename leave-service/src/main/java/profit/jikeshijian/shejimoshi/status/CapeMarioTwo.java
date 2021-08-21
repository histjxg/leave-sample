package profit.jikeshijian.shejimoshi.status;

/**
 * Created with IntelliJ IDEA.
 *
 * @Auther: huangxiaogen
 * @Date: 2020/07/19/下午7:59
 * @Description:
 */

public class CapeMarioTwo implements IMarioTwo {
    private static final CapeMarioTwo instance = new CapeMarioTwo();
    private CapeMarioTwo() {}
    public static CapeMarioTwo getInstance() {
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
        stateMachine.setScore(stateMachine.getScore() - 200);
    }
}
