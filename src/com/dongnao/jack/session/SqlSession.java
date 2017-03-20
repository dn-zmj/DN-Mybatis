/** 
 * @Project     DN-jack-mybatis 
 * @File        SqlSession.java 
 * @Package     com.dongnao.jack.session 
 * @Version     V1.0 
 * @Date        2016年10月25日 下午9:34:57 
 * @Author      dongnao.jack 
 */

package com.dongnao.jack.session;

import java.sql.Connection;

/** 
 * @Description 实际上就是增删改查 
 * @ClassName   SqlSession 
 * @Date        2016年10月25日 下午9:34:57 
 * @Author      dongnao.jack 
 */

public interface SqlSession {
    
    <T> T selectOne(String sql);
    
    <T> T selectOne(String sql, Object param);
    
    int insert(String sql);
    
    int insert(String sql, Object param);
    
    int update(String sql);
    
    int update(String sql, Object param);
    
    int delete(String sql);
    
    int delete(String sql, Object param);
    
    void commit();
    
    void rollback();
    
    Connection getConnection();
}
