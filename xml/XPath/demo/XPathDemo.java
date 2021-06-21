package xml.XPath.demo;

import cn.wanghaomiao.xpath.exception.XpathSyntaxErrorException;
import cn.wanghaomiao.xpath.model.JXDocument;
import cn.wanghaomiao.xpath.model.JXNode;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.junit.Test;

import javax.xml.xpath.XPath;
import java.io.File;
import java.io.IOException;
import java.util.List;

public class XPathDemo {

    // 使用 XPath 查询 xml 元素(查询 students.xml 中所有的 students )
    @Test
    public void demo1() throws IOException, XpathSyntaxErrorException {
        String path = XPathDemo.class.getClassLoader().getResource("xml/students.xml").getPath();
        Document document = Jsoup.parse(new File(path), "utf-8");
        JXDocument jxDocument = new JXDocument(document);
        List<JXNode> jxNodes = jxDocument.selN("//students");
        for (JXNode jxNode : jxNodes) {
            System.out.println(jxNode);
        }
    }

    // 使用 XPath 查询 xml 元素(查询 students.xml 中 id 为1 的student )
    @Test
    public void demo2() throws IOException, XpathSyntaxErrorException {
        String path = XPathDemo.class.getClassLoader().getResource("xml/students.xml").getPath();
        Document document = Jsoup.parse(new File(path), "utf-8");

        JXDocument jxDocument = new JXDocument(document);
        //  title[@lang='eng']
        List<JXNode> jxNodes = jxDocument.selN("//student[@id='1']");
        for (JXNode jxNode : jxNodes) {
            System.out.println(jxNode);
        }
    }
}
