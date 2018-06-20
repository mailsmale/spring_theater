package spitter.data;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;

import java.util.Date;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Spittle {

    private final Long id;
    private final String message;
    private final Date date;
    private Double latitute;
    private Double longitude;



    public Spittle(String message, Date date, Double latitute, Double longitude) {
        this.id = null;
        this.message = message;
        this.date = date;
        this.latitute = latitute;
        this.longitude = longitude;
    }

    public Spittle(String message, Date date) {
        this(message, date, null, null);
    }

    public boolean equals(Object that) {
        return EqualsBuilder.reflectionEquals(this, that, "id", "time");
    }

    public int hashCode(){
        return HashCodeBuilder.reflectionHashCode(this, "id", "time");
    }
}
