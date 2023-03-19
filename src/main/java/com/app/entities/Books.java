package com.app.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Data
@Entity(name = "books")
@Table(name = "books")
@NoArgsConstructor
@AllArgsConstructor
public class Books {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "book_id")
    private long id;

    @Column(name = "book_name")
    private String name;

    @Column(name = "author_name")
    private String author_name;

    @Column(name = "author_surname")
    private String author_surname;

    @Column(name = "genre")
    private String genre;

    @ManyToMany(mappedBy = "likedBooks")
    Set<Users> likes;

}
