package com.jero.web.base.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;

/**
 * @Description 基础实体，提供所有的实体类继承
 * @Author zero
 * @Date 2020/3/25
 **/
@Data
public class BaseEntity<T extends BaseEntity<?>> extends Model<BaseEntity<T>> {

    @TableId("id")
    @ApiModelProperty(value = "ID")
    private Long id;

    @ApiModelProperty(value = "创建人(自动生成)，存用户名")
    private String createBy;

    // 创建时间
    @ApiModelProperty(value = "创建时间")
    @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime createTime;

    // 更新人，存用户名
    @ApiModelProperty(value = "更新人(自动生成)，存用户名")
    private java.lang.String updateBy;

    // 更新时间
    @ApiModelProperty(value = "更新时间")
    @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime updateTime;

}
