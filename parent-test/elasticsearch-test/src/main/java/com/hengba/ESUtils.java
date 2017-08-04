/*
 * 文件名称: ESUtils.java
 * 版权信息: Copyright 2016-2020 technology Co., LTD. All right reserved.
 * ----------------------------------------------------------------------------------------------
 * 修改历史:
 * ----------------------------------------------------------------------------------------------
 * 修改原因: 新增
 * 修改人员: Kevin
 * 修改日期: 2017/7/27
 * 修改内容: 
 */
package com.hengba;

import org.elasticsearch.action.ActionListener;
import org.elasticsearch.action.delete.DeleteRequestBuilder;
import org.elasticsearch.action.delete.DeleteResponse;
import org.elasticsearch.action.get.*;
import org.elasticsearch.action.index.IndexRequestBuilder;
import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.action.update.UpdateRequestBuilder;
import org.elasticsearch.action.update.UpdateResponse;
import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.common.transport.InetSocketTransportAddress;
import org.elasticsearch.common.xcontent.XContentFactory;
import org.elasticsearch.common.xcontent.XContentType;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.index.reindex.BulkByScrollResponse;
import org.elasticsearch.index.reindex.DeleteByQueryAction;
import org.elasticsearch.index.reindex.DeleteByQueryRequestBuilder;
import org.elasticsearch.transport.client.PreBuiltTransportClient;

import java.io.IOException;
import java.net.InetAddress;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Kevin created on 2017/7/27.
 * @since framework 1.0
 */
public class ESUtils {
    private static TransportClient client;

    static {
        Settings settings = Settings.builder().put("client.transport.sniff", true).build();
        byte[] transportIps = new byte[]{(byte) 192, (byte) 168, (byte) 137, (byte) 190};
        try {
            client = new PreBuiltTransportClient(settings)
                    .addTransportAddress(new InetSocketTransportAddress(InetAddress.getByAddress(transportIps), 9300));
        } catch (Throwable e) {
            e.printStackTrace();
        }
    }

    public static boolean createIndex(String index, String type, String id, String json) {
        IndexRequestBuilder requestBuilder = client.prepareIndex(index, type, id).setSource(json, XContentType.JSON);
        IndexResponse response = requestBuilder.get();
        System.out.println(response.getIndex());
        return true;
    }

    public static boolean createIndex(String index, String type, String id, Map<String, Object> map) {
        IndexRequestBuilder requestBuilder = client.prepareIndex(index, type, id).setSource(map);
        IndexResponse response = requestBuilder.get();
        System.out.println(response.getIndex());
        System.out.println(response.getType());
        System.out.println(response.getId());
        return true;
    }

    public static boolean createIndex(String index, String type, String id, String name, String tel) throws IOException {
        IndexRequestBuilder requestBuilder = client.prepareIndex(index, type, id)
                .setSource(XContentFactory.jsonBuilder().startObject().field("name", name).field("tel", tel).endObject());
        IndexResponse response = requestBuilder.get();
        System.out.println(response.getIndex());
        System.out.println(response.getType());
        System.out.println(response.getId());
        return true;
    }

    public static void get(String index, String type, String id) {
        GetRequestBuilder requestBuilder = client.prepareGet(index, type, id);
        GetResponse response = requestBuilder.get();
        System.out.println("index: " + response.getIndex());
        System.out.println("type: " + response.getType());
        System.out.println("id: " + response.getId());
        System.out.println("source: " + response.getSourceAsString());
    }

    public static void delete(String index, String type, String id) {
        DeleteRequestBuilder requestBuilder = client.prepareDelete(index, type, id);
        DeleteResponse response = requestBuilder.get();
        System.out.println("index: " + response.getIndex());
        System.out.println("type: " + response.getType());
        System.out.println("id: " + response.getId());
    }

    public static void deleteByQuery() {
        DeleteByQueryRequestBuilder requestBuilder = DeleteByQueryAction.INSTANCE.newRequestBuilder(client);
        requestBuilder.filter(QueryBuilders.matchQuery("name", "zyh"))
                .source("java_client_index")
                .execute(new ActionListener<BulkByScrollResponse>() {
                    @Override
                    public void onResponse(BulkByScrollResponse bulkByScrollResponse) {
                        long deleted = bulkByScrollResponse.getDeleted();
                        System.out.println("deleted: " + deleted);
                        System.out.println("deleted string: " + bulkByScrollResponse.toString());
                    }

                    @Override
                    public void onFailure(Exception e) {
                        System.out.println("Failure!!!" + e);
                        e.printStackTrace();
                    }
                });
    }

    public static boolean update(String index, String type, String id, String json) {
        UpdateRequestBuilder requestBuilder = client.prepareUpdate(index, type, id);
        requestBuilder.setDoc(json, XContentType.JSON);
        UpdateResponse response = requestBuilder.get();
        return true;
    }

    /**
     * 可以查找a list of documents based on their index,type and id
     */
    public static void multiGet() {
        MultiGetRequestBuilder requestBuilder = client.prepareMultiGet();
        requestBuilder.add("java_client_index", "java", "1")
                .add("java_client_index", "ruby", "1")
                .add("java_client_index", "js", "1");
        MultiGetResponse responses = requestBuilder.get();
        System.out.println("### " + responses.toString());
        for (MultiGetItemResponse itemResponse : responses) {
            GetResponse response = itemResponse.getResponse();
            if (response.isExists()) {
                System.out.println("## " + response.getSourceAsString());
            }
        }
        System.out.println("########### iterator ##########");
        responses.forEach(a -> System.out.println("## " + a.getResponse().getSourceAsString()));
    }

    public static void main(String[] args) throws IOException {
        ESUtils.createIndex("java_client_index", "java", "1", "{\"name\":\"zqx\"}");

        Map<String, Object> map = new HashMap<>();
        map.put("name", "qly");
        map.put("tel", "12345678902");
        ESUtils.createIndex("java_client_index", "ruby", "2", map);

        ESUtils.createIndex("java_client_index", "js", "1", "zyh", "09876543211");

        ESUtils.get("java_client_index", "java", "1");

//        ESUtils.delete("java_client_index", "ruby", "2");
//
//        ESUtils.deleteByQuery();

        ESUtils.update("java_client_index", "java", "1", "{\"name\":\"zqx001\"}");

        ESUtils.multiGet();

        while (true) {
        }
    }
}
