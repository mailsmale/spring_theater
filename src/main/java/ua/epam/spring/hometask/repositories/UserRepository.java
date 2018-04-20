package ua.epam.spring.hometask.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ua.epam.spring.hometask.domain.User;

public interface UserRepository extends JpaRepository<User, Long> {
}
