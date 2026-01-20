const TermsOfService = () => {
    return (
      <main className="container mx-auto px-4 py-12">
        <div className="max-w-3xl mx-auto bg-white p-8 rounded-lg shadow-md border border-slate-200">
          <h1 className="text-3xl font-bold mb-6 text-slate-900">이용약관</h1>
          <div className="space-y-4 text-slate-700">
            <h2 className="text-xl font-semibold pt-4">제1조 (목적)</h2>
            <p>
              이 약관은 bri-url(이하 "회사")이 제공하는 URL 단축 서비스(이하 "서비스")의 이용과 관련하여 회사와 사용자 간의 권리, 의무 및 책임사항, 기타 필요한 사항을 규정함을 목적으로 합니다.
            </p>
            <h2 className="text-xl font-semibold pt-4">제2조 (서비스의 제공)</h2>
            <p>
              1. 회사는 사용자에게 긴 URL 주소를 짧은 주소로 변환해주는 서비스를 무료로 제공합니다.
              <br />
              2. 서비스는 연중무휴, 1일 24시간 제공함을 원칙으로 합니다. 단, 시스템 정기점검, 증설 및 교체 등의 사유가 발생한 경우 서비스 제공이 일시적으로 중단될 수 있습니다.
            </p>
            <h2 className="text-xl font-semibold pt-4">제3조 (사용자의 의무)</h2>
            <p>
              1. 사용자는 다음 행위를 하여서는 안 됩니다.
              <br />- 불법적이거나 악의적인 콘텐츠(스팸, 피싱, 멀웨어 등)로 연결되는 URL을 단축하는 행위
              <br />- 서비스의 안정적 운영을 방해하는 과도한 트래픽을 유발하는 행위
              <br />- 기타 불법적이거나 부당한 행위
              <br />
              2. 위 사항을 위반할 경우, 회사는 사전 통보 없이 해당 단축 URL을 비활성화하거나 삭제할 수 있습니다.
            </p>
            <h2 className="text-xl font-semibold pt-4">제4조 (면책조항)</h2>
            <p>
              1. 회사는 천재지변 또는 이에 준하는 불가항력으로 인하여 서비스를 제공할 수 없는 경우에는 서비스 제공에 관한 책임이 면제됩니다.
              <br />
              2. 단축된 URL을 통해 발생하는 모든 법적 문제나 분쟁에 대한 책임은 전적으로 해당 URL을 생성하고 배포한 사용자에게 있습니다.
            </p>
          </div>
        </div>
      </main>
    );
  };
  
  export default TermsOfService;
  