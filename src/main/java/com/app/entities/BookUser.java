package com.app.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity(name = "book_user")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "book_user")
public class BookUser {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "bookuser_id")
    private long id;

    @Column(name = "user_id")
    private long user_id;

    @Column(name = "book_id")
    private long book_id;


}
