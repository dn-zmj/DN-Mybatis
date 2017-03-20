/** 
 * @Project     DN-jack-mybatis 
 * @File        XMLMapperParser.java 
 * @Package     com.dongnao.jack.parser 
 * @Version     V1.0 
 * @Date        2016年10月25日 下午9:58:33 
 * @Author      dongnao.jack 
 */

package com.dongnao.jack.parser;

import java.io.InputStream;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import com.dongnao.jack.configTemplate.Configuration;
import com.dongnao.jack.configTemplate.MappedStatement;

/** 
 * @Description 解析具体的mapperxml文件 
 * @ClassName   XMLMapperParser 
 * @Date        2016年10月25日 下午9:58:33 
 * @Author      dongnao.jack 
 */

public class XMLMapperParser {
    
    public void parse(Node node, Configuration cf) throws Exception {
        
        if (node == null) {
            throw new RuntimeException("node节点不能为空！");
        }
        
        if (!node.hasChildNodes()) {
            throw new RuntimeException("node下面没有需要解析的mapper！");
        }
        
        NodeList nl = node.getChildNodes();
        
        for (int i = 0; i < nl.getLength(); i++) {
            Node item = nl.item(i);
            
            if (item.getNodeType() != Node.ELEMENT_NODE) {
                continue;
            }
            MappedStatement ms = parseMapper(item, cf);
        }
        
    }
    
    private MappedStatement parseMapper(Node node, Configuration cf)
            throws Exception {
        if (!node.hasAttributes()) {
            return new MappedStatement();
        }
        
        String resource = XMLParseUtil.getAttrValueByName(node, "resource");
        parse(resource, cf);
        return null;
    }
    
    private void parse(String url, Configuration cf) throws Exception {
        
        if (url == null) {
            throw new RuntimeException("mapper里面没有resource属性");
        }
        
        InputStream is = XMLMapperParser.class.getResourceAsStream(url);
        
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        
        DocumentBuilder builder = factory.newDocumentBuilder();
        
        Document dc = builder.parse(is);
        
        NodeList nl = dc.getChildNodes();
        
        XMLStatementParser statementParser = new XMLStatementParser();
        
        for (int i = 0; i < nl.getLength(); i++) {
            Node n = nl.item(i);
            
            if (n.getNodeType() != Node.ELEMENT_NODE) {
                continue;
            }
            
            String ns = XMLParseUtil.getAttrValueByName(n, "namespace");
            
            NodeList chlidNodes = n.getChildNodes();
            
            for (int j = 0; j < chlidNodes.getLength(); j++) {
                Node childNode = chlidNodes.item(j);
                
                if (childNode.getNodeType() != Node.ELEMENT_NODE) {
                    continue;
                }
                
                if ("select".equals(childNode.getNodeName().toLowerCase())
                        || "insert".equals(childNode.getNodeName()
                                .toLowerCase())
                        || "delete".equals(childNode.getNodeName()
                                .toLowerCase())
                        || "update".equals(childNode.getNodeName()
                                .toLowerCase())) {
                    statementParser.parse(childNode, cf, ns);
                }
                else if ("resultmap".equals(childNode.getNodeName()
                        .toLowerCase())) {
                    
                }
            }
        }
        
    }
}
