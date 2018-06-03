package ua.epam.spring.hometask.repositories;

import java.util.Optional;

import javax.annotation.Nullable;
import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import ua.epam.spring.hometask.domain.Event;
import ua.epam.spring.hometask.domain.EventStatisticUnit;


public interface EventAccessStatisticRepository extends JpaRepository<EventStatisticUnit, Long> {

    @Nullable
    EventStatisticUnit findByEvent(Event event);

    EventStatisticUnit findByNumberOfSearchByName(int number);

    @Transactional
    @Modifying
    @Query("update EventStatisticUnit e set e.numberOfSearchByName = e.numberOfSearchByName+1 " +
            "where e.id = :#{#eventStatisticUnit.id}")
    void increaseNumberOfSearchByName(
            @Param("eventStatisticUnit") EventStatisticUnit eventStatisticUnit);

    @Transactional
    @Modifying
    @Query("update EventStatisticUnit e set e.numberOfGettingPriceForEvent = e.numberOfGettingPriceForEvent+1 " +
            "where e.id = :#{#eventStatisticUnit.id}")
    void increaseNumberOfGettingPriceForEvent(
            @Param("eventStatisticUnit") EventStatisticUnit eventStatisticUnit);



}
