package com.app.repos;

import com.app.entities.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository <Users,Long> {
    @Query("SELECT COUNT (u) FROM users u")
    public int countUsers();
    @Query("SELECT COUNT (u) FROM users u JOIN u.likedBooks b WHERE b.author_name=:name AND b.author_surname=:surname")
    public int countUsersByAuthor(@Param("name") String name, @Param("surname") String surname);
    @Query("SELECT DISTINCT u FROM users u JOIN u.likedBooks b WHERE b.genre=:genre")
    public List<Users> getUsersByGenre(@Param("genre") String genre);
}
