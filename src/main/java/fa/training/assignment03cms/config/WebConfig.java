package fa.training.assignment03cms.config;

import fa.training.assignment03cms.config.interceptor.PostLoginInterceptor;
import fa.training.assignment03cms.config.interceptor.PreLoginInterceptor;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@RequiredArgsConstructor
public class WebConfig implements WebMvcConfigurer {
    private final PreLoginInterceptor preLoginInterceptor;
    private final PostLoginInterceptor postLoginInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(preLoginInterceptor)
                .excludePathPatterns("/login", "/register", "/css/**", "/js/**");
        registry.addInterceptor(postLoginInterceptor)
                .addPathPatterns("/login");
    }


}
