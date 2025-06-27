"use client"

import * as React from "react"
import { AppSidebar } from "@/components/app-sidebar"
import {
  SidebarProvider,
  SidebarInset,
  SidebarTrigger,
} from "@/components/ui/sidebar"
import { Separator } from "@/components/ui/separator"
import {
  Card,
  CardContent,
  CardHeader,
  CardTitle,
} from "@/components/ui/card"

// Mock de dados do professor
const professor = {
  nome: "Prof. Ana Souza",
  instituicao: {
    nome: "PUC Minas",
    cidade: "Belo Horizonte",
    curso: "Engenharia de Software",
  },
  moedasDisponiveis: 300,
}

// Util para data atual
const formatarData = (data: Date) =>
  data.toLocaleDateString("pt-BR", {
    weekday: "long",
    day: "numeric",
    month: "long",
    year: "numeric",
  })

export default function ProfessorDashboardPage() {
  const dataHoje = formatarData(new Date())

  return (
    <SidebarProvider>
      <AppSidebar role="PROFESSOR" />
      <SidebarInset>
        <header className="flex h-16 items-center gap-2 border-b px-4">
          <SidebarTrigger className="-ml-1" />
          <Separator
            orientation="vertical"
            className="mr-2 data-[orientation=vertical]:h-4"
          />
        </header>

        <div className="flex flex-1 flex-col gap-6 p-4">
          <h1 className="text-2xl font-bold">Dashboard do Professor</h1>

          {/* Data atual */}
          <Card>
            <CardHeader>
              <CardTitle>Data Atual</CardTitle>
            </CardHeader>
            <CardContent>
              <p className="text-lg">{dataHoje}</p>
            </CardContent>
          </Card>

          {/* Info da Instituição */}
          <Card>
            <CardHeader>
              <CardTitle>Instituição</CardTitle>
            </CardHeader>
            <CardContent className="space-y-1">
              <p><span className="font-medium text-muted-foreground">Nome: </span>{professor.instituicao.nome}</p>
              <p><span className="font-medium text-muted-foreground">Cidade: </span>{professor.instituicao.cidade}</p>
              <p><span className="font-medium text-muted-foreground">Curso: </span>{professor.instituicao.curso}</p>
            </CardContent>
          </Card>

          {/* Moedas disponíveis */}
          <Card>
            <CardHeader>
              <CardTitle>Moedas Disponíveis</CardTitle>
            </CardHeader>
            <CardContent>
              <p className="text-3xl font-bold text-green-600">
                {professor.moedasDisponiveis} moedas
              </p>
            </CardContent>
          </Card>
        </div>
      </SidebarInset>
    </SidebarProvider>
  )
}
