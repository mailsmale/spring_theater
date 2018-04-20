package ua.epam.spring.hometask.domain;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class EventAuditoriumId implements Serializable {

    @Column(name = "event_id")
    private Long eventId;

    @Column(name = "auditorium_id")
    private Long auditoriumId;

    private EventAuditoriumId() {
    }

    public EventAuditoriumId(final Long eventId, final Long auditoriumId) {
        this.eventId = eventId;
        this.auditoriumId = auditoriumId;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o)
            return true;

        if (o == null || getClass() != o.getClass())
            return false;

        EventAuditoriumId that = (EventAuditoriumId) o;
        return Objects.equals(eventId, that.eventId) && Objects.equals(auditoriumId, that.auditoriumId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(eventId, auditoriumId);
    }

}
