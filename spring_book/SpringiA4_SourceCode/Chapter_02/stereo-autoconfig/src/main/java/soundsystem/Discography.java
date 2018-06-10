package soundsystem;

import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class Discography {

    final String name;
    final List<CompactDisc> discList;

    public Discography(String name, List<CompactDisc> discList) {
        this.name = name;
        this.discList = discList;
    }
}
