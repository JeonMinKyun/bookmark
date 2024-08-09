import { BookmarksResponse } from "@/types/bookmark";
import Link from "next/link";

interface PaginationProps{
    bookmarks : BookmarksResponse,
    query ?: string
}

const Pagination: React.FC<PaginationProps> = ({bookmarks, query}) =>{

    const path = "/bookmarks";
    const queryParams = (query === undefined || query === "")? {} : {query:query}
    //스프레드 연산자(Spread Operator) 객체나 배열을 만드는 데 사용
    const firstPage = {pathname:path, query:{page:1, ...queryParams}}
    const previousPage = {pathname:path, query:{page:bookmarks.currentPage-1, ...queryParams}}
    const nextPage = {pathname:path, query:{page:bookmarks.currentPage+1, ...queryParams}}
    const lastPage = {pathname:path, query:{page:bookmarks.totalPages, ...queryParams}}
    console.log(previousPage)


    return (
        <div>
            <nav aria-label="Page navigation">
                <ul className="pagination d-flex justify-content-between " >
                <li className={"page-item" + (bookmarks.hasPrevious? "": "disabled")}>
                        <Link className="page-link" href={previousPage}>Previous</Link>
                    </li>
                    <li className={"page-item" + (bookmarks.hasNext? "": "disabled")}>
                        <Link className="page-link" href={lastPage}>Next</Link>
                    </li>
                </ul>
            </nav>
        </div>
    )
};

export default Pagination;