package com.baomidou.samples.druid.mybatis.entity.dingding;

import lombok.Data;
import lombok.ToString;

/**
 * @author junfeng.hu
 * @create 2019-11-28 13:57
 */
@Data
@ToString
public class TDingDingAlert {
    private String sign;
    private Integer failure_type;
    private Long failure_time;
    private String note;
    private String app_name;
    private String artifact_id;
    private Integer pk_id;
    private Long create_time;
    private String update_time;
}
