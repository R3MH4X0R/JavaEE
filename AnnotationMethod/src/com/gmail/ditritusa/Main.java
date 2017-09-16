package com.gmail.ditritusa;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Main {

	public static void main(String[] args)
			throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {

		Sum sumOne = new Sum();
		Class<?> cls = sumOne.getClass();

		Method[] methods = cls.getDeclaredMethods();

		for (Method m : methods) {
			if (m.isAnnotationPresent(MyAnnotation.class)) {
				MyAnnotation myAnnotation = m.getAnnotation(MyAnnotation.class);
				int res = (Integer) m.invoke(sumOne, myAnnotation.a(), myAnnotation.b());
				System.out.println(res);

			}

		}

	}

}
