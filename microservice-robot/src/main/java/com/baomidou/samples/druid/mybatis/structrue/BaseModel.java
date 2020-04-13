package com.baomidou.samples.druid.mybatis.structrue;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.io.Serializable;

/**
 * 所有模型类继承此抽象类方便打印输出
 * @Author: zhixing.he
 * @Description:
 * @Date: 2018/3/4 上午11:32
 */
public abstract class BaseModel implements Serializable {

    private String objectString;

    @Override
    public String toString() {
        String result = this.objectString;
        if(result != null){
            return result;
        }
        try {
            return ToStringBuilder.reflectionToString(this, ToStringStyle.SHORT_PREFIX_STYLE);
        } catch (Exception e) {
            return super.toString();
        }
    }
}
