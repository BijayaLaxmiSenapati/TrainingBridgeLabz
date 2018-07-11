package com.bridgelabz.reflection;

import com.bridgelabz.reflection.ReflectionServiceImplentation;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

public class ReflectionTest {

	public static void main(String[] args) {
		Class reflectClass = ReflectionServiceImplentation.class;
		// to print Fully Qualified Class Name
		System.out.println("Fully Qualified Class Name ->" + reflectClass + "\n");
		// to print class name
		String className = reflectClass.getSimpleName();
		System.out.println("class name : " + className + "\n");
		// to find modifiers
		int classCodifire = reflectClass.getModifiers();
		System.out.println("Is Public modifire ? " + Modifier.isPublic(classCodifire));
		System.out.println("Is Protected modifire ? " + Modifier.isProtected(classCodifire));
		System.out.println("Is Private modifire ? " + Modifier.isPrivate(classCodifire));
		System.out.println("Is Abstract ? " + Modifier.isAbstract(classCodifire));
		System.out.println("Is FINAL ? " + Modifier.isFinal(classCodifire));
		System.out.println("Is Interface ? " + Modifier.isInterface(classCodifire));
		System.out.println();
		// To print Interface name
		Class[] interfaces = reflectClass.getInterfaces();
		for (int i = 0; i < interfaces.length; i++) {
			System.out.println("Interface name is :" + interfaces[i].getSimpleName());
		}
		// to get methods
		Method[] methods = reflectClass.getMethods();
		for (int i = 0; i < methods.length; i++) {
			System.out.println("methods -> " + methods[i].getName());
			if (methods[i].getName().startsWith("set"))
				System.out.println("it is setter method" + methods[i].getName());
			if (methods[i].getName().startsWith("get"))
				System.out.println("it is getter method " + methods[i].getName());
			// to get return type
			System.out.println("return type " + methods[i].getGenericReturnType());
			// to get parameter types
			Class[] parameterTypes = methods[i].getParameterTypes();
			for (Class parameter : parameterTypes) {
				System.out.println("parameter types " + parameter.getName());
			}
			System.out.println();
		}
		// to get constructors and parameter count
		Constructor[] constructor = null;
		Object construct = null;
		constructor = reflectClass.getConstructors();
		constructor = reflectClass.getConstructors();
		for (Constructor constructor2 : constructor) {
			System.out.println(constructor2.getName());
			System.out.println(constructor2.getParameterCount());
		}
		try {
			construct = reflectClass.getConstructor(int.class, String.class).newInstance(7, "yuga here");
		} catch (InstantiationException | IllegalAccessException | IllegalArgumentException | InvocationTargetException
				| NoSuchMethodException | SecurityException e) {
			e.printStackTrace();
		}
		System.out.println();
		// to set value of private variable
		ReflectionServiceImplentation refference = new ReflectionServiceImplentation("GOOD EVENING");
		try {
			Field privateStringField = ReflectionServiceImplentation.class.getDeclaredField("message");
			privateStringField.setAccessible(true);
			String fieldValue = (String) privateStringField.get(refference);
			System.out.println("fieldValue = " + fieldValue);
		} catch (NoSuchFieldException | SecurityException | IllegalArgumentException | IllegalAccessException e) {
			e.printStackTrace();
		}
	}

}
