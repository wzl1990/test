package com.wzl.java1.exer;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Description :
 * Author: zhenglong
 * since 27 九月 2017
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Transaction {

    private  Trader trader;

    private  int year;

    private  int value;

}
