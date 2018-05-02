/*
 * Copyright 2018-2018 https://github.com/myoss
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 */

package com.github.myoss.phoenix.mybatis.table;

import lombok.Data;
import lombok.ToString;

import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.TypeHandler;

/**
 * 数据库表结构字段信息
 *
 * @author Jerry.Chen 2018年4月26日 上午11:05:13
 */
@ToString(exclude = "tableInfo")
@Data
public class TableColumnInfo {
    /**
     * 数据库表结构信息
     */
    private TableInfo                       tableInfo;

    /**
     * 字段名
     */
    private String                          column;
    /**
     * 字段jdbc type
     */
    private JdbcType                        jdbcType;
    /**
     * 数据库字段类型转换为Java类型处理器
     */
    private Class<? extends TypeHandler<?>> typeHandler;
    /**
     * 属性名
     */
    private String                          property;
    /**
     * 属性Java类型
     */
    private Class<?>                        javaType;

    /**
     * 是否为主键字段
     */
    private boolean                         primaryKey    = false;
    /**
     * 自动地创建主键字段的值
     */
    private boolean                         autoIncrement = false;

    /**
     * 字段是否包含在 SQL INSERT statements
     * <p>
     * (Optional) Whether the column is included in SQL INSERT statements
     * generated by the persistence provider.
     */
    private boolean                         insertable    = true;
    /**
     * 字段是否包含在 SQL UPDATE statements
     * <p>
     * (Optional) Whether the column is included in SQL UPDATE statements
     * generated by the persistence provider.
     */
    private boolean                         updatable     = true;
    /**
     * 字段是否包含在 SQL SELECT statements
     * <p>
     * (Optional) Whether the column is included in SQL SELECT statements
     * generated by the persistence provider.
     */
    private boolean                         selectable    = true;

    /**
     * 逻辑删除数据，软删除，用字段标记数据被删除了，不做物理删除
     */
    private boolean                         logicDelete   = false;
    /**
     * 数据标记为"逻辑删除"的值
     */
    private String                          logicDeleteValue;
    /**
     * 数据标记为"逻辑未删除"的值
     */
    private String                          logicUnDeleteValue;

}
