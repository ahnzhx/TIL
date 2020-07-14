package com.java.inflearnJava;

public class ClassLoaderTest {
    public static void main(String[] args) {
        ClassLoader classLoader= ClassLoaderTest.class.getClassLoader();

        System.out.println(classLoader);

        System.out.println(classLoader.getParent());

        // native로 구현되어 있어서 값이 있긴 있지만 null로 나온다.
        System.out.println(classLoader.getParent().getParent());

        // 결과
        // jdk.internal.loader.ClassLoaders$AppClassLoader@512ddf17
        // jdk.internal.loader.ClassLoaders$PlatformClassLoader@6be46e8f
        // null

    }
}
