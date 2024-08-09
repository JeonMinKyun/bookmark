/** @type {import('next').NextConfig} */

const nextConfig = {
    reactStrictMode: true,
    swcMinify: true,
    // experimental: {
    //   optimizeFonts: false, // 폰트 최적화 비활성화
    // },
    async redirects() { //async redirects(): 비동기 메소드로 리다이렉션 규칙을 설정합니다.
      return [
        {
          source: '/', //리다이렉션할 출발지 URL 패턴.
          destination: '/bookmarks', //리다이렉션할 도착지 URL.
          permanent: true //리다이렉션이 영구적인지 여부를 결정합니다.
        }
      ];
    },
    env: {
      SERVER_SIDE_API_BASE_URL: process.env.SERVER_SIDE_API_BASE_URL,
      NEXT_PUBLIC_CLIENT_SIDE_API_BASE_URL: process.env.NEXT_PUBLIC_CLIENT_SIDE_API_BASE_URL,
    },
  };

  
  
export default nextConfig;
