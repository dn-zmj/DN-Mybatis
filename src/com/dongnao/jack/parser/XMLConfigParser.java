/** 
 * @Project     DN-jack-mybatis 
 * @File        XMLConfigParser.java 
 * @Package     com.dongnao.jack 
 * @Version     V1.0 
 * @Date        2016年10月25日 下午9:42:16 
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
import com.dongnao.jack.parser.XMLMapperParser;

/** 
 * @Description configuration解析类 
 * @ClassName   XMLConfigParser 
 * @Date        2016年10月25日 下午9:42:16 
 * @Author      dongnao.jack 
 */

public class XMLConfigParser {
    
    public Configuration parse(InputStream is) throws Exception {
        
        Configuration config = parseConfiguration(is);
        
        return config;
    }
    
    private Configuration parseConfiguration(InputStream is) throws Exception {
        
        Configuration config = new Configuration();
        
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        
        DocumentBuilder builder = factory.newDocumentBuilder();
        
        Document dc = builder.parse(is);
        
        NodeList nl = dc.getChildNodes();
        
        XMLMapperParser mapperParser = new XMLMapperParser();
        
        for (int i = 0; i < nl.getLength(); i++) {
            Node node = nl.item(i);
            
            if (node.getNodeType() != Node.ELEMENT_NODE) {
                continue;
            }
            
            if ("configuration".equals(node.getNodeName())) {
                NodeList childNodes = node.getChildNodes();
                
                for (int j = 0; j < childNodes.getLength(); j++) {
                    Node chlid = childNodes.item(i);
                    if (chlid.getNodeType() != Node.ELEMENT_NODE) {
                        continue;
                    }
                    
                    if ("mappers".equals(chlid.getNodeName())) {
                        mapperParser.parse(chlid, config);
                    }
                }
                
            }
        }
        
        return null;
    }
    
}
