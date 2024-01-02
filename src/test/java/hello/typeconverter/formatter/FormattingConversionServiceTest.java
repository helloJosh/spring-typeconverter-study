package hello.typeconverter.formatter;

import hello.typeconverter.coverter.IntegerToStringConverter;
import hello.typeconverter.coverter.IpPortToStringConverter;
import hello.typeconverter.coverter.StringToIntegerConverter;
import hello.typeconverter.coverter.StringToIpPortConvertor;
import hello.typeconverter.type.IpPort;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.format.support.DefaultFormattingConversionService;

import static org.assertj.core.api.Assertions.*;

public class FormattingConversionServiceTest {
    @Test
    void formattingConversionService(){
        DefaultFormattingConversionService cs = new DefaultFormattingConversionService();

        //컨버터 등록
        cs.addConverter(new StringToIpPortConvertor());
        cs.addConverter(new IpPortToStringConverter());

        //포멧터 등록
        cs.addFormatter(new MyNumberFormatter());

        //컨버터 사용
        IpPort ipPort = cs.convert("127.0.0.1:8080", IpPort.class);
        assertThat(ipPort).isEqualTo(new IpPort("127.0.0.1",8080));

        //포맷터 사용
        String convert = cs.convert(1000, String.class);
        assertThat(convert).isEqualTo("1,000");
        Long convert1 = cs.convert("1,000", Long.class);
        assertThat(convert1).isEqualTo(1000L);
    }
}
