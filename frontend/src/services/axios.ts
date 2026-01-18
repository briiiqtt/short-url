import axios, { AxiosError } from 'axios';

const api = axios.create({
  baseURL: '/api', // 절대경로 지정 없이 상대 경로를 쓰면 Vite 서버(5173)가 가로채서 백엔드(8080)로 넘겨주게 설정함 (vite.config.ts)
  timeout: 5000,
  headers: {
    'Content-Type': 'application/json',
  },
});

api.interceptors.response.use(
  (response) => {
    return response;
  },
  (error: AxiosError) => {
    if (error.status === 404) {
      // TODO: navigate to 404.html; should make 404 page first.
    }
    return Promise.reject(error);
  }
);

export default api;
