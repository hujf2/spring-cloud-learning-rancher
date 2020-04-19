package com.baomidou.samples.druid.mybatis.entity.dingding;

import lombok.Data;
import lombok.ToString;

/**
 * @author junfeng.hu
 * @create 2019-12-25 14:05
 */
@Data
@ToString
public class ZentaoMessageEntity {
    private String webhook;
    private String json;
}
