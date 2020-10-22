package com.example.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class MyDemoLoggingAspect {
	
	@Pointcut("execution(* com.example.aopdemo.dao.*.*(..))")
	private void forDaoPackage() {}
	
	@Pointcut("execution(* com.example.aopdemo.dao.*.get*(..))")
	private void getter() {}
	
	@Pointcut("execution(* com.example.aopdemo.dao.*.set*(..))")
	private void setter() {}
	
	@Pointcut("forDaoPackage() && !(getter() || setter())")
	private void forDaoPackageNoGetterSetter() {}
	
	@Before("forDaoPackageNoGetterSetter()")
	public void beforeAddAccount() {
		System.out.println("Executing @before advice on addAccount()");
	}
}
