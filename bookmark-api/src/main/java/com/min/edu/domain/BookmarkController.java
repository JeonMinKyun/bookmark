package com.min.edu.domain;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

//TODO 004 Bookmark Controller 구현
@RestController
@RequestMapping("/api/bookmarks")
@RequiredArgsConstructor
public class BookmarkController {

	private final BookmarkService bookmarkService;
	
//	@GetMapping
//	public List<Bookmark> getBookmark(){
//		return bookmarkService.getBookmarks();
//	}
	
	//TODO 007 페이징 처리를 위한 Controller page parameter 처리
//	@GetMapping
//	public List<Bookmark> getBookmark(@RequestParam(name = "page", defaultValue = "1") Integer page){
//		return bookmarkService.getBookmarks(page);
//	}
	
//	//TODO 011 페이징Dto BookmarksDto 사용 처리
//	@GetMapping
//	public BookmarksDto getBookmark(@RequestParam(name = "page", defaultValue = "1") Integer page){
//		return bookmarkService.getBookmarks(page);
//	}
	
	//TODO 029 'get all' 'search' 요청처리
	@GetMapping
	public BookmarksDto getBookmarks(@RequestParam(name = "page", defaultValue = "1") Integer page,
									 @RequestParam(name = "query", defaultValue = "") String query) {
		if(query == null || query.trim().length() == 0) {
			return bookmarkService.getBookmarks(page); // get all 요청처리
		}
		return bookmarkService.searchBookmarks(query, page); // search 요청처리
	}
	
	//TODO 038 'create' 요청처리
	@PostMapping
	@ResponseStatus(code = HttpStatus.CREATED)
	public BookmarkDto createBookmark(@RequestBody @Valid CreateBookmarkRequest request) {
		return bookmarkService.createBookmark(request);
	}
	
	
	
	
}
