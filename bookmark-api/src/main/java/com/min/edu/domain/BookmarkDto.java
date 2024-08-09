package com.min.edu.domain;

import java.time.Instant;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

//TODO 014 JAP의 Entity와 연결을 끊기위한 프로덕션DTO 객체
@Getter
@Setter
//@NoArgsConstructor
@AllArgsConstructor
public class BookmarkDto {

	private Long id;
	private String title;
	private String url;
	private Instant createdAt;
}
