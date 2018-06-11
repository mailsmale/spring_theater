package soundsystem;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import(CDConfig.class)
public class CDPlayerConfigClone {

    @Bean
    @Autowired
    public MediaPlayer cdPlayer(SgtPeppers compactDisc) {
        return new CDPlayer(compactDisc);
    }

//    @Bean
//    @Autowired
//    public MediaPlayer cdPlayerCopy(CompactDisc sgtPeppers) {
//        return new CDPlayer(sgtPeppers);
//    }

//    @Bean(name = "sgtPeppers")
//    public CompactDisc getSgtPeppers() {
//        return new SgtPeppers();
//    }

//    @Bean(name = "sgtPeppersCopy")
//    public CompactDisc getSgtPeppersCopy() {
//        return new SgtPeppers();
//    }

}
