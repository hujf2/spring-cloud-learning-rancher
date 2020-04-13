package com.baomidou.samples.druid.mybatis.mapper;

import com.baomidou.dynamic.datasource.annotation.DS;
import com.baomidou.samples.druid.mybatis.entity.mysql.ZentaoTask;
import com.baomidou.samples.druid.mybatis.entity.mysql.ZentaoUser;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface ZentaoTaskMapper {
  @DS("slave_1")
  @Select("SELECT account,SUM(consumed) AS consumed FROM zt_taskestimate WHERE date = #{lastEditedDate}  AND account = #{lastEditedBy}  GROUP BY account" )
  List<ZentaoTask> select(@Param("lastEditedBy") String lastEditedBy, @Param("lastEditedDate") String lastEditedDate);

  @DS("slave_1")
  @Select("select id,account,phone from zt_user where phone=#{phone} limit 1")
  ZentaoUser selectUserByPhone(@Param("phone") String phone);


}
