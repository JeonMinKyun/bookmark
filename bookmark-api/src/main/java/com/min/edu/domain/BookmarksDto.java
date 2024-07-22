package com.min.edu.domain;

import java.util.List;

import org.springframework.data.domain.Page;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.Setter;

//TODO 009 페이징값 처리를 위한 값을 담기 위한 BookmarksDto 객체 생성
@Getter
@Setter
public class BookmarksDto {

//	private List<Bookmark> data;	// 페이징된 DB데이터 
//	TODO 016 수정된 프로덕션 타입으로 리스트의 제네릭을 변경한다
	private List<BookmarkDto> data;
	
	private long totalElements; 	// 전체 DB데이터의 갯수
    private int totalPages;			// 전체 페이지의 갯수
    private int currentPage;		// 현재 페이지의 갯수
//    private boolean isFirst;		// 현재 페이지가 첫페이지 인지 확인
//    private boolean isLast;			// 현재 페이지가 마지막 페이지 인지 확인
    
//  TODO 012 출력된 멤버필드 이름으로 출력이 되지 않기 때문에 JsonProperty를 통해서 이름 변경
    @JsonProperty(value = "isFirst")
    private boolean isFirst;		// 현재 페이지가 첫페이지 인지 확인
    @JsonProperty(value = "isLast")
    private boolean isLast;			// 현재 페이지가 마지막 페이지 인지 확인
    private boolean hasNext;		// 다음 페이지가 있는지 확인
    private boolean hasPrevious;	// 이전 페이지가 있는지 확인
    
//	public BookmarksDto(Page<BookmarkDto> bookmarkPage) {
//    TODO 016 수정된 프로덕션 타입으로 리스트의 제네릭을 변경한다
		public BookmarksDto(Page<BookmarkDto> bookmarkPage) {
		this.setData(bookmarkPage.getContent());
		this.setTotalElements(bookmarkPage.getTotalElements());
		this.setTotalPages(bookmarkPage.getTotalPages());
		this.setCurrentPage(bookmarkPage.getNumber()+1);
		this.setFirst(bookmarkPage.isFirst());
		this.setLast(bookmarkPage.isLast());
		this.setHasNext(bookmarkPage.hasNext());
		this.setHasPrevious(bookmarkPage.hasPrevious());
	}
    
    
    
	
	
}
