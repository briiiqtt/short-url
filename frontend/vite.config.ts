import { defineConfig, loadEnv } from 'vite';
import react from '@vitejs/plugin-react';
import tailwindcss from '@tailwindcss/vite';
import path from 'path';

export default defineConfig(({ mode }) => {
  const env = loadEnv(mode, process.cwd(), '');

  return {
    plugins: [react(), tailwindcss()],
    server: {
      watch: {
        usePolling: true,
      },
      host: true,
      strictPort: true,
      proxy: {
        // '/api'로 시작하는 요청을 가로챔
        '/api': {
          target: env.VITE_URL_BACKEND_INTERNAL,
          changeOrigin: true, // 대상 서버의 호스트 헤더를 target 주소로 변경
          // secure: false, // TODO: SSL 인증서 무시 (https 사용 시)
        },
      },
    },
    resolve: {
      alias: {
        '@': path.resolve(__dirname, './src'),
      },
    },
  };
});
