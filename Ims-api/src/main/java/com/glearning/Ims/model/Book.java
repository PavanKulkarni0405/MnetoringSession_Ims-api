package com.glearning.Ims.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;


	
	@Entity
	@Table(name="books")
	@Data
	public class Book {
		
		@Id
		@GeneratedValue(strategy = GenerationType.AUTO)
		private int id;
		
		@Column(name="name")
		private String name;
		
		@Column(name="author")
		private String author;
		
		@Column(name="category")
		private String category;
		

}
