// package com.cott.gmail.bootorderserviceconsumer;

// import com.alibaba.dubbo.config.spring.context.annotation.EnableDubbo;
// import org.springframework.boot.SpringApplication;
// import org.springframework.boot.autoconfigure.SpringBootApplication;

// @EnableDubbo
// @SpringBootApplication
// public class BootOrderServiceConsumerApplication {

//     public static void main(String[] args) {
//         SpringApplication.run(BootOrderServiceConsumerApplication.class, args);
//     }

// }
package com.fenbeitong.openapi.chart.web.controller;

import com.fenbeitong.base.result.GenericListResult;
import com.fenbeitong.openapi.chart.service.SyncOpenControllerService;
import com.fenbeitong.server.plugin.mongodb.dao.OpenApiStatisticsDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * OpenAPI接口统计
 *
 * @author ctl
 * @date 2023/1/16
 */
@RestController
@RequestMapping("/job")
public class OpenApiStatisticsController {

    @Autowired
    private SyncOpenControllerService syncOpenControllerService;

    @Autowired
    private OpenApiStatisticsDao openApiStatisticsDao;

    /**
     * 接口同步任务
     *
     * @return 成功响应
     */
    @GetMapping("/url/sync")
    public GenericListResult<?> syncRestController() {
        syncOpenControllerService.sync();
        return GenericListResult.success();
    }

}
