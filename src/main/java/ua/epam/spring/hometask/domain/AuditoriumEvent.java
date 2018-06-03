package ua.epam.spring.hometask.domain;

import java.time.LocalDateTime;

import javax.persistence.*;

import com.sun.istack.internal.NotNull;

import org.hibernate.annotations.GenericGenerator;

@Entity(name = "EventAuditorium")
@Table(name = "event_auditorium")
public class AuditoriumEvent extends DomainObject {

    @Id
    @Column(nullable = false, unique = true)
    @GenericGenerator(name = "idGenerator", strategy = "increment")
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;

    @Column(name = "created_on")
    LocalDateTime date;

    @Column(name = "price")
    Double eventPrice;

    @Column(name = "name")
    String name;

    @NotNull
    @ManyToOne(fetch = FetchType.EAGER)
    private Event event;

    @NotNull
    @ManyToOne(fetch = FetchType.EAGER)
    private Auditorium auditorium;

    private AuditoriumEvent() {
    }

    public AuditoriumEvent(final Event event, final Auditorium auditorium, final Double eventPrice,
            final LocalDateTime localDateTime) {
        this.id = 0L;
        this.event = event;
        this.auditorium = auditorium;
        this.eventPrice = eventPrice;
        this.name = String.format("%s_%s", event.getName(), auditorium.getName());
        this.date = localDateTime;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime createdOn) {
        this.date = createdOn;
    }

    public Double getEventPrice() {
        return eventPrice;
    }

    public void setEventPrice(Double eventPrice) {
        this.eventPrice = eventPrice;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;

        AuditoriumEvent that = (AuditoriumEvent) o;

        if (id != null ? !id.equals(that.id) : that.id != null)
            return false;
        if (event != null ? !event.equals(that.event) : that.event != null)
            return false;
        if (auditorium != null ? !auditorium.equals(that.auditorium) : that.auditorium != null)
            return false;
        return date != null ? date.equals(that.date) : that.date == null;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (event != null ? event.hashCode() : 0);
        result = 31 * result + (auditorium != null ? auditorium.hashCode() : 0);
        result = 31 * result + (date != null ? date.hashCode() : 0);
        return result;
    }

    public Event getEvent() {
        return event;
    }

    public void setEvent(Event event) {
        this.event = event;
    }

    public Auditorium getAuditorium() {
        return auditorium;
    }

    public void setAuditorium(Auditorium auditorium) {
        this.auditorium = auditorium;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
