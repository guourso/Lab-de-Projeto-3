"use client"

import * as React from "react"
import { AppSidebar } from "@/components/app-sidebar"
import {
  SidebarInset,
  SidebarProvider,
  SidebarTrigger,
} from "@/components/ui/sidebar"
import { Separator } from "@/components/ui/separator"
import {
  Card,
  CardContent,
  CardHeader,
  CardTitle,
} from "@/components/ui/card"
import { Badge } from "@/components/ui/badge"
import { cn } from "@/lib/utils"

// Mock de saldo e extrato
const saldoAtual = 120

const transacoes: Transacao[] = [
  {
    id: "1",
    tipo: "ENTRADA",
    descricao: "Participação em evento",
    valor: 50,
    data: "2025-06-01",
  },
  {
    id: "2",
    tipo: "ENTRADA",
    descricao: "Entrega de atividade",
    valor: 30,
    data: "2025-06-10",
  },
  {
    id: "3",
    tipo: "RESGATE",
    descricao: "Desconto na livraria",
    valor: -20,
    data: "2025-06-15",
  },
  {
    id: "4",
    tipo: "RESGATE",
    descricao: "Café grátis",
    valor: -40,
    data: "2025-06-20",
  },
]

export default function Page() {
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
        </header>

        <div className="flex flex-1 flex-col gap-6 p-4">
          <h1 className="text-2xl font-bold">Minhas Moedas</h1>

          {/* Saldo */}
          <Card>
            <CardHeader>
              <CardTitle>Saldo Atual</CardTitle>
            </CardHeader>
            <CardContent>
              <p className="text-3xl font-semibold text-green-600">
                {saldoAtual} moedas
              </p>
            </CardContent>
          </Card>

          {/* Extrato */}
          <div className="flex flex-col gap-4">
            <h2 className="text-xl font-semibold">Extrato</h2>
            <div className="flex flex-col gap-2">
              {transacoes.map((tx) => (
                <Card key={tx.id}>
                  <CardContent className="py-4 px-6 flex justify-between items-center">
                    <div>
                      <p className="font-medium">{tx.descricao}</p>
                      <p className="text-sm text-muted-foreground">
                        {new Date(tx.data).toLocaleDateString()}
                      </p>
                    </div>
                    <div className="flex items-center gap-2">
                      <Badge
                        variant="outline"
                        className={cn(
                          tx.tipo === "ENTRADA" ? "text-green-600 border-green-600" : "text-red-600 border-red-600"
                        )}
                      >
                        {tx.tipo === "ENTRADA" ? "Entrada" : "Resgate"}
                      </Badge>
                      <p
                        className={cn(
                          "font-semibold",
                          tx.valor > 0 ? "text-green-600" : "text-red-600"
                        )}
                      >
                        {tx.valor > 0 ? `+${tx.valor}` : tx.valor} moedas
                      </p>
                    </div>
                  </CardContent>
                </Card>
              ))}
            </div>
          </div>
        </div>
      </SidebarInset>
    </SidebarProvider>
  )
}
