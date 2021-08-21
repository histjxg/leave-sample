package profit.jikeshijian.shejimoshi.status;

/**
 * Created with IntelliJ IDEA.
 *
 * @Auther: huangxiaogen
 * @Date: 2020/07/19/下午7:58
 * @Description:
 */

public class SuperMarioTwo implements IMarioTwo {
    private static final SuperMarioTwo instance = new SuperMarioTwo();
    private SuperMarioTwo() {}
    public static SuperMarioTwo getInstance() {
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
        stateMachine.setCurrentState(SmallMarioTwo.getInstance());
        stateMachine.setScore(stateMachine.getScore() - 100);
    }
}
