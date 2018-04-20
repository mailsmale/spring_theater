package ua.epam.spring.hometask.domain;

import java.time.LocalDateTime;

import javax.persistence.*;

@Entity(name = "EventAuditorium")
@Table(name = "event_auditorium")
public class EventAuditorium {

    @Column(name = "created_on")
    LocalDateTime createdOn = LocalDateTime.now();

    @Column(name = "price")
    Double eventPrice;

    @EmbeddedId
    private EventAuditoriumId id;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("event_id")
    private Event event;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("auditorium_id")
    private Auditorium auditorium;

    private EventAuditorium() {
    }

    public EventAuditorium(final Event event, final Auditorium auditorium, final Double eventPrice) {
        this.event = event;
        this.auditorium = auditorium;
        this.eventPrice = eventPrice;
    }

    public LocalDateTime getCreatedOn() {
        return createdOn;
    }

    public void setCreatedOn(LocalDateTime createdOn) {
        this.createdOn = createdOn;
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

        EventAuditorium that = (EventAuditorium) o;

        if (id != null ? !id.equals(that.id) : that.id != null)
            return false;
        if (event != null ? !event.equals(that.event) : that.event != null)
            return false;
        if (auditorium != null ? !auditorium.equals(that.auditorium) : that.auditorium != null)
            return false;
        return createdOn != null ? createdOn.equals(that.createdOn) : that.createdOn == null;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (event != null ? event.hashCode() : 0);
        result = 31 * result + (auditorium != null ? auditorium.hashCode() : 0);
        result = 31 * result + (createdOn != null ? createdOn.hashCode() : 0);
        return result;
    }

    public EventAuditoriumId getId() {
        return id;
    }

    public void setId(EventAuditoriumId id) {
        this.id = id;
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
}
