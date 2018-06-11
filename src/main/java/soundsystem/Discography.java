package soundsystem;

import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class Discography {

    final String name;
    final List<CompactDisc> discList;

    public Discography(String name, List<CompactDisc> discList) {
        this.name = name;
        this.discList = discList;
    }
}
