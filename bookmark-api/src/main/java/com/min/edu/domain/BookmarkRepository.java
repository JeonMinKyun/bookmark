package com.min.edu.domain;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

//TODO 002 Dao를 JpaRepository를 extends 하는 interface 구현
public interface BookmarkRepository extends JpaRepository<Bookmark, Long> {

	
	//TODO 018 프로덕션 객체를 반환하는 결과를 가진 쿼리(JPQL) 작성
	@Query("""
			select new com.min.edu.domain.BookmarkDto(b.id, b.title, b.url, b.createdAt) from Bookmark b
			""")
	Page<BookmarkDto> findByBookmarks(Pageable pageable);
}
