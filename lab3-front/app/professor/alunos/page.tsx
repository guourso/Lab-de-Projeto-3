"use client"

import * as React from "react"
import {
  SidebarProvider,
  SidebarInset,
  SidebarTrigger,
} from "@/components/ui/sidebar"
import { AppSidebar } from "@/components/app-sidebar"
import { Separator } from "@/components/ui/separator"
import {
  Card,
  CardHeader,
  CardTitle,
  CardContent,
} from "@/components/ui/card"
import { Button } from "@/components/ui/button"
import { Input } from "@/components/ui/input"
import {
  Dialog,
  DialogContent,
  DialogTrigger,
  DialogHeader,
  DialogTitle,
  DialogFooter,
} from "@/components/ui/dialog"

// Mock dos alunos
const alunos = [
  { id: "1", nome: "Lucas Andrade", email: "lucas@aluno.com" },
  { id: "2", nome: "Mariana Silva", email: "mariana@aluno.com" },
  { id: "3", nome: "Pedro Lima", email: "pedro@aluno.com" },
]

export default function GerenciarAlunosPage() {
  const [alunoSelecionado, setAlunoSelecionado] = React.useState<null | (typeof alunos)[0]>(null)
  const [valor, setValor] = React.useState("")

  const handleEnviar = () => {
    console.log(`Enviando ${valor} moedas para ${alunoSelecionado?.nome}`)
    setValor("")
  }

  return (
    <SidebarProvider>
      <AppSidebar role="PROFESSOR" />
      <SidebarInset>
        <header className="flex h-16 items-center gap-2 border-b px-4">
          <SidebarTrigger className="-ml-1" />
          <Separator orientation="vertical" className="mr-2 h-4" />
        </header>

        <div className="flex flex-1 flex-col gap-6 p-4">
          <h1 className="text-2xl font-bold">Gerenciar Alunos</h1>

          <div className="grid grid-cols-1 md:grid-cols-2 gap-4">
            {alunos.map((aluno) => (
              <Card key={aluno.id}>
                <CardHeader>
                  <CardTitle>{aluno.nome}</CardTitle>
                </CardHeader>
                <CardContent className="flex flex-col gap-2">
                  <p className="text-sm text-muted-foreground">{aluno.email}</p>
                  <Dialog>
                    <DialogTrigger asChild>
                      <Button onClick={() => setAlunoSelecionado(aluno)}>
                        Enviar Moedas
                      </Button>
                    </DialogTrigger>
                    <DialogContent>
                      <DialogHeader>
                        <DialogTitle>Enviar moedas para {aluno.nome}</DialogTitle>
                      </DialogHeader>
                      <div className="flex flex-col gap-4 py-4">
                        <Input
                          type="number"
                          placeholder="Quantidade de moedas"
                          value={valor}
                          onChange={(e) => setValor(e.target.value)}
                        />
                      </div>
                      <DialogFooter>
                        <Button onClick={handleEnviar} disabled={!valor}>
                          Confirmar Envio
                        </Button>
                      </DialogFooter>
                    </DialogContent>
                  </Dialog>
                </CardContent>
              </Card>
            ))}
          </div>
        </div>
      </SidebarInset>
    </SidebarProvider>
  )
}
