const Footer: React.FC = () => {
    return (
      <footer className="bg-white border-t border-slate-200 mt-auto">
        <div className="container mx-auto px-4 py-12">
          <div className="grid grid-cols-2 md:grid-cols-4 gap-8">
            <div className="col-span-2 md:col-span-1">
              <h3 className="text-lg font-bold text-slate-900">shorturl</h3>
              <p className="text-sm text-slate-500 mt-2">간편한 URL 단축 서비스</p>
            </div>
            <div>
              <h4 className="font-semibold text-slate-800 mb-3">Product</h4>
              <ul className="space-y-2 text-sm text-slate-600">
                <li><a href="/#feature" className="hover:text-indigo-600">주요 특징</a></li>
                <li><a href="/#faq" className="hover:text-indigo-600">자주 묻는 질문</a></li>
                <li><a href="/#about" className="hover:text-indigo-600">About Us</a></li>
              </ul>
            </div>
            <div>
              <h4 className="font-semibold text-slate-800 mb-3">Legal</h4>
              <ul className="space-y-2 text-sm text-slate-600">
                <li><a href="/terms-of-service" className="hover:text-indigo-600">이용약관</a></li>
                <li><a href="/privacy-policy" className="hover:text-indigo-600">개인정보 처리방침</a></li>
              </ul>
            </div>
            <div>
              <h4 className="font-semibold text-slate-800 mb-3">Socials</h4>
              <div className="flex space-x-4">
                <a href="https://github.com/briiiqtt/short-url" target="_blank" rel="noopener noreferrer" className="text-slate-500 hover:text-slate-900">
                  <svg className="w-6 h-6" viewBox="0 0 24 24" fill="currentColor"><path d="M12 0c-6.626 0-12 5.373-12 12 0 5.302 3.438 9.8 8.207 11.387.599.111.793-.261.793-.577v-2.234c-3.338.726-4.033-1.416-4.033-1.416-.546-1.387-1.333-1.756-1.333-1.756-1.089-.745.083-.729.083-.729 1.205.084 1.839 1.237 1.839 1.237 1.07 1.834 2.807 1.304 3.492.997.107-.775.418-1.305.762-1.604-2.665-.305-5.467-1.334-5.467-5.931 0-1.311.469-2.381 1.236-3.221-.124-.303-.535-1.524.117-3.176 0 0 1.008-.322 3.301 1.23.957-.266 1.983-.399 3.003-.404 1.02.005 2.047.138 3.006.404 2.291-1.552 3.297-1.23 3.297-1.23.653 1.653.242 2.874.118 3.176.77.84 1.235 1.91 1.235 3.221 0 4.609-2.807 5.624-5.479 5.921.43.372.823 1.102.823 2.222v3.293c0 .319.192.694.801.576 4.765-1.589 8.199-6.086 8.199-11.386 0-6.627-5.373-12-12-12z"/></svg>
                </a>
              </div>
            </div>
          </div>
          <div className="mt-12 border-t border-slate-200 pt-8 text-center text-sm text-slate-500">
            <p>&copy; {new Date().getFullYear()} shorturl. All rights reserved.</p>
          </div>
        </div>
      </footer>
    );
  };
  export default Footer;
