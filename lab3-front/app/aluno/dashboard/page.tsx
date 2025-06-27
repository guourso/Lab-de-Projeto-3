"use client";

import * as React from "react";
import { useRouter } from "next/navigation";
import { AppSidebar } from "@/components/app-sidebar";
import { Separator } from "@/components/ui/separator";
import {
  SidebarInset,
  SidebarProvider,
  SidebarTrigger,
} from "@/components/ui/sidebar";
import {
  Card,
  CardContent,
  CardDescription,
  CardFooter,
  CardHeader,
  CardTitle,
} from "@/components/ui/card";
import { Button } from "@/components/ui/button";
import { Dialog, DialogContent, DialogTrigger } from "@/components/ui/dialog";
import { useVantagens, type Vantagem } from "@/hooks/use-vantagens";
import { useAuth } from "@/hooks/use-auth";

export default function Page() {
  const router = useRouter();
  const { user } = useAuth();
  const { listarVantagens, resgatarVantagem } = useVantagens();
  const [vantagens, setVantagens] = React.useState<Vantagem[]>([]);
  const [loading, setLoading] = React.useState(true);
  const [error, setError] = React.useState<string | null>(null);

  React.useEffect(() => {
    if (!user || user.role !== "ALUNO") {
      router.push("/login");
      return;
    }

    const fetchVantagens = async () => {
      try {
        const data = await listarVantagens();
        setVantagens(data);
      } catch (err) {
        setError("Erro ao carregar vantagens");
      } finally {
        setLoading(false);
      }
    };

    fetchVantagens();
  }, [listarVantagens, user, router]);

  const handleResgatar = async (vantagem: Vantagem) => {
    if (!user) return;

    try {
      await resgatarVantagem(vantagem.id, user.id);
      // Atualizar a lista de vantagens após o resgate
      const updatedVantagens = await listarVantagens();
      setVantagens(updatedVantagens);
    } catch (err) {
      setError("Erro ao resgatar vantagem");
    }
  };

  if (loading) {
    return <div>Carregando...</div>;
  }

  if (error) {
    return <div>Erro: {error}</div>;
  }

  return (
    <SidebarProvider>
      <AppSidebar role="ALUNO" />
      <SidebarInset>
        <header className="flex h-16 shrink-0 items-center gap-2 border-b px-4">
          <SidebarTrigger className="-ml-1" />
          <Separator
            orientation="vertical"
            className="mr-2 data-[orientation=vertical]:h-4"
          />
          <div className="ml-auto">Saldo: {user?.saldoMoedas} moedas</div>
        </header>

        <div className="flex flex-1 flex-col gap-4 p-4">
          <h1 className="text-2xl font-bold">Vantagens Disponíveis</h1>

          <div className="grid grid-cols-1 sm:grid-cols-2 md:grid-cols-3 gap-4">
            {vantagens.map((vantagem) => (
              <Card key={vantagem.id} className="hover:shadow-lg transition">
                <CardHeader>
                  <CardTitle>{vantagem.titulo}</CardTitle>
                  <CardDescription>{vantagem.descricao}</CardDescription>
                  <CardDescription className="font-semibold text-primary">
                    Valor: {vantagem.valor} moedas
                  </CardDescription>
                </CardHeader>
                <CardContent>
                  <img
                    src={vantagem.imagemUrl}
                    alt={vantagem.titulo}
                    className="w-full h-40 object-cover rounded-md"
                  />
                </CardContent>
                <CardFooter>
                  <Dialog>
                    <DialogTrigger asChild>
                      <Button
                        variant="default"
                        disabled={
                          user?.saldoMoedas
                            ? user.saldoMoedas < vantagem.valor
                            : true
                        }
                      >
                        Resgatar
                      </Button>
                    </DialogTrigger>
                    <DialogContent>
                      <p className="text-lg font-semibold">
                        Deseja resgatar a vantagem:
                      </p>
                      <p className="mb-2">{vantagem.titulo}</p>
                      <p className="mb-4">Valor: {vantagem.valor} moedas</p>
                      <Button
                        onClick={() => handleResgatar(vantagem)}
                        className="w-full"
                      >
                        Confirmar Resgate
                      </Button>
                    </DialogContent>
                  </Dialog>
                </CardFooter>
              </Card>
            ))}
          </div>
        </div>
      </SidebarInset>
    </SidebarProvider>
  );
}
