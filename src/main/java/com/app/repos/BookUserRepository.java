package com.app.repos;

import com.app.entities.BookUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookUserRepository extends JpaRepository<BookUser,Long> {

    @Query("SELECT COUNT (*) FROM book_user bu WHERE bu.user_id=:user_id AND bu.book_id=:book_id")
    public int existsByUserIdBookId(@Param("user_id") Long usid, @Param("book_id") Long boid);

    @Query("SELECT bu FROM book_user bu WHERE bu.user_id=:user_id AND bu.book_id=:book_id")
    public BookUser findByUserIdBookId(@Param("user_id") Long usid, @Param("book_id") Long boid);


}

