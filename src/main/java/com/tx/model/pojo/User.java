package com.tx.model.pojo;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class User {
    /**
     *
     */
    private Long id;

    /**
     * 用户名
     */
    private String username;

    /**
     *  密码
     */
    private String password;

    /**
     *  盐
     */
    private String salt;

    /**
     *  角色
     */
    private String roleId;

    /**
     *   是否锁定
     */
    private Boolean locked = Boolean.FALSE;

    public String getCredentialsSalt() {
        return username + salt;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", salt='" + salt + '\'' +
                ", locked=" + locked +
                '}';
    }

}