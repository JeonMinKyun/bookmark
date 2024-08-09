package com.min.edu.domain;

import jakarta.validation.constraints.NotEmpty;
import lombok.Getter;
import lombok.Setter;

//TODO 037 입력을 위한 객체 + 유효값
@Setter
@Getter
public class CreateBookmarkRequest {

	@NotEmpty(message = "제목은 필수 입력 값입니다")
	private String title;
	@NotEmpty(message = "URL은 필수 입력 값입니다")
	private String url;
}
