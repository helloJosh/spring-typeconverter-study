package hello.typeconverter;

import hello.typeconverter.coverter.IntegerToStringConverter;
import hello.typeconverter.coverter.IpPortToStringConverter;
import hello.typeconverter.coverter.StringToIntegerConverter;
import hello.typeconverter.coverter.StringToIpPortConvertor;
import org.springframework.context.annotation.Configuration;
import org.springframework.format.FormatterRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {
    @Override
    public void addFormatters(FormatterRegistry registry) {
        registry.addConverter(new StringToIntegerConverter());
        registry.addConverter(new IntegerToStringConverter());
        registry.addConverter(new StringToIpPortConvertor());
        registry.addConverter(new IpPortToStringConverter());
    }
}
