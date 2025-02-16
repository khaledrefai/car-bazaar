package com.syriabazaar.cars;

import com.syriabazaar.cars.config.AsyncSyncConfiguration;
import com.syriabazaar.cars.config.EmbeddedSQL;
import com.syriabazaar.cars.config.JacksonConfiguration;
import com.syriabazaar.cars.config.TestSecurityConfiguration;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * Base composite annotation for integration tests.
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@SpringBootTest(classes = { CarBazaarApp.class, JacksonConfiguration.class, AsyncSyncConfiguration.class, TestSecurityConfiguration.class })
@EmbeddedSQL
public @interface IntegrationTest {
}
