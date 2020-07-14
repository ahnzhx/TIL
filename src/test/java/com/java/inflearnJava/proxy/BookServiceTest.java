package com.java.inflearnJava.proxy;

import net.bytebuddy.ByteBuddy;
import net.bytebuddy.implementation.InvocationHandlerAdapter;
import org.junit.jupiter.api.Test;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

import static net.bytebuddy.matcher.ElementMatchers.named;


public class BookServiceTest {

//    @Test
//    public void making_proxy_without_interface_using_CGlib(){
//        MethodInterceptor handler = new MethodInterceptor() {
//            BookServiceClass bookServiceClass = new BookServiceClass();
//            @Override
//            public Object intercept(Object o, Method method, Object[] args, MethodProxy methodProxy) throws Throwable {
//                if(method.getName().equals("rent")){
//                    System.out.println("starting comment");
//                    Object invoke = method.invoke(bookServiceClass, args);
//                    System.out.println("ending comment");
//                    return invoke;
//                }
//
//                return method.invoke(bookServiceClass, args);
//            }
//        };
//        BookServiceClass bookServiceClass = (BookServiceClass) Enhancer.create(BookServiceClass.class, handler);
//
//        Book book = new Book();
//        book.setName("Spring");
//        bookServiceClass.rent(book);
//        bookServiceClass.returnBook(book);
//    }

    @Test
    public void making_proxy_without_interface_using_byteBuddy() throws Exception {
        Class<? extends BookServiceClass> proxyClass = new ByteBuddy().subclass(BookServiceClass.class)
                .method(named("returnBook")).intercept(InvocationHandlerAdapter.of(new InvocationHandler() {

                    BookServiceClass bookServiceClass = new BookServiceClass();
                    @Override
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                        System.out.println("head test.");
                        Object invoke = method.invoke(bookServiceClass, args);
                        System.out.println("tail test.");
                        return invoke;
                    }
                }))
                .make().load(BookServiceClass.class.getClassLoader()).getLoaded();

        //클래스 오브젝트에서 인스턴스를 만드는 방법
        BookServiceClass bookServiceClass = proxyClass.getConstructor(null).newInstance();

        Book book = new Book();
        book.setName("Spring");
        bookServiceClass.rent(book);
        bookServiceClass.returnBook(book);
    }
}