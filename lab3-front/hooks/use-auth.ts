import React, { createContext, useContext, useState, useCallback } from "react";

type User = {
  id: number;
  nome: string;
  email: string;
  role: "ALUNO" | "PROFESSOR" | "EMPRESA";
  saldoMoedas?: number;
};

type AuthContextType = {
  user: User | null;
  login: (email: string, password: string) => Promise<void>;
  logout: () => void;
};

const AuthContext = createContext<AuthContextType | null>(null);

export function AuthProvider({ children }: { children: React.ReactNode }) {
  const [user, setUser] = useState<User | null>(null);

  const login = useCallback(async (email: string, password: string) => {
    try {
      const response = await fetch("http://localhost:8080/api/auth/login", {
        method: "POST",
        headers: {
          "Content-Type": "application/json",
        },
        body: JSON.stringify({ email, password }),
      });

      if (!response.ok) {
        throw new Error("Falha na autenticação");
      }

      const data = await response.json();
      setUser(data);
    } catch (error) {
      console.error("Erro de login:", error);
      throw error;
    }
  }, []);

  const logout = useCallback(() => {
    setUser(null);
  }, []);

  return React.createElement(
    AuthContext.Provider,
    { value: { user, login, logout } },
    children
  );
}

export function useAuth() {
  const context = useContext(AuthContext);
  if (!context) {
    throw new Error("useAuth deve ser usado dentro de um AuthProvider");
  }
  return context;
}
