import { shortenUrl } from '@/services/urlService';
import { useMutation } from '@tanstack/react-query';

export const useShortenUrlMutation = () => {
  return useMutation({
    mutationFn: async (url: string) => await shortenUrl(url),
  });
};
