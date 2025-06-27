import { useCallback } from "react";

export type Vantagem = {
  id: number;
  titulo: string;
  descricao: string;
  imagemUrl: string;
  valor: number;
  empresaId: number;
};

export function useVantagens() {
  const listarVantagens = useCallback(async () => {
    try {
      const response = await fetch("http://localhost:8080/api/vantagens");
      if (!response.ok) {
        throw new Error("Erro ao buscar vantagens");
      }
      return await response.json();
    } catch (error) {
      console.error("Erro:", error);
      throw error;
    }
  }, []);

  const resgatarVantagem = useCallback(
    async (vantagemId: number, alunoId: number) => {
      try {
        const response = await fetch(
          `http://localhost:8080/api/vantagens/${vantagemId}/resgatar`,
          {
            method: "POST",
            headers: {
              "Content-Type": "application/json",
            },
            body: JSON.stringify({ alunoId }),
          }
        );

        if (!response.ok) {
          throw new Error("Erro ao resgatar vantagem");
        }

        return await response.json();
      } catch (error) {
        console.error("Erro:", error);
        throw error;
      }
    },
    []
  );

  return {
    listarVantagens,
    resgatarVantagem,
  };
}
