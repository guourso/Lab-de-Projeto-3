"use client";

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
  login: (email: string, senha: string) => Promise<void>;
  logout: () => void;
};

const AuthContext = createContext<AuthContextType | null>(null);

export function AuthProvider({ children }: { children: React.ReactNode }) {
  const [user, setUser] = useState<User | null>(null);
  const login = useCallback(async (email: string, senha: string) => {
    try {
      const response = await fetch("http://localhost:8080/api/auth/login", {
        method: "POST",
        headers: {
          "Content-Type": "application/json",
        },
        body: JSON.stringify({ email, senha }),
      });

      if (!response.ok) {
        const error = await response.json();
        throw new Error(error.message || "Falha na autenticação");
      }

      const data = await response.json();
      setToken(data.token);
      setUser({
        id: data.id,
        nome: data.nome,
        email: data.email,
        role: data.role,
        saldoMoedas: data.saldoMoedas,
      });
    } catch (error) {
      console.error("Erro de login:", error);
      throw error;
    }
  }, []);

  const [token, setToken] = React.useState<string | null>(null);

  const logout = useCallback(async () => {
    if (token) {
      try {
        await fetch("http://localhost:8080/api/auth/logout", {
          method: "POST",
          headers: {
            Authorization: `Bearer ${token}`,
          },
        });
      } catch (error) {
        console.error("Erro ao fazer logout:", error);
      }
    }
    setUser(null);
    setToken(null);
  }, [token]);

  return (
    <AuthContext.Provider value={{ user, login, logout }}>
      {children}
    </AuthContext.Provider>
  );
}

export function useAuth() {
  const context = useContext(AuthContext);
  if (!context) {
    throw new Error("useAuth deve ser usado dentro de um AuthProvider");
  }
  return context;
}
