package web_crawler;

import cn.hutool.core.io.FileUtil;
import cn.hutool.http.HttpUtil;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.io.File;
import java.nio.charset.Charset;
import java.util.List;

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
            if (html.contains("<a href=\"http://www.amoscloud.com/?cat=57\">德科机试一星题</a>")){
                FileUtil.appendString(html, new File("deke/第"+ i + "题.html" ), "utf-8");
                i++;
                System.out.println("read" + p);
            }
            p++;
        }
    }


    public static void main(String[] args) {
        List<File> files = FileUtil.loopFiles(new File("D:\\Roy_Github\\Roy\\deke"));
        System.out.println(files.size());
        for (int i = 0; i < files.size(); i++) {
            String result = FileUtil.readString(files.get(i), Charset.forName("UTF-8"));
            Document doc = Jsoup.parse(result);
            Elements code = doc.getElementsByTag("code");
            if (i == 0) {
                System.out.println(code.html());
            }
        }


    }

}
