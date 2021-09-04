package tk.shenyifeng.study.config;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import tk.shenyifeng.study.bean.DatabaseSelector;

import java.lang.reflect.Method;

@Slf4j
@Aspect
@Component
@Order(1)
public class DatabaseAopPointCut {


    @Around("@annotation(tk.shenyifeng.study.bean.DatabaseSelector)")
    public Object setDynamicDataSource(ProceedingJoinPoint pjp) throws Throwable {
        boolean clear = true;
        try {
            MethodSignature signature = (MethodSignature) pjp.getSignature();
            Method method = signature.getMethod();
            DatabaseSelector databaseSelector = method.getAnnotation(DatabaseSelector.class);
            clear = databaseSelector.clear();
            log.info("set cluster db => {}",databaseSelector.value().name());
            DataSourceContextHolder.setEnum(databaseSelector.value());
            return pjp.proceed();
        }finally {
            if (clear)
                DataSourceContextHolder.remove();
        }
    }
}
