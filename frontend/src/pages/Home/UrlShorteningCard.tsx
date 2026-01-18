import { useShortenUrlMutation } from '@/hooks/useUrlQuery';
import { isValidUrl } from '@/utils/url';
import { useState } from 'react';
import ShortenerForm from '@/pages/Home/ShortenerForm';
import ShortenedUrlBox from './ShortenedUrlBox';

const UrlShorteningCard: React.FC = () => {
  const [url, setUrl] = useState('');
  const [shortUrl, setShortUrl] = useState<string | null>(null);
  const [error, setError] = useState<string | null>(null);
  const [copied, setCopied] = useState(false);

  const { mutateAsync, isPending } = useShortenUrlMutation();

  const handleSubmit = async (e: React.FormEvent) => {
    e.preventDefault();
    setError(null);
    setCopied(false);
    setShortUrl(null);

    if (!url.trim()) {
      setError('URL을 입력하세요');
      return;
    }

    if (!isValidUrl(url)) {
      setError('올바른 URL 형식이 아닙니다');
      return;
    }

    try {
      const result = await mutateAsync(url);
      setShortUrl(import.meta.env.VITE_URL_BACKEND_EXTERNAL + '/' + result);
    } catch (e) {
      console.error(e);
      setError('단축 URL 생성에 실패했습니다');
      return;
    }
  };
  return (
    <>
      <div className="w-full max-w-2xl bg-white/70 backdrop-blur-xl rounded-2xl shadow-xl p-8 border border-slate-200/50">
        <ShortenerForm
          handleSubmit={handleSubmit}
          isPending={isPending}
          setUrl={setUrl}
          url={url}
        />

        {error && <p className="mt-3 text-sm text-red-500">{error}</p>}

        {shortUrl && (
          <ShortenedUrlBox
            copied={copied}
            setCopied={setCopied}
            shortUrl={shortUrl}
          />
        )}
      </div>
    </>
  );
};

export default UrlShorteningCard;
