package profit.leetcode.code;
/*
 * 309. Best Time to Buy and Sell Stock with Cooldown
 * 题意：最佳时间买卖股票，有冷却期，如果前一天卖了，下一天就不能买
 * 难度：Medium
 * 分类：Dynamic Programming
 * 思路：状态DP，自己不会写。要分两种状态，手中有股票时最大收益，手中没股票时最大收益(包括冷冻期)。
 *      buy[i] means before day i what is the maxProfit for any sequence end with buy.
 *      buy[i] = max( buy[i-1], sell[i-2]-price[i] )
 *      sell[i] = max( sell[i-1], buy[i-1]+price[i] )
 *      压缩以后时间是O(n)，空间是O(1)
 * Tips：https://leetcode.com/problems/best-time-to-buy-and-sell-stock-with-cooldown/discuss/75931/Easiest-JAVA-solution-with-explanations
 *      lc121, lc309, lc188, lc123, lc714
 */
public class lc309 {
    public int maxProfit(int[] prices) {
        if(prices.length==0) return 0;
        int b1 = -prices[0];    //注意这里的初始化
        int s2=0, s1=0;
        int b = 0, s = 0;
        for (int i = 0; i < prices.length ; i++) {
            b = Math.max(b1, s2-prices[i]);
            s = Math.max(s1, b1+prices[i]);
            s2 = s1;
            s1 = s;
            b1 = b;
        }
        return Math.max(s,b);
    }

    public int maxProfit2(int[] prices) {
        if(prices.length==0) return 0;
        int[] sell = new int[prices.length];
        int[] buy = new int[prices.length];
        sell[0] = 0;
        buy[0] = -prices[0];
        for(int i=1; i<prices.length; i++){
            sell[i] = Math.max(sell[i-1], buy[i-1]+prices[i]);
            if(i==1) buy[i] = Math.max(buy[i-1], 0-prices[i]);
            else buy[i] = Math.max(buy[i-1], sell[i-2]-prices[i]);
        }
        return Math.max(sell[prices.length-1],buy[prices.length-1]);
    }
}
