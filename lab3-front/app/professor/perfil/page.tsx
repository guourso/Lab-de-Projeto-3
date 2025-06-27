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
import {
  Avatar,
  AvatarFallback,
} from "@/components/ui/avatar"

// Mock de dados do professor
const professor = {
  nome: "Ana Clara Oliveira",
  email: "ana.oliveira@pucminas.br",
  instituicao: "PUC Minas",
}

function gerarIniciais(nome: string) {
  const partes = nome.trim().split(" ")
  if (partes.length === 1) return partes[0][0].toUpperCase()
  return `${partes[0][0]}${partes[partes.length - 1][0]}`.toUpperCase()
}

export default function PerfilProfessorPage() {
  return (
    <SidebarProvider>
      <AppSidebar role="PROFESSOR" />
      <SidebarInset>
        <header className="flex h-16 shrink-0 items-center gap-2 border-b px-4">
          <SidebarTrigger className="-ml-1" />
          <Separator
            orientation="vertical"
            className="mr-2 data-[orientation=vertical]:h-4"
          />
        </header>

        <div className="flex flex-1 flex-col gap-6 p-4">
          <h1 className="text-2xl font-bold">Perfil do Professor</h1>

          <Card>
            <CardHeader className="flex flex-row items-center gap-4">
              <Avatar className="h-16 w-16">
                <AvatarFallback className="text-xl font-semibold bg-muted text-foreground">
                  {gerarIniciais(professor.nome)}
                </AvatarFallback>
              </Avatar>
              <CardTitle className="text-xl">{professor.nome}</CardTitle>
            </CardHeader>

            <CardContent className="space-y-2">
              <div>
                <span className="font-medium text-muted-foreground">Instituição: </span>
                <span>{professor.instituicao}</span>
              </div>
              <div>
                <span className="font-medium text-muted-foreground">E-mail: </span>
                <span>{professor.email}</span>
              </div>
            </CardContent>
          </Card>
        </div>
      </SidebarInset>
    </SidebarProvider>
  )
}
