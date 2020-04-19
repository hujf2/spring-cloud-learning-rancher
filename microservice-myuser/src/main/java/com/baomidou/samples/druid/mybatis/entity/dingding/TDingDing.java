package com.baomidou.samples.druid.mybatis.entity.dingding;

import lombok.Data;
import lombok.ToString;

/**
 * @author junfeng.hu
 * @create 2019-11-28 13:57
 */
@Data
@ToString
public class TDingDing {
    private String sign;
    private String api_version;
    private String project_name;
    private String city;
    private String webhook;
    private String at_mobile;
    private Integer enabled;
    private Integer intervals;
    private Integer is_del;
}
