package com.word.learner.itest.util;

import com.google.inject.Guice;
import com.google.inject.Injector;
import com.word.learner.itest.RegistryModule;
import com.word.learner.service.impl.ServiceRegistryModule;
import org.junit.runners.BlockJUnit4ClassRunner;
import org.junit.runners.model.FrameworkMethod;
import org.junit.runners.model.InitializationError;
import org.junit.runners.model.Statement;

public class ITestRunner extends BlockJUnit4ClassRunner {


    private final Injector injector;

    public ITestRunner(Class<?> klass) throws InitializationError {
        super(klass);
        injector = Guice.createInjector(new ServiceRegistryModule(),new RegistryModule());

    }

    @Override
    protected Object createTest() throws Exception {
        return injector.getInstance(getTestClass().getJavaClass());
    }

    @Override
    protected Statement withBefores(FrameworkMethod method, Object target, Statement statement) {
        injector.injectMembers(target);
        return super.withBefores(method, target, statement);
    }
}
