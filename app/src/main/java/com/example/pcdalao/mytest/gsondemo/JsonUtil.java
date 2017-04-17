package com.example.pcdalao.mytest.gsondemo;

/**
 * Created by pcdalao on 2017/2/15.
 * APP语言包Json转换工具类
 *
 * 将特定形式的Json文件转换为Android中所需的xml文件
 */
public class JsonUtil {

    String jsonString;
    int flag = 0;
    String language;

    public String parseJsonToXml(String jsonString, String language) {
        StringBuilder xmlString = new StringBuilder();
        xmlString.append("<resources>\n");
        this.jsonString = jsonString;

        this.language = language;
        while (flag +10 < jsonString.length()) {
            String key = parseKey(jsonString);
            String value = parseValue(jsonString);
            xmlString.append(itemBuild(key, value));
            toNextItem();
        }
        xmlString.append("</resources>");
        return xmlString.toString();
    }

    private void toNextItem() {
        while (true) {
            if (jsonString.charAt(flag) == '}') {
                break;
            } else {
                flag++;
            }
        }
    }

    private String parseKey(String jsonString) {
        while (true) {
            if (jsonString.charAt(flag) == '"') {
                flag++;

                //如果出现value为空的情况则直接返回空String
                if (jsonString.charAt(flag) == '"'){
                    flag++;
                    return "";
                }

                StringBuilder key = new StringBuilder();
                while (true) {
                    key.append(jsonString.charAt(flag));
                    flag++;
                    if (jsonString.charAt(flag) == '"') {
                        break;
                    }
                }
                flag++;
                return key.toString();
            }
            flag++;
        }
    }

    private String parseValue(String jsonString) {
        while (true) {
            if (confirmLanguage(jsonString)) {
                return parseKey(jsonString);
            }
        }
    }

    private boolean confirmLanguage(String jsonString) {
        String languageName = parseKey(jsonString);
        return languageName.equals(language);
    }

    private String itemBuild(String key, String value) {
        return "<string name=" +
                '"' +
                key +
                '"' +
                ">" +
                value +
                "</string>\n";
    }

}
