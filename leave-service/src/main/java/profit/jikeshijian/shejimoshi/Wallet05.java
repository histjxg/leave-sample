package profit.jikeshijian.shejimoshi;

import java.math.BigDecimal;

/**
 *
 *
 1.从代码中，我们可以发现，Wallet 类主要有四个属性(也可以叫作成员变量),也就是我 们前面定义中提到的信息或者数据
    封装特性：
         1。对钱包的这四个属性的访问方式进行了限制
         2。调用者只允许通过下面这六个方法来访问或者修改钱包里的数据。
             String getId()
             long getCreateTime()
             BigDecimal getBalance()
             long getBalanceLastModifiedTime()
             void increaseBalance(BigDecimal increasedAmount)
             void decreaseBalance(BigDecimal decreasedAmount)
     这样设计的原因：
         对于id、createTime
             1。因为从业务的角度来说，id、createTime 在创建钱包的时候就确定好 了，之后不应该再被改动
             2。所以，我们并没有在 Wallet 类中，暴露 id、createTime 这两 个属性的任何修改方法，比如 set 方法。
             3。而且，这两个属性的初始化设置，对于 Wallet 类 的调用者来说，也应该是透明的
             4。所以，我们在 Wallet 类的构造函数内部将其初始化设置 好，而不是通过构造函数的参数来外部赋值。

         对于钱包余额 balance 这个属性
             1。从业务的角度来说，只能增或者减，不会被重新设置。
             2。我们在 Wallet 类中，只暴露了 increaseBalance() 和 decreaseBalance() 方法，并没有暴露 set 方法
         对于 balanceLastModifiedTime 这个属性：
             1。它完全是跟 balance 这 个属性的修改操作绑定在一起的
             2。只有在 balance 修改的时候，这个属性才会被修改。
             3。我们把 balanceLastModifiedTime 这个属性的修改操作完全封装在了 increaseBalance() 和 decreaseBalance() 两个方法中，不对外暴露任何修改这个属性的方法和业务细节。
             4。这样也可以保证 balance 和 balanceLastModifiedTime 两个数据的一致性。

 */

public class Wallet05 {
    private String id;//表示钱包的唯一编号
    private long createTime; //表示钱包的创建时间
    private BigDecimal balance; //表示钱包中的余额
    private long balanceLastModifiedTime; //表示上次钱包余额 变更的时间。
    // ... 省略其他属性...

    public Wallet05() {
//        this.id = IdGenerator.getInstance().generate();
        this.createTime = System.currentTimeMillis();
        this.balance = BigDecimal.ZERO;
        this.balanceLastModifiedTime = System.currentTimeMillis();
    }

    // 注意:下面对 get 方法做了代码折叠，是为了减少代码所占文章的篇幅
    public String getId() {
        return this.id;
    }

    public long getCreateTime() {
        return this.createTime;
    }

    public BigDecimal getBalance() {
        return this.balance;
    }

    public long getBalanceLastModifiedTime() {
        return this.balanceLastModifiedTime;
    }

    public void increaseBalance(BigDecimal increasedAmount) {
        if (increasedAmount.compareTo(BigDecimal.ZERO) < 0) {
//            throw new InvalidAmountException("...");
        }
        this.balance.add(increasedAmount);
        this.balanceLastModifiedTime = System.currentTimeMillis();
    }

    public void decreaseBalance(BigDecimal decreasedAmount) {
        if (decreasedAmount.compareTo(BigDecimal.ZERO) < 0) {
//            throw new InvalidAmountException("...");
        }
        if (decreasedAmount.compareTo(this.balance) > 0) {
//            throw new InsufficientAmountException("...");
        }
        this.balance.subtract(decreasedAmount);
        this.balanceLastModifiedTime = System.currentTimeMillis();
    }

}
