package com.jero.web.core.config.mybatis;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.reflection.MetaObject;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

/**
 * @Description 自动填充类
 * @Author zero
 * @Date 2020/5/15
 **/
@Slf4j
@Component
public class DateMetaObjectHandler implements MetaObjectHandler {

    @Override
    public void insertFill(MetaObject metaObject) {
        try {
            LocalDateTime now = LocalDateTime.now();
            setFieldValByName("createTime", now, metaObject);
        } catch (Exception e){
            log.error("自动插入创建时间失败", e);
        }
        // TODO 添加创建人为当前登陆用户

    }

    @Override
    public void updateFill(MetaObject metaObject) {
        try {
            LocalDateTime now = LocalDateTime.now();
            setFieldValByName("updateTime", now, metaObject);
        } catch (Exception e){
            log.error("自动插入更新时间失败", e);
        }

        // TODO 添加更新人为当前登陆用户
    }
}
