package profit.jikeshijian.shejimoshi.status;

/**
 * Created with IntelliJ IDEA.
 *
 * @Auther: huangxiaogen
 * @Date: 2020/07/19/下午7:53
 * @Description:
 */

public class SmallMarioTwo implements IMarioTwo{
    private static final SmallMarioTwo instance = new SmallMarioTwo();
    private SmallMarioTwo() {}
    public static SmallMarioTwo getInstance() {
        return instance;
    }
    @Override
    public State getName() {
        return State.SMALL;
    }
    @Override
    public void obtainMushRoom(MarioStateMachineFive stateMachine) {
        stateMachine.setCurrentState(SuperMarioTwo.getInstance());
        stateMachine.setScore(stateMachine.getScore() + 100);
    }
    @Override
    public void obtainCape(MarioStateMachineFive stateMachine) {
        stateMachine.setCurrentState(CapeMarioTwo.getInstance());
        stateMachine.setScore(stateMachine.getScore() + 200);
    }
    @Override
    public void obtainFireFlower(MarioStateMachineFive stateMachine) {
        stateMachine.setCurrentState(FireMarioTwo.getInstance());
        stateMachine.setScore(stateMachine.getScore() + 300);
    }
    @Override
    public void meetMonster(MarioStateMachineFive stateMachine) {
        // do nothing...
    }
}
