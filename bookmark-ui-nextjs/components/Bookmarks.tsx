import { BookmarksResponse } from '@/types/bookmark.d'; // 올바른 경로로 수정
import Bookmark from './Bookmark';

// Props 타입 정의
interface BookmarksProps {
  bookmarks: BookmarksResponse;
}

// Bookmarks 컴포넌트 정의
const Bookmarks :React.FC<BookmarksProps> = ({ bookmarks }: BookmarksProps) => {
  return (
    <div>
      {/* 데이터 배열을 매핑하여 제목을 출력 */}
      {bookmarks.data.map((bookmark) => (
        // <h2 key={bookmark.id}>{bookmark.title}</h2>
            <Bookmark key={bookmark.id} bookmark={bookmark}/>
      ))}
    </div>
  );
};

export default Bookmarks;


