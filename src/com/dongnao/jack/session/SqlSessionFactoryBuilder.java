/** 
 * @Project     DN-jack-mybatis 
 * @File        SqlSessionFactoryBuilder.java 
 * @Package     com.dongnao.jack.session 
 * @Version     V1.0 
 * @Date        2016年10月25日 下午9:33:05 
 * @Author      dongnao.jack 
 */

package com.dongnao.jack.session;

import java.io.InputStream;

import com.dongnao.jack.parser.XMLConfigParser;
import com.dongnao.jack.configTemplate.Configuration;

/** 
 * @Description 1、解析xml 2、创建SqlSessionFactory返回
 * @ClassName   SqlSessionFactoryBuilder 
 * @Date        2016年10月25日 下午9:33:05 
 * @Author      dongnao.jack 
 */

public class SqlSessionFactoryBuilder {
    
    SqlSessionFactory build(String path) {
        
        InputStream is = SqlSessionFactoryBuilder.class.getResourceAsStream(path);
        
        XMLConfigParser parse = new XMLConfigParser();
        
        try {
            Configuration config = parse.parse(is);
        }
        catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        
        //2、创建我们的SqlSessionFactory对象
        return null;
    }
}
