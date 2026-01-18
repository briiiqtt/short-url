import { handleCopy } from '@/utils/url';
import type { Dispatch, SetStateAction } from 'react';

interface Props {
  shortUrl: string;
  copied: boolean;
  setCopied: Dispatch<SetStateAction<boolean>>;
}
const ShortenedUrlBox: React.FC<Props> = ({ shortUrl, copied, setCopied }) => {
  return (
    <>
      <div className="mt-6 rounded-xl border border-slate-200 bg-slate-50 p-4 flex items-center justify-between transition-all duration-300 ease-in-out">
        <a
          href={shortUrl}
          target="_blank"
          rel="noopener noreferrer"
          className="text-base font-medium text-indigo-600 truncate hover:underline"
        >
          {shortUrl}
        </a>
        <button
          onClick={async () => setCopied(await handleCopy(shortUrl))}
          className={`ml-4 text-sm rounded-md px-4 py-2 font-semibold transition-all ${
            copied
              ? 'bg-green-500 text-white'
              : 'bg-white border border-slate-300 text-slate-700 hover:bg-slate-100'
          }`}
        >
          {copied ? '복사 완료!' : '복사'}
        </button>
      </div>
    </>
  );
};

export default ShortenedUrlBox;