package ua.epam.spring.hometask.service;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

import org.springframework.stereotype.Service;

import org.springframework.transaction.annotation.Transactional;
import ua.epam.spring.hometask.domain.Auditorium;

/**
 * @author Yuriy_Tkach
 */
@Service("auditoriumService")
@Transactional
public interface AuditoriumService extends AbstractDomainObjectService<Auditorium> {


}
