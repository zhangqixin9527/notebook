/*
 * 文件名称: Main.java
 * 版权信息: Copyright 2016-2020 technology Co., LTD. All right reserved.
 * ----------------------------------------------------------------------------------------------
 * 修改历史:
 * ----------------------------------------------------------------------------------------------
 * 修改原因: 新增
 * 修改人员: Kevin
 * 修改日期: 2017/7/21
 * 修改内容: 
 */
package com.hengba;

import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.common.transport.InetSocketTransportAddress;
import org.elasticsearch.common.xcontent.XContentBuilder;
import org.elasticsearch.transport.client.PreBuiltTransportClient;

import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;

import static org.elasticsearch.common.xcontent.XContentFactory.jsonBuilder;

/**
 * 用以创建插入ElasticSearch的index document一条
 * @author Kevin created on 2017/7/21.
 * @since framework 1.0
 */
public class Main {
    public static void main(String[] args) {
        Settings settings = Settings.builder()
                .put("client.transport.sniff", true).build();
        try(TransportClient transportClient = new PreBuiltTransportClient(settings)
                .addTransportAddress(new InetSocketTransportAddress(InetAddress.getByAddress(new byte[]{(byte)192, (byte)168, (byte)137, (byte)190}), 9300))){
            XContentBuilder builder = jsonBuilder().startObject().field("uuid", "1010cd52-dc86-4944-a033-f5cbc5eba5a8").endObject();
            IndexResponse response = transportClient.prepareIndex("monitor-log-2017-07-20", "logs")
                    .setSource(builder).get();
            System.out.println("index: "+response.getIndex());
            System.out.println("_type: "+response.getType());
            System.out.println("_id: "+response.getId());
            System.out.println("_version: "+response.getVersion());
//            System.out.println("_source: "+response.);
        } catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
