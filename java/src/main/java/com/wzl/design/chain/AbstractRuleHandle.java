package com.wzl.design.chain;

import lombok.Setter;

/**
 * @author: weizhenglong
 * @since 2018-04-11
 */
@Setter
public abstract class AbstractRuleHandle {

    public AbstractRuleHandle next;

    public  abstract  void handle(RuleContext ruleContext);
}
