package com.word.learner.itest;

import com.google.inject.AbstractModule;
import com.google.inject.Provides;
import com.word.learner.service.api.IWordRecordService;

import javax.inject.Singleton;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.HashMap;
import java.util.Map;

public class RegistryModule extends AbstractModule {
    @Override
    protected void configure() {
    }

//    private static final ThreadLocal<EntityManager> ENTITY_MANAGER_CACHE
//            = new ThreadLocal<EntityManager>();


    @Provides
    @Singleton
    public EntityManagerFactory provideEntityManagerFactory() {
        Map<String, String> properties = new HashMap<String, String>();
        properties.put("hibernate.connection.driver_class", "org.h2.Driver");
        properties.put("hibernate.connection.url", "jdbc:h2:~/test;AUTO_SERVER=TRUE");
        properties.put("hibernate.connection.username", "sa");
        properties.put("hibernate.connection.password", "");
        properties.put("hibernate.connection.pool_size", "1");
        properties.put("hibernate.dialect", "org.hibernate.dialect.H2Dialect");
        properties.put("hibernate.hbm2ddl.auto", "create-drop");
        properties.put("hibernate.show_sql", "true");
        properties.put("hibernate.format_sql","true");
        properties.put("hibernate.use_sql_comments","true");
        return Persistence.createEntityManagerFactory("db-manager");
    }

    @Provides
    public EntityManager provideEntityManager(EntityManagerFactory entityManagerFactory) {
//        EntityManager entityManager = ENTITY_MANAGER_CACHE.get();
//        if (entityManager == null) {
//            ENTITY_MANAGER_CACHE.set(entityManager = entityManagerFactory.createEntityManager());
//        }
        return entityManagerFactory.createEntityManager();
    }
}
