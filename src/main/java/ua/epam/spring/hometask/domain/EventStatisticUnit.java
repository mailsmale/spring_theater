package ua.epam.spring.hometask.domain;

import javax.persistence.*;

import lombok.*;

@Entity
@RequiredArgsConstructor
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class EventStatisticUnit {

    @Id
    @GeneratedValue
    private Long id;

    @NonNull
    @OneToOne
    @JoinColumn(name = "event_id")
    private Event event;

    @Column
    @NonNull
    private int numberOfSearchByName;

    @Column
    @NonNull
    private int numberOfGettingPriceForEvent;
}
