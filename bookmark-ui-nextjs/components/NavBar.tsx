import Image from "next/image";
import Link from "next/link";

export default function Navbar() {
  return (
      <header>
        <nav className={"navbar navbar-expand-lg bg-success"}>
          <div className={"container-fluid"}>

            <Link href="/" className="navbar-brand  text-white">NavBar</Link>
            {/* <a className={"navbar-brand  text-white"} href="#">Navbar</a> */}
            
            <button className={"navbar-toggler"} type="button" data-bs-toggle="collapse" data-bs-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
              <span className={"navbar-toggler-icon"}></span>
            </button>
            <div className={"collapse navbar-collapse"} id="navbarNav">
              {/* ms-auto: Bootstrap의 유틸리티 클래스 중 하나로, "margin start auto"를 의미합니다. 이는 해당 요소를 가능한 한 오른쪽으로 정렬합니다. (Bootstrap 5부터 사용됨) */}
              <ul className={"navbar-nav ms-auto"}>
                <li className={"nav-item"}>

                  <Link href="/bookmarks/add" className="nav-link active  text-white">Add Bookmark</Link>
                  {/* <a className={"nav-link active  text-white"} aria-current="page" href="#">Home</a> */}

                </li>
              </ul>
            </div>
          </div>
        </nav>
      </header>
  );
}
