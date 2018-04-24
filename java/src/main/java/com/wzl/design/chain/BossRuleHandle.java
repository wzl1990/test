package com.wzl.design.chain;

/**
 * @author: weizhenglong
 * @since 2018-04-11
 */
public class BossRuleHandle extends  AbstractRuleHandle{

    @Override
    public void handle(RuleContext ruleContext) {
        if (ruleContext.getFee() > 500) {
            System.out.println("bosss tongguo");
        }
    }
}
