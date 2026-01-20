import type { Dispatch, SetStateAction } from 'react';
import type React from 'react';

interface Props {
  handleSubmit: (event: React.FormEvent) => void;
  url: string;
  setUrl: Dispatch<SetStateAction<string>>;
  isPending: boolean;
}
const ShortenerForm: React.FC<Props> = ({ handleSubmit, url, setUrl, isPending }) => {
  return (
    <>
      <form onSubmit={handleSubmit} className="flex flex-col sm:flex-row gap-3">
        <input
          type="url"
          placeholder="https://example.com 등 URL을 입력하세요"
          value={url}
          onChange={(e) => setUrl(e.target.value)}
          disabled={isPending}
          className="flex-1 rounded-lg border border-slate-300 px-4 py-3 text-base focus:outline-none focus:ring-2 focus:ring-indigo-500 transition-shadow"
        />
        <button
          type="submit"
          disabled={isPending}
          className="rounded-lg bg-indigo-600 px-6 py-3 text-base font-semibold text-white hover:bg-indigo-700 disabled:opacity-50 disabled:cursor-not-allowed transition-all transform hover:scale-105"
        >
          {isPending ? '처리 중...' : 'URL 줄이기'}
        </button>
      </form>
    </>
  );
};

export default ShortenerForm;
