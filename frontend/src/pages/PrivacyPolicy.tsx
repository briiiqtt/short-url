const PrivacyPolicy = () => {
    return (
      <main className="container mx-auto px-4 py-12">
        <div className="max-w-3xl mx-auto bg-white p-8 rounded-lg shadow-md border border-slate-200">
          <h1 className="text-3xl font-bold mb-6 text-slate-900">개인정보 처리방침</h1>
          <div className="space-y-4 text-slate-700">
            <h2 className="text-xl font-semibold pt-4">1. 총칙</h2>
            <p>
              briii-url(이하 "회사")은 사용자의 개인정보를 중요시하며, "정보통신망 이용촉진 및 정보보호"에 관한 법률을 준수하고 있습니다. 회사는 개인정보처리방침을 통하여 사용자가 제공하는 개인정보가 어떠한 용도와 방식으로 이용되고 있으며, 개인정보보호를 위해 어떠한 조치가 취해지고 있는지 알려드립니다.
            </p>
            <h2 className="text-xl font-semibold pt-4">2. 수집하는 개인정보 항목</h2>
            <p>
              회사는 URL 단축 서비스 제공을 위해 아래와 같은 개인정보를 수집하고 있습니다.
              <br />- 수집 항목: 사용자가 입력한 긴 URL
              <br />- 개인정보 수집방법: 웹사이트
            </p>
            <p>
              본 서비스는 별도의 회원가입 절차를 거치지 않으므로, URL 외에 식별 가능한 개인정보(이름, 이메일, 연락처 등)를 수집하지 않습니다.
            </p>
            <h2 className="text-xl font-semibold pt-4">3. 개인정보의 수집 및 이용목적</h2>
            <p>
              회사는 수집한 개인정보를 다음의 목적을 위해 활용합니다.
              <br />- 긴 URL을 단축 URL로 변환하는 서비스 제공
            </p>
            <h2 className="text-xl font-semibold pt-4">4. 개인정보의 보유 및 이용기간</h2>
            <p>
              생성된 단축 URL과 원본 URL 정보는 서비스의 영속성을 위해 영구적으로 보관됩니다. 사용자가 민감한 정보를 포함하는 URL을 단축한 경우, 해당 정보에 대한 책임은 사용자에게 있습니다.
            </p>
          </div>
        </div>
      </main>
    );
  };
  
  export default PrivacyPolicy;
  