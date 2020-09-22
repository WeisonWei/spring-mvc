package com.weison.spring.profile.config;

import com.weison.spring.profile.bean.Bar;
import com.weison.spring.profile.bean.Boss;
import com.weison.spring.profile.condition.ConditionalOnBean;
import com.weison.spring.profile.condition.ExistBossCondition;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Configuration;

/**
 * @author Weison
 * @date 2020/9/21
 */
@Configuration
public class BarConfiguration {

    @Bean
    @Conditional(ExistBossCondition.class)
    public Bar littleBear() {
        return new Bar();
    }

    @Bean
    @ConditionalOnBean(beanNames = "com.weison.spring.profile.bean.Boss")
    public Bar bigBear() {
        return new Bar();
    }

    @Bean
    @ConditionalOnBean(Boss.class)
    public Bar middleBear() {
        return new Bar();
    }

}
