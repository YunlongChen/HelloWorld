package com.practice.stan.ConvinientApp.tools;

import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Text;
import org.xml.sax.SAXException;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.TransformerFactoryConfigurationError;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

/**
 * Created by W519L on 2017/11/28.
 */

public class XMLStore {
    private static XMLStore mXmlStore = new XMLStore();
    private String mstrConfigPath;

    public static XMLStore GetInstance(){
        return mXmlStore;
    }
    //设置保存位置
    public void setSaveplace(String saveplace){
        mstrConfigPath=saveplace;
    }

    //写如xml
    public boolean writeXML(String strContent ,String strFileName)
    {
        File pathFile = new File(mstrConfigPath);
        if (mstrConfigPath.length() <= 0 || !pathFile.exists()) {
            return false;
        }

        DocumentBuilderFactory dbfFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder dbBuilder = null;
        try {
            dbBuilder = dbfFactory.newDocumentBuilder();
        } catch (Exception e) {
            return false;
        }

        Document doc = dbBuilder.newDocument();

        //创建根元素“Custom”
        org.w3c.dom.Element root = doc.createElement("Custom");
        doc.appendChild(root);

        // 名称信息
        org.w3c.dom.Element configNode = doc.createElement("Name");
        root.appendChild(configNode);
        Text configValue = doc.createTextNode(String.format("%s", strContent));
        configNode.appendChild(configValue);

        //将xml写成文件
        Transformer trans;
        try {
            trans = TransformerFactory.newInstance().newTransformer();
            trans.setOutputProperty("indent", "yes");
            trans.transform(new DOMSource(doc), new StreamResult(new FileOutputStream(mstrConfigPath + "/" + strFileName)));

            return true;
        } catch (TransformerConfigurationException e) {
            e.printStackTrace();
        } catch (TransformerFactoryConfigurationError e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (TransformerException e) {
            e.printStackTrace();
        }
        return false;
    }

    //读取xml
    public String readXML(String strFileName)
    {
        File pathFile = new File(mstrConfigPath);
        if (!pathFile.exists()) {
            return "";
        }

        String strName = "";

        DocumentBuilderFactory dbfFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder dbBuilder = null;
        try {
            dbBuilder = dbfFactory.newDocumentBuilder();
        } catch (Exception e) {
            return "";
        }

        File inFile = new File(mstrConfigPath, strFileName);
        Document doc = null;
        try {
            inFile.createNewFile();

            doc = dbBuilder.parse(inFile);
        } catch (SAXException e) {
            e.printStackTrace();
            return "";
        } catch (IOException e) {
            e.printStackTrace();
            return "";
        }

        org.w3c.dom.Element root = doc.getDocumentElement();

        //获取内容
        NodeList configNodes = root.getElementsByTagName("Name");
        Text configValue = null;
        if (configNodes.getLength() == 1) {
            configValue = (Text) configNodes.item(0).getFirstChild();
            strName = configValue.getNodeValue();
        }

        return strName;
    }
}
