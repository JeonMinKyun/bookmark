package com.min.edu.domain;

import org.springframework.stereotype.Component;

//TODO 015 Entity의 객체를 프로덕션된 BookmarkDto로 변환하게 반환하는 객체
@Component
public class BookmarkMapper {

	//반환타입 프로덕션 객체 BookmarkDto
	//프로덕션객체.get**(Entity.get**());
	public BookmarkDto toDto(Bookmark bookmark) {
		// TODO 033 JPA 메소드의 형변환으로 오류가 발생 되기 때문에 생성자 오버로딩의 메소드로 변환
//		BookmarkDto dto = new BookmarkDto();
//		dto.setId(bookmark.getId()); 
//		dto.setTitle(bookmark.getTitle());
//		dto.setUrl(bookmark.getUrl());
//		dto.setCreatedAt(bookmark.getCreatedAt());
		BookmarkDto dto = new BookmarkDto(bookmark.getId(),
									bookmark.getTitle(),
									bookmark.getUrl(),
									bookmark.getCreatedAt());
		
		return dto;
	}
	
}
