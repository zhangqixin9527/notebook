/*
 * 文件名称: ZKOption.java
 * 版权信息: Copyright 2016-2020 technology Co., LTD. All right reserved.
 * ----------------------------------------------------------------------------------------------
 * 修改历史:
 * ----------------------------------------------------------------------------------------------
 * 修改原因: 新增
 * 修改人员: Kevin
 * 修改日期: 2017/9/14
 * 修改内容: 
 */
package com.hengba.zookeeper;

import org.apache.zookeeper.KeeperException;
import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher;
import org.apache.zookeeper.ZooKeeper;
import org.apache.zookeeper.data.Stat;

import java.io.IOException;

/**
 * @author Kevin created on 2017/9/14.
 * @since framework 1.0
 */
public class ZKOption {
    public static void main(String[] args) {
        String zk = args[0];
        String znode = args[1];
        try {
            ZooKeeper zooKeeper = new ZooKeeper(zk, 3000, new Watcher() {
                @Override
                public void process(WatchedEvent event) {
                    System.out.println("我是操作里的Watch");
                }
            });
            Stat stat = zooKeeper.exists(znode, false);
            System.out.println("version: " + stat.getVersion());
            zooKeeper.setData(znode, "哈哈".getBytes(), stat.getVersion());
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (KeeperException e) {
            e.printStackTrace();
        }
    }
}
