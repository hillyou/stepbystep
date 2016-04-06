/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.study.mybatis.typehandler;

import java.sql.Types;
import java.util.HashMap;
import java.util.Map;
import org.apache.ibatis.type.JdbcType;

/**
 *
 * @author Colin.You
 */
public enum MyJdbcType {

    OBJECT(Types.STRUCT);

    public final int TYPE_CODE;
    private static Map<Integer, MyJdbcType> codeLookup = new HashMap<Integer, MyJdbcType>();

    static {
        for (MyJdbcType type : MyJdbcType.values()) {
            codeLookup.put(type.TYPE_CODE, type);
        }
    }

    MyJdbcType(int code) {
        this.TYPE_CODE = code;
    }

    public static MyJdbcType forCode(int code) {
        return codeLookup.get(code);
    }
}
