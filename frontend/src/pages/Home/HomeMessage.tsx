const HomeMessage: React.FC = () => {
    return (
      <header className="pt-30 mb-10 text-center">
        <h1 className="text-5xl md:text-6xl font-extrabold text-slate-900 tracking-tight">
          <span className="bg-gradient-to-r from-blue-500 to-indigo-500 bg-clip-text text-transparent">
            URL, 짧고 단순하게
          </span>
        </h1>
        <p className="mt-4 text-lg text-slate-600 max-w-xl mx-auto">
          복잡하고 긴 URL을 짧고 기억하기 쉬운 주소로 만들어 보세요<br/> 빠르고 간편하며, 무료입니다.
        </p>
      </header>
    );
  };
  
  export default HomeMessage;
  
