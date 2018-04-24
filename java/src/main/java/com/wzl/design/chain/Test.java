package com.wzl.design.chain;

/**
 * @author: weizhenglong
 * @since 2018-04-11
 */
public class Test {

    public static void main(String[] args) {
        RuleContext ruleContext=new RuleContext(34341);

        BossRuleHandle bossRuleHandle=new BossRuleHandle();

        ManagerRuleHandle managerRuleHandle=new ManagerRuleHandle();
        managerRuleHandle.setNext(bossRuleHandle);
        managerRuleHandle.handle(ruleContext);
    }
}
