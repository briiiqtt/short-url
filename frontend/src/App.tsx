import { BrowserRouter, Route, Routes } from "react-router-dom";
import Layout from "@/components/layout/Layout";
import Home from "./pages/Home";
import PrivacyPolicy from "./pages/PrivacyPolicy";
import TermsOfService from "./pages/TermsOfService";

const App: React.FC = () => {
  return (
    <>
    <BrowserRouter>
      <Routes>
        <Route path="/" element={<Layout />}>
          <Route index element={<Home />} />
          <Route path="privacy-policy" element={<PrivacyPolicy />} />
          <Route path="terms-of-service" element={<TermsOfService />} />
        </Route>
      </Routes>
    </BrowserRouter>
    </>
  );
};

export default App;
