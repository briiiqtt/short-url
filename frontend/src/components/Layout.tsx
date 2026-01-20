// components/Layout.js
import { Outlet } from 'react-router-dom';
import Header from '@/components/Header';
import Footer from '@/components/Footer';

const Layout = () => {
  return (
    <>
      <div className="min-h-screen bg-gray-50 text-gray-800 antialiased">
        <div className="absolute top-0 left-0 w-full h-[500px] bg-gradient-to-br from-blue-50 to-indigo-100 -z-10"></div>
        <Header />
        <Outlet />
        <Footer />
      </div>
    </>
  );
};

export default Layout;
