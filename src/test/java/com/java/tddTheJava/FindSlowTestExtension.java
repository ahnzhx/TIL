package com.java.tddTheJava;


import org.junit.jupiter.api.extension.AfterTestExecutionCallback;
import org.junit.jupiter.api.extension.BeforeTestExecutionCallback;
import org.junit.jupiter.api.extension.ExtensionContext;

public class FindSlowTestExtension implements BeforeTestExecutionCallback, AfterTestExecutionCallback {

    @Override
    public void beforeTestExecution(ExtensionContext context) throws Exception {
        // store : 데이타 저장 및 get
        context.getStore(ExtensionContext.Namespace.create(  ));
    }

    @Override
    public void afterTestExecution(ExtensionContext context) throws Exception {

    }


}
