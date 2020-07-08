* annotation 에 대하여   
일반적으로 어노테이션은 주석과 비슷한 역할을 한다. 그래서 컴파일이 될 때 어노테이션을 함께 읽어오지 않는다.
    * Retention 을 쓰면 주석을 불러올 수 있다. retention 설정값을 runtime으로 준다면 
    어플리케이션이 실행되는 동안 어노테이션을 불러올 수 있다.   
    * @Target 을 사용하여 어노테이션의 사용 범위를 정해줄 수 있다.   
    * 어노테이션은 값을 가질 수 있다. 하지만 primitive type과 Wrapper 까지만 가능하다.
    * @Inherited를 어노테이션에 붙여주면 하위 클래스에서도 해당 어노테이션을 사용할 수 있다.
    

* 스프링 데이터 JPA는 어떻게 동작할까?  
Repository의 interface를 어떻게 쓸 수 있는 걸까?
    * proxy class 덕분이다!  
    
    Foo f = (Foo) Proxy.newProxyInstance(Foo.class.getClassLoader(),
    new Class<?>[]{Foo.class},
    handler);  
    
    * spring AOP가 proxy factory 제공  
    조금 더 추상화 해 놓은 