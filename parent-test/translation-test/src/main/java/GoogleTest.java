/*
 * 文件名称: GoogleTest.java
 * 版权信息: Copyright 2016-2020 technology Co., LTD. All right reserved.
 * ----------------------------------------------------------------------------------------------
 * 修改历史:
 * ----------------------------------------------------------------------------------------------
 * 修改原因: 新增
 * 修改人员: Kevin
 * 修改日期: 2017/7/7
 * 修改内容: 
 */

import com.google.cloud.translate.Translate;
import com.google.cloud.translate.TranslateOptions;
import com.google.cloud.translate.Translation;

/**
 * @author Kevin created on 2017/7/7.
 * @since framework 1.0
 */
public class GoogleTest {
    public static void main(String... args) throws Exception {
        // Instantiates a client
        Translate translate = TranslateOptions.getDefaultInstance().getService();

        // The text to translate
        String text = "Hello, world!";

        // Translates some text into Russian
        Translation translation =
                translate.translate(
                        text,
                        Translate.TranslateOption.sourceLanguage("en"),
                        Translate.TranslateOption.targetLanguage("zh-CN"));


        System.out.printf("Text: %s%n", text);
        System.out.printf("Translation: %s%n", translation.getTranslatedText());
    }
}
