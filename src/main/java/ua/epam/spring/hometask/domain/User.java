package ua.epam.spring.hometask.domain;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.NavigableSet;
import java.util.Objects;
import java.util.Set;
import java.util.TreeSet;

/**
 * @author Yuriy_Tkach
 */
@Entity
public class User extends DomainObject {

    @Id
    @GeneratedValue
    private Integer id;

    @Column
    private String name;

    @Column
    private String lastName;

    @Column
    private String email;

    @Column
    private LocalDate birthDay;

    @Column
    private boolean availableDiscountForTenthTicket;

    @OneToMany(mappedBy = "user", cascade = CascadeType.REMOVE, targetEntity = Ticket.class)
    private Set<Ticket> tickets = new TreeSet<>();


    public String getName() {
        return name;
    }

    public void setName(String firstName) {
        this.name = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Set<Ticket> getTickets() {
        return tickets;
    }

    public void setTickets(NavigableSet<Ticket> tickets) {
        this.tickets = tickets;
    }

    public LocalDate getBirthDay() {
        return birthDay;
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, lastName, email);
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
        User other = (User) obj;
        if (email == null) {
            if (other.email != null) {
                return false;
            }
        } else if (!email.equals(other.email)) {
            return false;
        }
        if (name == null) {
            if (other.name != null) {
                return false;
            }
        } else if (!name.equals(other.name)) {
            return false;
        }
        if (lastName == null) {
            if (other.lastName != null) {
                return false;
            }
        } else if (!lastName.equals(other.lastName)) {
            return false;
        }
        return true;
    }

    public boolean isAvailableDiscountForTenthTicket() {
        return availableDiscountForTenthTicket;
    }

    public void setAvailableDiscountForTenthTicket(boolean availableDiscountForTenthTicket) {
        this.availableDiscountForTenthTicket = availableDiscountForTenthTicket;
    }
}
