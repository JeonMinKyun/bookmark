package com.min.edu.domain;

import org.springframework.stereotype.Component;

//TODO 015 Entity의 객체를 프로덕션된 BookmarkDto로 변환하게 반환하는 객체
@Component
public class BookmarkMapper {

	//반환타입 프로덕션 객체 BookmarkDto
	//프로덕션객체.get**(Entity.get**());
	public BookmarkDto toDto(Bookmark bookmark) {
		BookmarkDto dto = new BookmarkDto();
		dto.setId(bookmark.getId()); 
		dto.setTitle(bookmark.getTitle());
		dto.setUrl(bookmark.getUrl());
		dto.setCreatedAt(bookmark.getCreatedAt());
		return dto;
	}
	
}
