package com.baomidou.samples.druid.mybatis.entity.mysql;

import lombok.Data;
import lombok.ToString;

/**
 * @author junfeng.hu
 * @create 2019-12-24 17:27
 */
@ToString
@Data
public class ZentaoUser {
    private String id,
    dept,
            account,
    password,
            role,
    realname,
            nickname,
    commiter,
            avatar,
    birthday,
            gender,
    email,
            skype,
    qq,
            mobile,
    phone,
            weixin,
    dingding,
            slack,
    whatsapp,
            address,
    zipcode,
            join,
    visits,
            ip,
    last,
            fails,
    locked,
            ranzhi,
    score,
            scoreLevel,
    deleted,
            clientStatus,
    clientLang;
}