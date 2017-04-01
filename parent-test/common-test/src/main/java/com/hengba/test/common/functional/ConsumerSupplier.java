/*
 * 文件名称: ConsumerSupplier.java
 * 版权信息: Copyright 2016-2020 technology Co., LTD. All right reserved.
 * ----------------------------------------------------------------------------------------------
 * 修改历史:
 * ----------------------------------------------------------------------------------------------
 * 修改原因: 新增
 * 修改人员: Kevin
 * 修改日期: 2017/3/30
 * 修改内容: 
 */
package com.hengba.test.common.functional;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.function.Consumer;
import java.util.function.Supplier;

/**
 * @author Kevin created on 2017/3/30.
 * @since framework 1.0
 */
public class ConsumerSupplier<T> extends Thread{
    public static void main(String[] args) throws InterruptedException {
        Supplier<User> supplier = User::new;
        User user1 = supplier.get();
        user1.setAge(30);
        Supplier<Integer> supplier1 = user1::getAge;
        System.out.println(supplier1.get());
        Supplier<String> supplier2 = User::helloWorld;
        System.out.println(supplier2.get());

        Consumer<Integer> consumer = user1::setAge;
        consumer.accept(25);
        System.out.println(user1.getAge()+"||"+supplier1.get());
        Consumer<User> consumer1 = a -> System.out.println(a.getAge());
        List<User> list = new ArrayList<>();
        list.add(user1);
        list.stream().forEach(consumer1);

        LinkedBlockingDeque<User> queue = new LinkedBlockingDeque<>();

        Supplier<User> sUser = () -> {
            try {
                User a = queue.take();
                System.out.println("supplier"+ a.getAge()+"="+a.getName());
                return a;
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return null;
        };

        Consumer<User> cUser = a -> {
            System.out.println("      "+a.getAge()+"="+a.getName());
        };

        new ConsumerSupplier<>(sUser, cUser).start();

        for(int i=0;i<100;i++){
            queue.put(new User(i, "user"+i));
        }
    }
    Supplier<T> supplier;
    Consumer<T> consumer;

    public ConsumerSupplier(Supplier<T> supplier, Consumer<T> consumer){
        this.supplier = supplier;
        this.consumer = consumer;
    }


    @Override
    public void run() {
        while(true){
            T item = supplier.get();
            consumer.accept(item);
        }
    }
}
