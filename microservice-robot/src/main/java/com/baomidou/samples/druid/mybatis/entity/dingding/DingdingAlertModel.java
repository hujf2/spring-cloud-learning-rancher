package com.baomidou.samples.druid.mybatis.entity.dingding;

import lombok.Data;
import lombok.NonNull;
import lombok.ToString;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.Range;

import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.security.PrivateKey;
import java.util.List;

/**
 * @author junfeng.hu
 * @create 2019-11-27 19:42
 */
@Data
@ToString

public class DingdingAlertModel {
    @NotNull
    private String sign;

    private List<String> note;

    @Range(min=-100, max=100)
    @NotNull
    private Integer failureType;

    @NotEmpty(message = "failureTime不能为空")
    private String failureTime;

    @NotEmpty(message = "appName不能为空")
    private String appName;

    @NotEmpty(message = "artifactId不能为空")
    private String artifactId;

    private String atMobile;
}
