package com.habuma.restfun;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.test.context.ActiveProfiles;

@Configuration
@Conditional(MagicExistsCondition.class)
public class MagicConfig {

    @Bean
    @Conditional(MagicExistsCondition.class)
    @Profile("dev")
    public MagicBean magicBean() {
        return new MagicBean();
    }

}