import api from '@/services/axios';

export const shortenUrl = async (url: string): Promise<string | null> => {
  const { data } = await api.post(`/url/shorten`, {
    url,
  });
  return data.shortenUrl;
};
