package soundsystem;


import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;

@Configuration
@ImportResource("classpath*:soundsystem/META-INF/spring/soundsystem.xml")
public class ConfigurationXMLOverJava {
}
