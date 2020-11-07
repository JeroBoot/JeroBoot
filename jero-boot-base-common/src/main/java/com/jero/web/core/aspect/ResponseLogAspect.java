package com.jero.web.core.aspect;

import com.jero.common.utils.GsonUtils;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * 全局日志处理
 *
 * @author zero
 * @date 2020-03-25
 */
@Aspect
@Component
public class ResponseLogAspect {

    private static final Logger LOGGER = LoggerFactory.getLogger(ResponseLogAspect.class);

    /**
     * 匹配controller层的方法
     */
    @Pointcut(value = "(execution(* com.jero.*.rest.*.*(..)))")
    private void controllerPointcut() {
        // 切面方法
    }

    @Around(value = "controllerPointcut()")
    public Object process(ProceedingJoinPoint joinPoint) throws Throwable {
        Object result = joinPoint.proceed();
        LOGGER.info("==================== 调用Controller层返回json值 ====================");
        LOGGER.info(GsonUtils.toJson(result));
        return result;
    }

}
