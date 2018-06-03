package ua.epam.spring.hometask.domain;

import java.util.*;

import javax.persistence.*;


@Entity
public class Auditorium extends DomainObject {

    @Id
    @GeneratedValue
    private Integer id;


    @Column(length = 255)
    private String name;

    @Column
    private long numberOfSeats;

    @OneToMany(mappedBy = "auditorium", fetch = FetchType.EAGER)
    private Set<Seat> allSeats;

    @OneToMany(mappedBy = "auditorium", fetch = FetchType.EAGER)
    private Set<Seat> vipSeats;

    @OneToMany(mappedBy = "auditorium", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    private List<AuditoriumEvent> events = new ArrayList<>();

    public Auditorium() {
    }

    /**
     * Counts how many vip seats are there in supplied <code>seats</code>
     * 
     * @param seats
     *            Seats to process
     * @return number of vip seats in request
     */
    public long countVipSeats(Collection<Long> seats) {
        return seats.stream().filter(seat -> vipSeats.contains(seat)).count();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getNumberOfSeats() {
        return numberOfSeats;
    }

    public void setNumberOfSeats(long numberOfSeats) {
        this.numberOfSeats = numberOfSeats;
    }

    /*
     * public Set<Long> getVipSeats() { return vipSeats; }
     * 
     * public void setVipSeats(Set<Long> vipSeats) { this.vipSeats = vipSeats; }
     */

    public List<AuditoriumEvent> getEventAuditoriumPair() {
        return events;
    }

    public void setEvents(List<AuditoriumEvent> events) {
        this.events = events;
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
        Auditorium other = (Auditorium) obj;
        if (name == null) {
            if (other.name != null) {
                return false;
            }
        } else if (!name.equals(other.name)) {
            return false;
        }
        return true;
    }

    public Integer getId() {
        return id;
    }


    public Set<Seat> getVipSeats() {
        return vipSeats;
    }

    public void setVipSeats(Set<Seat> vipSeats) {
        this.vipSeats = vipSeats;
    }

    public Set<Seat> getAllSeats() {
        return allSeats;
    }

    public void setAllSeats(Set<Seat> allSeats) {
        this.allSeats = allSeats;
    }
}
