package com.hengba.arithmetic.sort;

import org.junit.jupiter.api.Test;

/**
 * 冒泡排序：两层遍历，第一层是取基准值，举例升序就是取本次的最小值的位置
 * 第二层是为了取最小值，遍历之后数值，要是比最小值位置上的值还小，则交换（中间涉及一个临时变量，只有环状才能达到数据不丢失）
 * 时空复杂度O(n^2)
 * 改进后的性能可以增加一倍
 * @author Kevin created on 2017/9/23
 */
public class Bubble {

    @Test
    void bubble() {
        int[] origin = {1, 7, 5, 8, 6, 3, 4, 9, 2};
        for (int i = 0; i < origin.length; i++) {
            for (int j = i + 1; j < origin.length; j++) {
                if (origin[i] > origin[j]) {
                    int temp = origin[j];
                    origin[j] = origin[i];
                    origin[i] = temp;
                }
            }
        }
        for (int a : origin) {
            System.out.print(a + " ");
        }
    }

    /**
     * 改进算法，第一层遍历不变，第二层遍历同时取大小两个值（无论升序降序都适用）
     */
    @Test
    void bubbleImprove(){
        int[] origin = {1, 7, 5, 8, 6, 3, 4, 9, 2};
        int k = 0;
        while(k < origin.length){
            for(int i = k+1; i< origin.length;i++){
//                if()
            }
        }
    }
}
