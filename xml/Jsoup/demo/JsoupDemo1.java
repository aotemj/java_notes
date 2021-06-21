package xml.Jsoup.demo;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.net.URL;

public class JsoupDemo1 {
    // 使用 Jsoup 读取 xml 文件内容
    @Test
    public void demo1() throws IOException {
        //1.根据 xml 文档获取 对应的 document 对象
        String resource = JsoupDemo1.class.getClassLoader().getResource("xml/students.xml").getPath();
        // 解析 xml 文档，加载文档进内存，获取 dom 树  --->Document
        Document document = Jsoup.parse(new File(resource), "utf-8");
        // 获取元素对象
        Elements elements = document.getElementsByTag("name");
        // 获取单个元素
        Element element = elements.get(0);
        // 获取name 文本

        String text = element.text();
        System.out.println(text);
    }

    // Jsoup 对象功能
    @Test
    public void demo2() throws IOException {
        // 1. 使用 url 解析 document
        URL url = new URL("https://www.baidu.com");
        Document document = Jsoup.parse(url, 10000);
        System.out.println(document);
    }

    // 选择器直接获取
    @Test
    public void demo3() throws IOException {
        String path = JsoupDemo1.class.getClassLoader().getResource("xml/students.xml").getPath();
        Document document = Jsoup.parse(new File(path), "utf-8");
        Elements elements = document.select("student");
        System.out.println(elements);
    }
}
