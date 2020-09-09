package com.example.api.aop;

import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Aspect
@Slf4j
public class TestAspect {

    @Pointcut("execution(* com.example.api.controller..*.*(..))")
    void beforeControllerEndpoint() {
    }

    @Around("beforeControllerEndpoint()")
    public void doLogController(ProceedingJoinPoint joinPoint)  throws Throwable {
        Object[] args = joinPoint.getArgs();
        if(args != null && args.length > 0){
            log.info(joinPoint.getKind()+"-"+joinPoint.getTarget()+"-"+ JSON.toJSONString(args)+
                    "-"+JSON.toJSONString(joinPoint.getSignature()));
        }
        Object result = joinPoint.proceed();
        log.info("result="+JSON.toJSONString(result));
    }


}
