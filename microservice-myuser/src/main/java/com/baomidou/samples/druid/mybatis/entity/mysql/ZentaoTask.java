package com.baomidou.samples.druid.mybatis.entity.mysql;

import lombok.Data;
import lombok.ToString;

/**
 * @author junfeng.hu
 * @create 2019-12-24 17:27
 */
@ToString
@Data
public class ZentaoTask {
    private String
            id,
    parent,
            project,
    module,
            story,
    storyVersion,
            fromBug,
    name,
            type,
    pri,
            estimate,
    consumed,
            left,
    deadline,
            status,
    subStatus,
            color,
    mailto,
            desc,
    openedBy,
            openedDate,
    assignedTo,
            assignedDate,
    estStarted,
            realStarted,
    finishedBy,
            finishedDate,
    finishedList,
            canceledBy,
    canceledDate,
            closedBy,
    closedDate,
            closedReason,
    lastEditedBy,
            lastEditedDate,
    deleted;
}


