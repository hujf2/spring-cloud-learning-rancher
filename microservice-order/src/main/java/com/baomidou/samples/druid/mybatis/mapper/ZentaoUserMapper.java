package com.baomidou.samples.druid.mybatis.mapper;

import com.baomidou.dynamic.datasource.annotation.DS;
import com.baomidou.samples.druid.mybatis.entity.mysql.ZentaoUser;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface ZentaoUserMapper {
  @DS("slave_1")
  @Select("select id,dept,account,role,realname,nickname,commiter,avatar,birthday,gender,email,skype,qq,mobile,phone,weixin,dingding,slack,whatsapp,address,zipcode,visits,ip,last,fails,locked,ranzhi,score,scoreLevel,deleted,clientStatus,clientLang from zt_user where deleted='0' and phone<>'' ")
  List<ZentaoUser> select(@Param("id") String id);

}
