'use client'; // Client Component 작성방법에서 Server Component 작성방법을 적용할 때 선언함
import Navbar from "@/components/NavBar";
import { saveBookmark } from "@/services/api/fetchBookmarks";
import { useState, useEffect } from "react";

export default function AddBookmark() {
  const [title, setTitle] = useState("");
  const [url, setUrl] = useState("");
  const [message, setMessage] = useState<string | null>(null);

  // 컴포넌트가 마운트될 때 실행되는 useEffect
  useEffect(() => {
    // 메시지 초기화
    setMessage(null);
  }, []); // 빈 배열을 전달하여 마운트 시에만 실행되도록 함

  const handleSubmit = (e: React.FormEvent<HTMLFormElement>) => {
    e.preventDefault();

    // 유효성 검사
    if (!url) {
      alert("url을 입력해 주세요");
      return;
    }

    const payload = {
      title,
      url
    };

    try {
      saveBookmark(payload)
        .then(response => {
          console.log("SaveBookmark response", response);
          setTitle("");
          setUrl("");
          // 저장 성공 메시지
          setMessage("새로운 Bookmark를 저장하였습니다");
        })
        .catch(error => {
          // 오류 메시지를 setMessage에 저장
          setMessage(error.message || "새로운 Bookmark를 저장에 실패하였습니다");
        });
    } catch (error) {
      // Promise가 reject된 경우
      setMessage("새로운 Bookmark를 저장에 실패하였습니다");
    }
  };

  return (
    <div>
      {message && <div className="alert alert-primary" role="alert">{message}</div>}
      <form onSubmit={e => handleSubmit(e)}>
        <fieldset>
          <legend>새로운 Bookmark 등록</legend>
          <div className="mb-3">
            <label htmlFor="title" className="form-label">제목</label>
            <input
              type="text"
              id="title"
              className="form-control"
              placeholder="title"
              value={title}
              onChange={e => setTitle(e.target.value)}
            />
          </div>
          <div className="mb-3">
            <label htmlFor="url" className="form-label">URL</label>
            <input
              type="text"
              id="url"
              className="form-control"
              placeholder="url"
              value={url}
              onChange={e => setUrl(e.target.value)}
            />
          </div>
          <div className="d-grid gap-2 col-6 mx-auto">
            <button type="submit" className="btn btn-primary">Submit</button>
          </div>
        </fieldset>
      </form>
    </div>
  );
}
