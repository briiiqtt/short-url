# frontend 규칙

## 디렉토리 구조 지향점

src/  
├── assets/　　　　　　이미지, 아이콘, 폰트 등  
├── components/　　　재사용 가능한 UI 컴포넌트  
│   ├── layout/　　　　　Header, Footer, Sidebar 등  
│   └── common/　　　　버튼, 인풋 등 공통 요소  
├── hooks/ 　　　　　　커스텀 훅  
├── pages/　　　　　　화면 단위 컴포넌트  
├── services/　　　　　API 호출 관련 로직  
├── utils/　　　　　　　순수 유틸 함수  
└── App.tsx　　　　　　라우팅 및 진입점  

## 페이지와 컴포넌트 구분하기
Pages: API 호출 등 데이터를 fetch 하고, 여러 컴포넌트를 조합합니다. (똑똑한 컴포넌트)  

Components: 받은 Props를 보여주기만 합니다. (순수한 컴포넌트)

## 절대 경로(Absolute Path) 사용
../../../components/Button 같은 상황을 피하기 위해 절대 경로를 사용합니다.  

vite.config.ts에서 @를 src 폴더로 연결합니다.
`import Button from '@/components/SomeComponent'`