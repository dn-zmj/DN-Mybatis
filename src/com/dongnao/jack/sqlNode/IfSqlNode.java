/** 
 * @Project     DN-jack-mybatis 
 * @File        IfSqlNode.java 
 * @Package     com.dongnao.jack.sqlNode 
 * @Version     V1.0 
 * @Date        2016年10月25日 下午10:56:49 
 * @Author      dongnao.jack 
 */

package com.dongnao.jack.sqlNode;

import java.util.List;

/** 
 * @Description TODO 
 * @ClassName   IfSqlNode 
 * @Date        2016年10月25日 下午10:56:49 
 * @Author      dongnao.jack 
 */

public class IfSqlNode implements SqlNode {
    
    private String test;
    
    private List<SqlNode> sqlNode;
    
    public boolean appendTo(DynamicContext context) {
        // TODO Auto-generated method stub
        return false;
    }
    
    public IfSqlNode(List<SqlNode> sqlNode, String test) {
        this.sqlNode = sqlNode;
        this.test = test;
    }
    
    public String getTest() {
        return test;
    }
    
    public void setTest(String test) {
        this.test = test;
    }
    
    public List<SqlNode> getSqlNode() {
        return sqlNode;
    }
    
    public void setSqlNode(List<SqlNode> sqlNode) {
        this.sqlNode = sqlNode;
    }
    
}
