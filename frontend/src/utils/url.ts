export const handleCopy = async (url: string): Promise<boolean> => {
  if (!url) return false;
  await navigator.clipboard.writeText(url);
  return true;
};

export const isValidUrl = (value: string): boolean => {
  try {
    new URL(value);
    return true;
  } catch {
    return false;
  }
};
