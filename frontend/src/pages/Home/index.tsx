import HomeMessage from '@/pages/Home/HomeMessage';

import UrlShorteningCard from '@/pages/Home/UrlShorteningCard';
import ServiceFeatures from '@/pages/Home/ServiceFeatures';

export const Home: React.FC = () => {
  return (
    <>
      <main className="flex-1 flex flex-col items-center justify-center px-4">
        <HomeMessage />
        <UrlShorteningCard />
        <ServiceFeatures />
      </main>
    </>
  );
};
export default Home;
