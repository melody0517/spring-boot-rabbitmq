package com.sjn.producer.enums;

import lombok.Getter;

/**
 * @description: 角色信息
 * @date: 2020/10/27
 * @author: ShiJiaNan
 */
@Getter
public enum RoleEnums {

    ALL(1, "public"),
    ADMIN(2, "admin"),
    HANDLER(3, "handler"),
    UNKNOWN(4, "unknown"),
    ;

    private int code;

    private String name;

    RoleEnums(int code, String name) {
        this.code = code;
        this.name = name;
    }

    public static RoleEnums getByCode(int code) {
        for (RoleEnums enums : values()) {
            if (enums.getCode() == code) {
                return enums;
            }
        }
        return UNKNOWN;
    }
}
