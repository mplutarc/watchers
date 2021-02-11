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
@Table(name = "films")
@Entity
public class Films {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer number;
	private String name;
	private String year;
	private String country;
	private String duration;
	private String director;
	private String genres;
	private String type;
}
