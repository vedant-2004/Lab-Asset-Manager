package com.college.labassetmanager.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "labs")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Lab {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;
    private String location;
}

