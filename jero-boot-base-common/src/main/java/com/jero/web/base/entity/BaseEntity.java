package com.jero.web.base.entity;

import com.baomidou.mybatisplus.extension.activerecord.Model;

/**
 * @Description 基础实体，提供所有的实体类继承
 * @Author lixuetao
 * @Date 2020/3/25
 **/
public class BaseEntity<T extends BaseEntity<?>> extends Model<BaseEntity<T>> {

    public BaseEntity(){}

    @Override
    public String toString(){
        return "BaseEntity()";
    }

    @Override
    public boolean equals(Object o) {
        if (o == this) {
            return true;
        } else if (!(o instanceof BaseEntity)) {
            return false;
        } else {
            BaseEntity<?> other = (BaseEntity)o;
            return other instanceof BaseEntity;
        }
    }

}
