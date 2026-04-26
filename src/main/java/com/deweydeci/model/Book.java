package com.deweydeci.model;

import com.deweydeci.constants.BookStatus;

import lombok.Data;

@Data
public class Book {

	private String tital;
	private String author;
	private BookStatus status;

}
