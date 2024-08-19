import { BookmarksResponse } from "@/types/bookmark";
import axios from "axios";

// const API_BASE_URL = "http://localhost:8080";

const getApiUrl = () => {
  // 서버 사이드 API URL
  const serverApiUrl = process.env.SERVER_SIDE_API_BASE_URL;
  
  // 클라이언트 사이드 API URL
  const clientApiUrl = process.env.NEXT_PUBLIC_CLIENT_SIDE_API_BASE_URL || "http://localhost:18080"; // 기본값 설정

  // 서버 사이드에서는 serverApiUrl 사용
  if (typeof window === 'undefined') {
    console.log("서버 사이드 호출 됨")
    return serverApiUrl || clientApiUrl; // 서버 사이드 환경에서 URL이 없을 경우 기본값 사용
  }
  console.log("클라이언트 사이드 호출 됨")
  // 클라이언트 사이드에서는 clientApiUrl 사용
  return clientApiUrl;
};


export const fetchBookmarks = async(page:number, query?: string):Promise<BookmarksResponse> =>{
  let apiUrl = getApiUrl()
  // let apiUrl = API_BASE_URL;
  console.log("요청되는 주소:",apiUrl)
  let url = `${apiUrl}/api/bookmarks?page=${page}`;
  console.log(url)
  if(query){
    url += `&query=${query}`
  }
  const res = await axios.get<BookmarksResponse>(url);

  console.log(res.data)
  return res.data;
}

export const saveBookmark = async(bookmark:{title:string, url:string})=>{
  try {
    let apiUrl = getApiUrl()
    // let apiUrl = API_BASE_URL;
    const res = await axios.post(`${apiUrl}/api/bookmarks`, bookmark, {
      headers: {
        'Content-Type': 'application/json',
      },
    });
    
    return res.data; // 성공 시 응답 데이터 반환
  } catch (error) {
      // 에러가 발생한 경우 에러 메시지 처리
      console.error("Error saving bookmark:", error);
      throw new Error("북마크 저장에 실패하였습니다"); // 오류를 throw하여 호출자에게 전달
  }
}