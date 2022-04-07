package web_crawler;

import cn.hutool.core.io.FileUtil;
import cn.hutool.core.util.EscapeUtil;
import cn.hutool.http.HttpUtil;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.io.File;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author Fang
 * @date 2022-04-07 21:45
 */
public class GetQuestion {
    public static void downQuestion(String[] args) throws InterruptedException {
        int p = 3446;
        int max = 3561;
        for (int i = 77; p <= max; ) {
            String url = "http://www.amoscloud.com/?p=" + p;
            String html = HttpUtil.get(url);
            if (html.contains("<a href=\"http://www.amoscloud.com/?cat=57\">德科机试一星题</a>")) {
                FileUtil.appendString(html, new File("deke/第" + i + "题.html"), "utf-8");
                i++;
                System.out.println("read" + p);
            }
            p++;
        }
    }


    public static void main(String[] args) {
        List<File> files = FileUtil.loopFiles(new File("D:\\Roy_Github\\Roy\\deke"));


        for (File file : files) {
            String regEx = "[^0-9]";
            Pattern p = Pattern.compile(regEx);
            Matcher m = p.matcher(file.getName());
            String num = m.replaceAll("").trim();

            String result = FileUtil.readString(file, StandardCharsets.UTF_8);
            Document doc = Jsoup.parse(result);
            Elements code = doc.getElementsByTag("code");
            String unescape = EscapeUtil.unescapeHtml4(code.html());
            StringBuilder html = new StringBuilder(unescape);
            int public_class = html.indexOf("public class") + "public class".length();
            int first = html.indexOf("{");
            String name = "Question_" + num;
            html = html.replace(public_class, first, " " + name);
            FileUtil.writeString(html.toString(), new File("od/" + name + ".java"), StandardCharsets.UTF_8);
        }

    }

}
