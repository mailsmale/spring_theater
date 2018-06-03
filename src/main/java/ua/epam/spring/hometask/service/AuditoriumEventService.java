package ua.epam.spring.hometask.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ua.epam.spring.hometask.domain.AuditoriumEvent;

@Service
@Transactional
public interface AuditoriumEventService extends AbstractDomainObjectService<AuditoriumEvent> {


}
