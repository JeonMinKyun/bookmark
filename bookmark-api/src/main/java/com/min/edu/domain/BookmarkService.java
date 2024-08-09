package com.min.edu.domain;

import java.time.Instant;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

//TDOO 003 Bookmark Service 구현
@Service
@Transactional
@RequiredArgsConstructor
public class BookmarkService {

	private final BookmarkRepository repository;
	
	private final BookmarkMapper bookmarkMapper;
	
	
//	@Transactional(readOnly = true)
//	public List<Bookmark> getBookmarks(){
//		return repository.findAll();
//	}
	
//	TODO 008 페이징 처리를 위한 Service page 처리
//	@Transactional(readOnly = true)
//	public List<Bookmark> getBookmarks(Integer page){
//		int pageNo = page<1 ?0 : page-1;
//		Pageable pageable = PageRequest.of(pageNo, 10,Sort.Direction.DESC,"createdAt");
//		return repository.findAll(pageable).getContent();
//	}
	
//	TODO 010 페이징 DTO인 BookmarksDto를 통해서 결과값 반환
//	@Transactional(readOnly = true)
//	public BookmarksDto getBookmarks(Integer page){
//		int pageNo = page<1 ?0 : page-1;
//		Pageable pageable = PageRequest.of(pageNo, 10,Sort.Direction.DESC,"createdAt");
//		return new BookmarksDto(repository.findAll(pageable));
//	}
	
//	TODO 017 Entity의 객체를 프로덕션 객체로 변경하게 받는다
//	@Transactional(readOnly = true)
//	public BookmarksDto getBookmarks(Integer page){
//		int pageNo = page<1 ?0 : page-1;
//		Pageable pageable = PageRequest.of(pageNo, 10,Sort.Direction.DESC,"createdAt");
//		Page<BookmarkDto> bookmarkPage = repository.findAll(pageable).map(Bookmark -> bookmarkMapper.toDto(Bookmark));
//		return new BookmarksDto(bookmarkPage);
//	}
	
//	TODO 019 Repository에서 반환을 프로덕션 객체로 실행하는 결과를 반환하는 JPQL실행
	@Transactional(readOnly = true)
	public BookmarksDto getBookmarks(Integer page){
		int pageNo = page<1 ?0 : page-1;
		Pageable pageable = PageRequest.of(pageNo, 10,Sort.Direction.DESC,"createdAt");
		Page<BookmarkDto> bookmarkPage = repository.findByBookmarks(pageable);
		return new BookmarksDto(bookmarkPage);
	}
	
	//TODO 003 'search' 요청처리 service
	@Transactional(readOnly = true)
	public BookmarksDto searchBookmarks(String query, Integer page) {
		int pageNo = page<1 ?0 : page-1;
		Pageable pageable = PageRequest.of(pageNo, 10,Sort.Direction.DESC,"createdAt");
		Page<BookmarkDto> bookmarkPage = repository.searchBookmarks(query, pageable);
		
		//TODO 033 JPA 메소드를 사용한 service 실행
//		Page<BookmarkDto> bookmarkPage = repository.findByTitleContainsIgnoreCase(query, pageable);
		
		//TODO 036 인터페이스 프로적션 Repository 실행 
		Page<BookmarkVM> bookmarkVMPage = repository.findByTitleContainsIgnoreCase(query, pageable);
		System.out.println("인터페이스 기반의 프로적션 객체 :" + bookmarkVMPage);
		return new BookmarksDto(bookmarkPage);
	}

	//TODO 039 입력받은 값을 처리 하기 위한 Bookmark 객체를 생성 입력 respository 실행
	public BookmarkDto createBookmark(@Valid CreateBookmarkRequest request) {
		Bookmark bookmark = new Bookmark(null, request.getTitle(), request.getUrl(), Instant.now());
		Bookmark saveBookmark = repository.save(bookmark);
		return bookmarkMapper.toDto(saveBookmark);
	}
	
}





















