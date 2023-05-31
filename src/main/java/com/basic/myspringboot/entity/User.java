package com.basic.myspringboot.entity;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "users")
@Getter @Setter
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JacksonXmlProperty(isAttribute = true)
    private Long id;

    @Column(nullable = false)
    @JacksonXmlProperty
    private String name;

    @Column(unique = true, nullable = false)
    @JacksonXmlProperty
    private String email;
}
