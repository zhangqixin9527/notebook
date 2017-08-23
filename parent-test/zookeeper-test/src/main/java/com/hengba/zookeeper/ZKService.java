/*
 * 文件名称: ZKService.java
 * 版权信息: Copyright 2016-2020 technology Co., LTD. All right reserved.
 * ----------------------------------------------------------------------------------------------
 * 修改历史:
 * ----------------------------------------------------------------------------------------------
 * 修改原因: 新增
 * 修改人员: Kevin
 * 修改日期: 2017/8/4
 * 修改内容: 
 */
package com.hengba.zookeeper;

import org.apache.commons.collections4.MapUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.zookeeper.AsyncCallback;
import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher;
import org.apache.zookeeper.ZooKeeper;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/**
 * @author Kevin created on 2017/8/4.
 * @since framework 1.0
 */
public class ZKService {
    private ZooKeeper zk;
    private String zkServers;
    private int timeout;
    private Map<String, AsyncCallback> callbackMap;

    public ZKService(String zkServers, int timeout) {
        this.zkServers = zkServers;
        this.timeout = timeout;
    }


    public void addCallback(String name, AsyncCallback callback){
        if(MapUtils.isNotEmpty(callbackMap)){
            callbackMap.put(name, callback);
        }else {
            callbackMap = new HashMap<>();
            callbackMap.put(name, callback);
        }
    }

    public class ZKWatcher implements Watcher{

        @Override
        public void process(WatchedEvent event) {
            // 观察事件状态分类
            System.out.println("watch a event");
        }
    }

    public void service(String path) throws InterruptedException {
        if(null == zk){
            if(!initZkClient())
                return;
        }
        callbackMap.entrySet().forEach(a -> {
            AsyncCallback cb = a.getValue();
            if(cb instanceof AsyncCallback.StatCallback) {
                zk.exists(path, true, (AsyncCallback.StatCallback)a.getValue(), null);
            }
        });
        while (true){
        }
    }

    private boolean initZkClient(){
        ZKWatcher watcher = new ZKWatcher();
        try {
            this.zk = new ZooKeeper(zkServers, timeout, watcher);
            return true;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }
}
