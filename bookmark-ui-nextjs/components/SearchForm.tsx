"use client";
import { useRouter } from 'next/navigation';
//클라이언트 컴포넌트에서 비동기 작업을 직접적으로 수행할 수는 없지만, 
//useEffect 또는 이벤트 핸들러에서 async/await를 사용할 수 있습니다.
import { useState } from 'react';


const SearchForm : React.FC = ()=>{
    const router = useRouter();
    const [query,setQuery] = useState("");

    const handleSearch = async (e: React.SyntheticEvent) => {
        e.preventDefault();
        if(query === "") {
            router.push(`/bookmarks`)
            return;
        }
        
        router.push(`/bookmarks?page=1&query=${encodeURIComponent(query)}`)
    };

    return (
        <div className="pb-4">
            <form className="d-flex" role="search" onSubmit={handleSearch}>
                <input className="form-control me-2" type="search" placeholder="Search" value={query} onChange={e => setQuery(e.target.value)}/>
                <button className="btn btn-outline-success" type="submit">Search</button>
            </form>
        </div>
    )
}

export default SearchForm;