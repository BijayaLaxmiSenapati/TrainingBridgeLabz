package com.bridgelabz.spring.aspectclasses;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class AllAdvise 
{
	//pointcut applied for all the classes inside the given package
	@Pointcut("execution(* com.bridgelabz.spring.service.*.*(..))")
	public void fPointCut() {
		
	}
	
	@Before("fPointCut()")
	public void beforeMethod(JoinPoint jp) {
		System.out.println("In beforeMethod");
	}
	
	@After("fPointCut()")
	public void afterMethod(JoinPoint jp) {
		System.out.println("In afterMethod");
	}
	
	@AfterReturning(pointcut="fPointCut()",returning="result")//check whether without pointcut expression it works or not
	public void afterReturningMethod(JoinPoint jp,Object result) {
		System.out.println("In afterReturningMethod");//print some msg
		System.out.println("Method Signature: "  + jp.getSignature());  
        System.out.println("Result in advice: "+result); 
        System.out.println("end of afterReturningMethod...");  
	}
	
	/*//pointcut applied for all the classes inside the given package
	@Pointcut("execution(* com.bridgelabz.spring.service.Operation.msg(..))")
	public void sPointCut() {
		
	}
	
	@Around("sPointCut")
	public Object aroundMethod(ProceedingJoinPoint pjp) throws Throwable
	{
		 System.out.println("(in aroundMethod)Additional Concern Before calling actual method");  
	     Object obj=pjp.proceed();  
	     System.out.println("(in aroundMethod)Additional Concern After calling actual method");  
	     return obj;  
	}*/
	
	
	@AfterThrowing(pointcut="execution(* com.bridgelabz.spring.service.*.*(..))", throwing="error")
	public void afterThrowingMethod(JoinPoint jp, Throwable error)
	{
		  System.out.println("In afterThrowingMethod");  
	      System.out.println("Method Signature: "  + jp.getSignature());  
	      System.out.println("Exception is: "+error);  
	      System.out.println("end of afterThrowingMethod...");  
	}
	
}
