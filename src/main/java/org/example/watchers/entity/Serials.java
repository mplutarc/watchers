package org.example.watchers.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "serials")
@Entity
public class Serials {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer number;
    private String name;
    private Integer year;
    private String country;
    private Integer seasons;
    private Integer episodes;
    private String epDuration;
    private String studio;
    private String genres;
    private String type;
    private Boolean done;
}