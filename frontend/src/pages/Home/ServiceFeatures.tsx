import { useState } from 'react';

const ServiceFeatures = () => {
  const [openFaq, setOpenFaq] = useState<number | null>(null);

  const toggleFaq = (index: number) => {
    setOpenFaq(openFaq === index ? null : index);
  };

  const faqItems = [
    {
      question: '단축 URL의 만료 기간은 어떻게 되나요?',
      answer:
        '생성된 단축 URL은 만료 기간 없이 영구적으로 유지하고 있습니다.',
    },
    {
      question: '단축 URL을 삭제하려면 어떻게 하나요?',
      answer:
        '현재 회원 등록 기능을 제공하지 않고 있기 때문에, 생성된 URL을 삭제하는 기능은 지원하지 않습니다. 중요한 정보나 개인 정보가 포함된 링크는 사용에 주의해 주세요.',
    },
    {
        question: '서비스 이용은 정말 무료인가요?',
        answer: 'URL 단축 서비스는 100% 무료입니다. 회원가입이나 비용 청구 없이 자유롭게 이용하실 수 있습니다.'
    },
    {
        question: '단축된 URL의 클릭 수를 추적할 수 있나요?',
        answer: '회원 등록 기능과 함께 개발 예정입니다.'
    }
  ];

  return (
    <div className="w-full max-w-4xl mx-auto my-16 text-slate-700">
      <div className="space-y-16">
        <hr className="border-slate-200" />

        <section id='feature'>
          <h2 className="text-3xl font-bold text-center text-slate-800 mb-12">서비스 특징</h2>
          <div className="grid md:grid-cols-3 gap-8 text-center">
            <div className="bg-white p-8 rounded-xl border border-slate-200 shadow-sm">
                <div className="flex justify-center items-center mb-4 bg-blue-100 rounded-full w-16 h-16 mx-auto">
                    <svg className="w-8 h-8 text-blue-500" fill="none" stroke="currentColor" viewBox="0 0 24 24" xmlns="http://www.w3.org/2000/svg"><path strokeLinecap="round" strokeLinejoin="round" strokeWidth="2" d="M13 10V3L4 14h7v7l9-11h-7z"></path></svg>
                </div>
                <h3 className="font-semibold text-xl mb-2">빠른 속도</h3>
                <p className="text-slate-500">한 번의 클릭으로<br/>긴 URL을 짧게 변환</p>
            </div>
            <div className="bg-white p-8 rounded-xl border border-slate-200 shadow-sm">
                <div className="flex justify-center items-center mb-4 bg-green-100 rounded-full w-16 h-16 mx-auto">
                    <svg className="w-8 h-8 text-green-500" fill="none" stroke="currentColor" viewBox="0 0 24 24" xmlns="http://www.w3.org/2000/svg"><path strokeLinecap="round" strokeLinejoin="round" strokeWidth="2" d="M9 12l2 2 4-4m5.618-4.016A11.955 11.955 0 0112 2.944a11.955 11.955 0 01-8.618 3.04A12.02 12.02 0 003 20.944a12.02 12.02 0 009 3c4.524 0 8.32-2.484 10.038-6.143a11.955 11.955 0 00-2.42-8.811z"></path></svg>
                </div>
                <h3 className="font-semibold text-xl mb-2">안전한 서비스</h3>
                <p className="text-slate-500">보안을 중시한<br/>URL 관리 시스템</p>
            </div>
            <div className="bg-white p-8 rounded-xl border border-slate-200 shadow-sm">
                <div className="flex justify-center items-center mb-4 bg-red-100 rounded-full w-16 h-16 mx-auto">
                    <svg className="w-8 h-8 text-red-500" fill="none" stroke="currentColor" viewBox="0 0 24 24" xmlns="http://www.w3.org/2000/svg"><path strokeLinecap="round" strokeLinejoin="round" strokeWidth="2" d="M12 8v13m0-13V6a2 2 0 112 2h-2zm0 0V5.5A2.5 2.5 0 109.5 8H12zm-7 4h14M5 12a2 2 0 110-4h14a2 2 0 110 4M5 12v7a2 2 0 002 2h10a2 2 0 002-2v-7"></path></svg>
                </div>
                <h3 className="font-semibold text-xl mb-2">무료 이용</h3>
                <p className="text-slate-500">별도의 회원가입 없이<br/> 무료로 이용</p>
            </div>
          </div>
        </section>

        <hr className="border-slate-200" />
        
        <section id="faq">
            <h2 className="text-3xl font-bold text-center text-slate-800 mb-12">자주 묻는 질문</h2>
            <div className="max-w-2xl mx-auto">
            {faqItems.map((item, index) => (
                <div key={index} className="border-b border-slate-200 py-4">
                <button
                    onClick={() => toggleFaq(index)}
                    className="w-full flex justify-between items-center text-left"
                >
                    <span className="font-semibold text-lg text-slate-800">{item.question}</span>
                    <span className="text-xl text-slate-500">
                        {openFaq === index ? '−' : '+'}
                    </span>
                </button>
                {openFaq === index && (
                    <div className="mt-4 text-slate-600 bg-slate-50 p-4 rounded-lg">
                    <p>{item.answer}</p>
                    </div>
                )}
                </div>
            ))}
            </div>
        </section>

        <hr className="border-slate-200" />

        <div className="grid md:grid-cols-2 gap-12">
            <section>
                <h2 className="text-2xl font-bold text-slate-800 mb-6">활용 사례</h2>
                <ul className="space-y-3 list-disc list-inside text-slate-600">
                <li><span className="font-semibold">SNS 프로필 링크:</span> 인스타그램, 트위터, 페이스북 등 프로필에 간결한 링크를 추가하세요.</li>
                {/* <li><span className="font-semibold">QR 코드 삽입:</span> 짧은 URL로 QR 코드를 생성하여 오프라인 홍보물에 활용하세요.</li> */}
                <li><span className="font-semibold">블로그 포스팅:</span> 포스팅 내용과 관련된 긴 링크를 깔끔하게 공유할 수 있습니다.</li>
                <li><span className="font-semibold">오프라인 홍보:</span> 전단지, 명함, 포스터 등에 짧고 기억하기 쉬운 URL을 넣어보세요.</li>
                </ul>
            </section>

            <section>
                <h2 className="text-2xl font-bold text-slate-800 mb-6">사용자 후기</h2>
                <div className="space-y-6">
                    <blockquote className="border-l-4 border-slate-300 pl-4 italic text-slate-600">“입력 후 복사 한 번으로 끝나는 게 정말 편리합니다. UI도 직관적이라 마음에 들어요.”</blockquote>
                </div>
            </section>
        </div>
        
        <hr className="border-slate-200" />

        <footer id="about" className="text-center text-sm text-slate-500 py-8">
            <h2 className="text-xl font-semibold text-slate-700 mb-4">About Us</h2>
            <p className="max-w-xl mx-auto mb-6">이 페이지는 무료로 쉽고 빠른 URL 단축 서비스를 제공하는 웹서비스입니다.</p>
            <div className="flex justify-center space-x-6">
                <a href="/privacy-policy" className="hover:underline">개인정보 처리방침</a>
                <a href="mailto:example@example.com" className="hover:underline">문의하기</a>
            </div>
        </footer>
      </div>
    </div>
  );
};

export default ServiceFeatures;
