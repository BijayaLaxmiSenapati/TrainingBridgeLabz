package com.bridgelabz.reflection;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.TypeVariable;
import java.util.Arrays;

//import com.mysql.cj.core.result.Field;

public class ReflectionCheck {

	public static void main(String[] args) 
	{
		/*// Get Class using reflection
		Class<?> concreteClass = ConcreteClass.class;
		System.out.println("1"+concreteClass);
		concreteClass = new ConcreteClass(5).getClass();
		System.out.println("2"+concreteClass);
		try {
			concreteClass = Class.forName("reflection.ConcreteClass");
			System.out.println("3"+concreteClass);

		} catch (ClassNotFoundException e) {
			//e.printStackTrace();
		}
		System.out.println("4"+concreteClass);
*/
		Class c;
		try
		{
			Constructor constructor=Class.forName("com.bridgelabz.reflection.ConcreteClass").getConstructor(int.class);
			//System.out.println(Arrays.toString(constructor.getParameterTypes()));
			Object obj=constructor.newInstance(10);
			Method method=obj.getClass().getMethod("method1", null);
			System.out.println(method);
			method.invoke(obj, null);
		}
		catch (ClassNotFoundException | SecurityException | IllegalArgumentException | NoSuchMethodException | InstantiationException | IllegalAccessException | InvocationTargetException e) 
		{
			e.printStackTrace();
		}
		
	}
}
