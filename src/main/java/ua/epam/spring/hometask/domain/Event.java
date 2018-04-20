package ua.epam.spring.hometask.domain;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.*;
import java.util.stream.Collectors;

import javax.persistence.*;

import org.hibernate.annotations.NaturalIdCache;

/**
 * @author Yuriy_Tkach
 */
@Entity(name = "Event")
@Table(name = "event")
@NaturalIdCache
public class Event extends DomainObject {

    @Id
    @GeneratedValue
    private Integer id;

    @Column
    private String name;

    @Column
    @ElementCollection
    private Set<LocalDateTime> airDates = new TreeSet<LocalDateTime>();

    @Column
    private double basePrice;

    @Column
    private EventRating rating;

    @OneToMany(mappedBy = "event", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<EventAuditorium> auditoriums = new LinkedList<>();

    /**
     * Checks if event is aired on particular <code>dateTime</code> and assigns auditorium to it.
     * 
     * @param dateTime
     *            Date and time of aired event for which to assign
     * @param auditorium
     *            Auditorium that should be assigned
     * @return <code>true</code> if successful, <code>false</code> if event is not aired on that
     *         date
     */
    public boolean assignAuditorium(LocalDateTime dateTime, Auditorium auditorium, Double price) {
        Double eventPrice = Optional.ofNullable(price).orElse(basePrice);
        if (airDates.contains(dateTime)) {
            EventAuditorium eventAuditorium = new EventAuditorium(this, auditorium, eventPrice);
            auditoriums.add(eventAuditorium);
            auditorium.getEventAuditoriumPair().add(new EventAuditorium(this, auditorium, price));
            return true;
        } else {
            return false;
        }
    }

    public boolean assignAuditorium(LocalDateTime dateTime, Auditorium auditorium) {
        return assignAuditorium(dateTime, auditorium, null);
    }

    /**
     * Removes auditorium assignment from event
     * 
     * @param dateTime
     *            Date and time to remove auditorium for
     * @return <code>true</code> if successful, <code>false</code> if not removed
     */
    public boolean removeAuditoriumAssignment(LocalDateTime dateTime) {
        List<EventAuditorium> auditoriumsToRemove = this.auditoriums.stream()
                .filter(auditorium -> auditorium.getCreatedOn().equals(dateTime))
                .collect(Collectors.toList());
        this.auditoriums.removeAll(auditoriumsToRemove);
        return !auditoriumsToRemove.isEmpty();
    }

    /**
     * Add date and time of event air
     * 
     * @param dateTime
     *            Date and time to add
     * @return <code>true</code> if successful, <code>false</code> if already there
     */
    public boolean addAirDateTime(LocalDateTime dateTime) {
        return airDates.add(dateTime);
    }

    /**
     * Removes the date and time of event air. If auditorium was assigned to that date and time -
     * the assignment is also removed
     * 
     * @param dateTime
     *            Date and time to remove
     * @return <code>true</code> if successful, <code>false</code> if not there
     */
    public boolean removeAirDateTime(LocalDateTime dateTime) {
        boolean result = airDates.remove(dateTime);
        if (result) {
            auditoriums.remove(dateTime);
        }
        return result;
    }

    /**
     * Checks if event airs on particular date and time
     * 
     * @param dateTime
     *            Date and time to check
     * @return <code>true</code> event airs on that date and time
     */
    public boolean airsOnDateTime(LocalDateTime dateTime) {
        return airDates.stream().anyMatch(dt -> dt.equals(dateTime));
    }

    /**
     * Checks if event airs on particular date
     * 
     * @param date
     *            Date to ckeck
     * @return <code>true</code> event airs on that date
     */
    public boolean airsOnDate(LocalDate date) {
        return airDates.stream().anyMatch(dt -> dt.toLocalDate().equals(date));
    }

    /**
     * Checking if event airs on dates between <code>from</code> and <code>to</code> inclusive
     * 
     * @param from
     *            Start date to check
     * @param to
     *            End date to check
     * @return <code>true</code> event airs on dates
     */
    public boolean airsOnDates(LocalDate from, LocalDate to) {
        return airDates.stream().anyMatch(
                dt -> dt.toLocalDate().compareTo(from) >= 0 && dt.toLocalDate().compareTo(to) <= 0);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<LocalDateTime> getAirDates() {
        return airDates;
    }

    public void setAirDates(NavigableSet<LocalDateTime> airDates) {
        this.airDates = airDates;
    }

    public double getBasePrice() {
        return basePrice;
    }

    public void setBasePrice(double basePrice) {
        this.basePrice = basePrice;
    }

    public EventRating getRating() {
        return rating;
    }

    public void setRating(EventRating rating) {
        this.rating = rating;
    }

    public List<EventAuditorium> getAuditoriums() {
        return auditoriums;
    }

    public void setAuditoriums(LinkedList<EventAuditorium> auditoriums) {
        this.auditoriums = auditoriums;
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        Event other = (Event) obj;
        if (name == null) {
            if (other.name != null) {
                return false;
            }
        } else if (!name.equals(other.name)) {
            return false;
        }
        return true;
    }

}
