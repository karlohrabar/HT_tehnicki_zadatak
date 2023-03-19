package com.app.repos;

import com.app.entities.Books;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.init.Jackson2RepositoryPopulatorFactoryBean;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends JpaRepository <Books,Long> {
}
