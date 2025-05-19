import { StrictMode } from "react";
import { createRoot } from "react-dom/client";


import App from "./App";

import { QueryClient, QueryClientProvider } from "@tanstack/react-query";
import { AuthProvider } from "./contexts/AuthContext";
import { ThemeProvider } from "./contexts/ThemeContext";
import { QueryProvider } from "./contexts/QueryProvider";
import { GlobalStyle } from "./styles/globalStyles";


const queryClient = new QueryClient({
  defaultOptions: {
    queries: {
      refetchOnWindowFocus: false,
      staleTime: 60 * 1000,
    },
  },
});

createRoot(document.getElementById("root")!).render(
  <StrictMode>
    <QueryClientProvider client={queryClient}>
      <AuthProvider>
          <ThemeProvider>
            <QueryProvider>
              <GlobalStyle />
              <App />
            </QueryProvider>
          </ThemeProvider>
      </AuthProvider>
    </QueryClientProvider>
  </StrictMode>
);