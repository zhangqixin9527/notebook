package com.hengba.kotlin.grammar

/**
 * @author Kevin created on 2017/9/22
 */
fun main(args: Array<String>) {
    var arr = arrayOf(1, 3, 5, 4, 2, 15, 88, 45, 7, 51)
    print("Origin Array:")
    for (i in arr)
        print(" " + i)
    bubble(arr)
    println()
    print("Sorted Array:")
    for (i in arr) {
        print(" " + i)
    }

}

fun bubble(x: Array<Int>) {
    for (i in x.indices) {
        var j = i
        while(j++ < x.size - 1) {
            if (x[i] > x[j]) {
                var temp = x[i]
                x[i] = x[j]
                x[j] = temp
            }
        }
    }
}