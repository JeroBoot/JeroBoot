package com.jero.web.core.config.mybatis;

import com.baomidou.mybatisplus.core.incrementer.IdentifierGenerator;
import com.jero.snowflake.impl.DefaultUidGenerator;
import org.springframework.stereotype.Component;

@Component
public class SnowFlakeGenerator implements IdentifierGenerator {

    @Override
    public Number nextId(Object entity) {
        return DefaultUidGenerator.getUidGenerator().getUID();
    }

}
