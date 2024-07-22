package com.min.edu.domain;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

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
	
	//TODO 011 페이징Dto BookmarksDto 사용 처리
	@GetMapping
	public BookmarksDto getBookmark(@RequestParam(name = "page", defaultValue = "1") Integer page){
		return bookmarkService.getBookmarks(page);
	}
	
}
