//package com.work.account.config;
//
//
//import io.seata.common.util.StringUtils;
//import io.seata.core.context.RootContext;
//import io.seata.tm.api.GlobalTransaction;
//import io.seata.tm.api.GlobalTransactionContext;
//import lombok.extern.slf4j.Slf4j;
//import org.aspectj.lang.JoinPoint;
//import org.aspectj.lang.annotation.AfterReturning;
//import org.aspectj.lang.annotation.AfterThrowing;
//import org.aspectj.lang.annotation.Aspect;
//import org.aspectj.lang.annotation.Before;
//import org.aspectj.lang.reflect.MethodSignature;
//import org.springframework.stereotype.Component;
//import org.springframework.transaction.TransactionException;
//
//import java.lang.reflect.Method;
//import java.util.Map;
//
///**
// * Seata 动态事务回滚切面类 (Feign熔断降级回滚)
// */
//@Slf4j
//@Aspect
//@Component
//public class AtFeignTransactionalAop {
//
//    @Before("execution(* com.work.account.controller.*.*(..))")
//    public void before(JoinPoint joinPoint) throws TransactionException, io.seata.core.exception.TransactionException {
//        MethodSignature signature = (MethodSignature)joinPoint.getSignature();
//        Method method = signature.getMethod();
//        log.info("拦截到需要分布式事务的方法," + method.getName());
//        GlobalTransaction tx = GlobalTransactionContext.getCurrentOrCreate();
//        // 超时时间 , 所在服务
//        tx.begin(300000, "lxtx-uc");
//        log.info("创建分布式事务id:{}", tx.getXid());
//    }
//
//    @AfterThrowing(throwing = "e", pointcut = "execution(* com.work.account.controller.*.*(..))")
//    public void doRecoveryActions(Throwable e) throws TransactionException, io.seata.core.exception.TransactionException {
//        log.info("方法执行异常:{}", e.getMessage());
//        if (!StringUtils.isBlank(RootContext.getXID())) {
//            log.info("分布式事务Id:{}, 手动回滚!", RootContext.getXID());
//            GlobalTransactionContext.reload(RootContext.getXID()).rollback();
//        }
//    }
//
//    @AfterReturning(value = "execution(* com.work.account.controller.*.*(..))", returning = "result")
//    public void afterReturning(JoinPoint point, Object result) throws TransactionException, io.seata.core.exception.TransactionException {
//        log.info("方法执行结束:{}", result);
//        // 方法返回值 RespData是自定义的统一返回类
//        Map map =new org.apache.commons.beanutils.BeanMap(result);
//        Integer status=200;
//        if(map.size()>1){
//            status=Integer.parseInt(map.get("code").toString());
//        }
//        if (status != 200) {
//            if (!StringUtils.isBlank(RootContext.getXID())) {
//                log.info("分布式事务Id:{}, 手动回滚!", RootContext.getXID());
//                GlobalTransactionContext.reload(RootContext.getXID()).rollback();
//            }
//        }
//    }
//}