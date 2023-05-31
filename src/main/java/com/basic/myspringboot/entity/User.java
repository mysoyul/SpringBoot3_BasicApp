package com.basic.myspringboot.entity;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
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
    @NotEmpty(message = "Name은 필수 입력항목 입니다!")
    private String name;

    @Column(unique = true, nullable = false)
    @JacksonXmlProperty
    @NotBlank(message = "Email은 필수 입력항목 입니다!")
    private String email;
}
