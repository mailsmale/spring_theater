package soundsystem;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.inject.Inject;

@Component
public class CDPlayer implements MediaPlayer {

    private CompactDisc cd;

    @Autowired
//    //@Inject
    public CDPlayer(CompactDisc cd) {
        this.cd = cd;
    }





    public void play() {
        cd.play();
    }

    public CompactDisc getCd() {
        return cd;
    }

    public void setCd(CompactDisc cd) {
        this.cd = cd;
    }

    //    @Autowired
//    @Inject
//    public void setCd(final CompactDisc compactDisc){
//        this.cd = compactDisc;
//    }
}
