package com.hengba.test.common.curl;

import com.alibaba.fastjson.JSON;
import org.apache.commons.lang3.StringUtils;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.net.URI;

/**
 * @author Kevin created on 2018/1/9
 */
public class CurlTest {
    @Test
    void telBelong() throws IOException {
        CloseableHttpClient httpClient = HttpClients.createDefault();
        HttpGet httpGet = new HttpGet();
        String base = "https://tcc.taobao.com/cc/json/mobile_tel_segment.htm?tel=18%03d062016";
        for (int i = 0; i < 1000; i++) {
            httpGet.setURI(URI.create(String.format(base, i)));
            CloseableHttpResponse response = httpClient.execute(httpGet);
            HttpEntity entity = response.getEntity();
            if (null != entity) {
                A a = resultToProvince(EntityUtils.toString(entity));
                if (null != a) {
                    System.out.println(String.format("18%03d062016", i));
                }
            }
        }
    }

    private A resultToProvince(String result) {
        if (StringUtils.isNoneBlank(result)) {
            String a = result.substring(result.indexOf("{"));
            A obj = JSON.parseObject(a, A.class);
            if ("江苏".equals(obj.getProvince())) {
                return obj;
            }
        }
        return null;
    }

    public static class A {
        //        private String mts;
        private String province;
//        private String catName;
//        private String telString;
//        private String areaVid;
//        private String ispVid;
//        private String carrier;

        public String getProvince() {
            return province;
        }

        public A setProvince(String province) {
            this.province = province;
            return this;
        }

        //        public String getTelString() {
//            return telString;
//        }
    }

    @Test
    void jsonTest() {
        String a = "{\n" +
                "\tprovince:'江苏'\n" +
                "}\n";
        String b = "{province:'江苏'}";
        System.out.println(JSON.parseObject(a, A.class).getProvince());
        System.out.println(JSON.parseObject(b, A.class).getProvince());

        A n = new A();
        n.setProvince("江苏");
        System.out.println(JSON.toJSON(n));
    }
}
