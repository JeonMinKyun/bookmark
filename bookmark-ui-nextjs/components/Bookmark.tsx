import type { Bookmark } from '@/types/bookmark.d'; // Bookmark의 파일명과 하위의 타입과 이름이 같기 때문에 문제 발생 type 작성 후 사용
import Link from 'next/link';

// Props 타입 정의
interface BookmarksProps {
  bookmark: Bookmark;
}

// Bookmarks 컴포넌트 정의
const Bookmark :React.FC<BookmarksProps> = ({ bookmark}) => {
  return (
    <div>
      <div className="alert alert-primary" role="alert">
        <h5>
            <Link href={bookmark.url}>{bookmark.title}</Link>
        </h5>
      </div>
    </div>
  );
};

export default Bookmark;


