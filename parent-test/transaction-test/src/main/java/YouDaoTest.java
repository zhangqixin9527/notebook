/*
 * 文件名称: YouDaoTest.java
 * 版权信息: Copyright 2016-2020 technology Co., LTD. All right reserved.
 * ----------------------------------------------------------------------------------------------
 * 修改历史:
 * ----------------------------------------------------------------------------------------------
 * 修改原因: 新增
 * 修改人员: Kevin
 * 修改日期: 2017/7/7
 * 修改内容: 
 */
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Kevin created on 2017/7/7.
 * @since framework 1.0
 */
public class YouDaoTest {
    public static void main(String[] args) {
        String appKey = "0e61826d1b8348b1";
        String querys =
                "OAKLAND, Calif. -- Same teams, same result.<BR><BR>   The Golden State Warriors won Game 1 of the NBA Finals over the Cleveland Cavaliers for the third consecutive year Thursday night, running away in the third quarter for a 113-91 victory.<BR><BR>   Stephen Curry bombed in a pair of 3-pointers in a 13-0 flurry to begin the second half, and Kevin Durant had a game-high 38 points, helping the Warriors record their 13th straight postseason win and grab the early edge in the best-of-seven series.<BR><BR>   Game 2 is scheduled for Sunday night on the Warriors' home floor.<BR><BR>   \"We had an opportunity to win the first game of the series, get off to a good start; we were able to do that,\" said Curry, who finished with 28 points. \"You're not going to see crazy celebrations. You're not going to see us getting ahead of ourself. We feel like we can play much better, especially offensively.\"<BR><BR>   The teams are meeting in the NBA Finals for an unprecedented third straight year. Golden State used its Game 1 win as a springboard to the 2015 title, while the Cavaliers rebounded from their opening loss a year ago to dethrone the Warriors.<BR><BR>   Both teams walked away from this Game 1 believing Game 2 would be even more important.<BR><BR>   \"Win one game. Now we look to Sunday to try to do it again,\" Curry said. \"We have been here before and know there's a lot of work left to do. So, good start.\"<BR><BR>   The Cavaliers, who entered the series with a 12-1 postseason record, believe they help themselves by allowing the Warriors to get off 20 more shots (106-86), which was equally a product of Golden State's 14 offensive rebounds and Cleveland's 20 turnovers.<BR><BR>   \"I pride myself on not turning the ball over, and I did it too much,\" said LeBron James, who gave the ball away eight times. \"Twenty turnovers for 21 points on the road and 56 points (allowed) in the paint ... We did a great job covering the 3-point line, but other than that, they played a heck of a game.\"<BR><BR>   The Warriors never trailed after the game's first eight minutes and led by as many as 10 in the first half before running away in the third quarter.<BR><BR>   After the Warriors made only three 3-pointers in the first half en route to a 60-52 lead at the break, Durant buried a 26-footer on Golden State's first possession of the third period.<BR><BR>   The Warriors padded their lead with a pair of 2-point hoops, then Curry buried his consecutive 3-pointers to complete the 13-point run and open a 73-52 lead.<BR><BR>   \"Obviously, K.D. scored and Steph scored,\" Warriors coach Mike Brown said. \"But what you like about both those guys ... Steph had 10 assists. He also had six rebounds as your point guard. K.D. had eight assists and then eight rebounds.\"<BR><BR>   The Cavaliers rallied within 80-68 with 3:06 remaining in the period, but Golden State wasn't finished with its 3-point-shooting barrage. Curry and Draymond Green each connected on one in a 13-1 run that created a 93-69 advantage in the final seconds of the period.<BR><BR>   With Curry and Durant combining for 18, the Warriors had 31 assists on their 45 hoops. Green added two assists to go with nine points and a team-high 11 rebounds.<BR><BR>   The Warriors shot 42.5 percent and committed only four turnovers.<BR><BR>   James had 28 points, 15 rebounds and eight assists for Cleveland, which shot just 34.9 percent from the field.<BR><BR>   \"When you're playing a good team like this, you can't give them 20 more shots than you have,\" Cavaliers coach Tyronn Lue said. \"Having 20 turnovers and not being able to get back and get your defense set, they really take advantage of that, especially at home. They thrive off turnovers and getting out in transition.\"<BR><BR>   Kevin Love grabbed 21 rebounds to complement 15 points for the Cavaliers. Kyrie Irving had 24 points.<BR><BR>   \"Definitely a lot of things we can correct,\" Irving said. \"Twenty (turnovers) in the Finals, definitely not going to get it done.\"<BR><BR>   The Warriors not only got their 3-point shooting going in the decisive third period, but also their defense.<BR><BR>   After allowing the Cavaliers 52 points on 39.5 percent shooting in the first half, Golden State held Cleveland to 32 percent shooting and 20 points in the third period.<BR><BR>   The Cavaliers also turned the ball over four more times, giving them 16 to that point of the game.<BR><BR>   \"The best thing about tonight, obviously, was just our defensive presence and effort for 48 minutes,\" Curry said. \"We were really good in just being ourselves, playing Warriors basketball.\"<BR><BR>   NOTES: Cavaliers SF LeBron James connected on two 3-pointers, the second of which moved him past SG Reggie Miller (320) for second place on the NBA's all-time postseason list. SG Ray Allen is the all-time leader with 385. ... The Finals feature 11 current or former All-Stars, the most since the Los Angeles Lakers and Philadelphia 76ers met in 1983. ... Warriors coach Steve Kerr attended the game, met with commissioner Adam Silver, and stayed behind the scenes while continuing to deal with spinal-fluid issues. \"I know that he wanted to, if he could, try to coach Game 1,\" replacement coach Mike Brown said before the game, adding that he had no idea whether Kerr might return for Game 2. ... At his State of the NBA press conference before the game, Silver noted he is in favor of changes in the draft lottery and minimum playing age, but said he is conflicted on the paucity of competitive games this postseason featured leading into the Finals. \"The fan in me would love to see more competition at times,\" he said, \"but on the other hand, I think we should also celebrate excellence.\"";
        String[] queryss = querys.split("<BR><BR>");

        for(String query : queryss){

            String salt = String.valueOf(System.currentTimeMillis());
            String from = "en";
            String to = "zh_CHS";
            String sign = md5(appKey + query + salt + "RiaT2lqqtSr0OX12Bs2NetnDlOhtKeyA");
            Map<String, String> params = new HashMap<String, String>();
            params.put("q", query);
            params.put("from", from);
            params.put("to", to);
            params.put("sign", sign);
            params.put("salt", salt);
            params.put("appKey", appKey);
            System.out.println(HttpGet.get(getUrlWithQueryString("https://openapi.youdao.com/api", params)));
        }
//        long begin = System.currentTimeMillis();
//        for (int i = 0; i < 1000; i++) {
//            HttpGet.get(getUrlWithQueryString("https://openapi.youdao.com/api", params));
//        }
//        System.out.println(System.currentTimeMillis() - begin);
    }

    /**
     * 生成32位MD5摘要
     *
     * @param string
     * @return
     */
    public static String md5(String string) {
        if (string == null) {
            return null;
        }
        char hexDigits[] = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9',
                'A', 'B', 'C', 'D', 'E', 'F'};
        byte[] btInput = string.getBytes();
        try {
            /** 获得MD5摘要算法的 MessageDigest 对象 */
            MessageDigest mdInst = MessageDigest.getInstance("MD5");
            /** 使用指定的字节更新摘要 */
            mdInst.update(btInput);
            /** 获得密文 */
            byte[] md = mdInst.digest();
            /** 把密文转换成十六进制的字符串形式 */
            int j = md.length;
            char str[] = new char[j * 2];
            int k = 0;
            for (byte byte0 : md) {
                str[k++] = hexDigits[byte0 >>> 4 & 0xf];
                str[k++] = hexDigits[byte0 & 0xf];
            }
            return new String(str);
        } catch (NoSuchAlgorithmException e) {
            return null;
        }
    }

    /**
     * 根据api地址和参数生成请求URL
     *
     * @param url
     * @param params
     * @return
     */
    public static String getUrlWithQueryString(String url, Map<String, String> params) {
        if (params == null) {
            return url;
        }

        StringBuilder builder = new StringBuilder(url);
        if (url.contains("?")) {
            builder.append("&");
        } else {
            builder.append("?");
        }

        int i = 0;
        for (String key : params.keySet()) {
            String value = params.get(key);
            if (value == null) { // 过滤空的key
                continue;
            }

            if (i != 0) {
                builder.append('&');
            }

            builder.append(key);
            builder.append('=');
            builder.append(encode(value));

            i++;
        }

        return builder.toString();
    }

    /**
     * 进行URL编码
     *
     * @param input
     * @return
     */
    public static String encode(String input) {
        if (input == null) {
            return "";
        }

        try {
            return URLEncoder.encode(input, "utf-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

        return input;
    }
}
