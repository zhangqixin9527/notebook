package com.hengba.zookeeper;

import org.apache.zookeeper.*;
import org.apache.zookeeper.data.ACL;
import org.apache.zookeeper.data.Stat;

import java.io.IOException;
import java.util.List;

import static org.apache.zookeeper.CreateMode.PERSISTENT;

/**
 * @author Kevin created on 2017/9/27
 */
public class MyUtils {


    private static final String connectString = "192.168.137.163:2181";

    private static final int sessionTimeout = 2000;

    private static ZooKeeper zookeeper = null;

    /**
     * main函数
     *
     * @param args
     * @throws Exception
     */
    public static void main(String[] args) throws Exception {
        // 创建节点
//        create("/test", "啊哈哈哈");
        //调用rmr,删除所有目录
        rmr("/test");
        //findStringInPath("/mycat", "rule");
//        Stat stat = getZookeeper().exists("/test", false);
//        List<ACL> list = getZookeeper().getACL("/test", stat);
//        list.forEach(a->{
//            System.out.println(a.toString());
//        });
    }

    public static void findStringInPath(String path, String key) throws Exception {
        ZooKeeper zk = getZookeeper();
        List<String> children = zk.getChildren(path, false);
        for (String pathCd : children) {
            //获取父节点下面的子节点路径
            String newPath = "";
            //递归调用,判断是否是根节点
            if (path.equals("/")) {
                newPath = "/" + pathCd;
            } else {
                newPath = path + "/" + pathCd;
            }
            findStringInPath(newPath, key);
        }
        if (path != null && !path.trim().startsWith("/zookeeper") && !path.trim().equals("/")) {
            zk.delete(path, -1);
            byte[] str = zk.getData(path, true, null);
            String val = new String(str);
            System.out.println("str = " + val);
            if (val.contains(key)) {
                System.out.println("Got it:" + val);
            }
            //打印删除的节点路径
            System.out.println("被删除的节点为：" + path);
        }
    }

    public static void create(String path, String data) throws IOException, KeeperException, InterruptedException {
        getZookeeper().create(path, data.getBytes(), ZooDefs.Ids.OPEN_ACL_UNSAFE, PERSISTENT);
    }

    public static void rmr(String path) throws Exception {
        ZooKeeper zk = getZookeeper();
        //获取路径下的节点
        List<String> children = zk.getChildren(path, false);
        for (String pathCd : children) {
            //获取父节点下面的子节点路径
            String newPath = "";
            //递归调用,判断是否是根节点
            if (path.equals("/")) {
                newPath = "/" + pathCd;
            } else {
                newPath = path + "/" + pathCd;
            }
            rmr(newPath);
        }
        //删除节点,并过滤zookeeper节点和 /节点
        if (path != null && !path.trim().startsWith("/zookeeper") && !path.trim().equals("/")) {
            zk.delete(path, -1);
            //打印删除的节点路径
            System.out.println("被删除的节点为：" + path);
        }
    }

    /**
     * 获取Zookeeper实例
     *
     * @return
     * @throws IOException
     */
    public static ZooKeeper getZookeeper() throws IOException {
        zookeeper = new ZooKeeper(connectString, sessionTimeout, null);
        return zookeeper;
    }
}

