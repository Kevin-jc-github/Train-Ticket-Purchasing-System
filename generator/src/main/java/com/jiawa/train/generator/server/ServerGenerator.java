package com.jiawa.train.generator.server;

import org.dom4j.Document;
import org.dom4j.Node;
import org.dom4j.io.SAXReader;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

public class ServerGenerator {
    static String toPath = "generator" + File.separator + "src" + File.separator + "main" + File.separator + "java" + File.separator + "com" + File.separator + "jiawa" + File.separator + "train" + File.separator + "generator" + File.separator + "test" + File.separator;
    static String pomPath = "generator" + File.separator + "pom.xml";
    static {
        new File(toPath).mkdirs();
    }

    public static void main(String[] args) throws Exception {
        SAXReader saxReader = new SAXReader();
        Map<String, String> map = new HashMap<String, String>();
        map.put("pom", "http://maven.apache.org/POM/4.0.0");
        saxReader.getDocumentFactory().setXPathNamespaceURIs(map);
        Document document = saxReader.read(pomPath);
        Node node = document.selectSingleNode("//pom:configurationFile");
        System.out.println(node.getText());

        // FreemarkerUtil.initConfig("test.ftl");
        // Map<String, Object> param = new HashMap<>();
        // param.put("domain", "Test1");
        // FreemarkerUtil.generator(toPath + "Test1.java", param);
    }
}