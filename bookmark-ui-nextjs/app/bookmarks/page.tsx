
import { fetchBookmarks } from '@/services/api/fetchBookmarks';
import { BookmarksResponse } from './../../types/bookmark.d';
import Bookmarks from '@/components/Bookmarks';
import Pagination from '@/components/Pagination';
import SearchForm from '@/components/SearchForm';


//서버요청을 위한 서버 컴포넌트
// searchParams는 URL에서 쿼리 문자열을 추출하여 JavaScript 객체 형태로 제공합니다. 
// 예를 들어, URL이 http://example.com/page?param1=value1&param2=value2인 경우, 
// searchParams는 { param1: 'value1', param2: 'value2' }와 같은 형태를 가집니다.
// page?:는 속성이 없을 수도 있다는 것을 의미하며 있을 경우 string으로 변환

const Home = async ({ searchParams }: { searchParams: { page?: string, query?: string } }) => {
  const page = searchParams.page ? parseInt(searchParams.page) : 1;
  const query = searchParams.query ? String(searchParams.query) : ""; // query 추가
  const bookmakrs = await fetchBookmarks(parseInt(String(page)),query); // 서버사이트 데이터 페칭

  return (
    <div>
      <h2>Welcome to Bookmark</h2>
      <SearchForm/>
      <Pagination bookmarks={bookmakrs} query={query}/>
      <ul  style={{ paddingLeft: 0 }}>
      {/* {bookmakrs.data.map(bookmark=><li>{bookmark.title}</li>)} */}
      <Bookmarks bookmarks={bookmakrs}/>
      </ul>
    </div>
  );
};

export default Home;


