package com.bridgelabz.annotation;
import java.lang.annotation.*;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;
import java.lang.reflect.Method;

@Retention(RetentionPolicy.RUNTIME)  
@Target(ElementType.METHOD)  
@interface MyAnnotation
{  
int value();  
}  
  
class Hello 
{
	@MyAnnotation(value=10)
	public void sayHello()
	{
		System.out.println("HELLO ANNOTATION");
	}
}

class TestCustomAnnotation
{
	public static void main(String[] args) 
	{
		Hello h=new Hello();
		try 
		{
			Method method=h.getClass().getMethod("sayHello");
			MyAnnotation manno=method.getAnnotation(MyAnnotation.class);
			System.out.println(manno.value());
		} 
		catch (NoSuchMethodException e)
		{
			e.printStackTrace();
		} 
		catch (SecurityException e)
		{
			e.printStackTrace();
		}
	}
}
