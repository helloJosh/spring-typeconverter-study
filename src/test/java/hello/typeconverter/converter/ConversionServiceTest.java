package hello.typeconverter.converter;

import hello.typeconverter.coverter.IntegerToStringConverter;
import hello.typeconverter.coverter.IpPortToStringConverter;
import hello.typeconverter.coverter.StringToIntegerConverter;
import hello.typeconverter.coverter.StringToIpPortConvertor;
import hello.typeconverter.type.IpPort;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.shadow.com.univocity.parsers.common.DefaultContext;
import org.springframework.core.convert.support.DefaultConversionService;

import static org.assertj.core.api.Assertions.*;

public class ConversionServiceTest {
    @Test
    void conversionService(){
        //등록
        DefaultConversionService conversionService = new DefaultConversionService();
        conversionService.addConverter(new StringToIntegerConverter());
        conversionService.addConverter(new IntegerToStringConverter());
        conversionService.addConverter(new StringToIpPortConvertor());
        conversionService.addConverter(new IpPortToStringConverter());

        //사용
        assertThat(conversionService.convert("10",Integer.class)).isEqualTo(10);
        assertThat(conversionService.convert(10,String.class)).isEqualTo("10");
        assertThat(conversionService.convert("127.0.0.1:8080", IpPort.class)).isEqualTo(new IpPort("127.0.0.1",8080));
        assertThat(conversionService.convert(new IpPort("127.0.0.1",8080), String.class)).isEqualTo("127.0.0.1:8080");

    }
}
