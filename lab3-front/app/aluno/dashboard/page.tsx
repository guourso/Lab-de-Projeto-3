"use client"

import * as React from "react"
import { AppSidebar } from "@/components/app-sidebar"
import {
  Breadcrumb,
  BreadcrumbItem,
  BreadcrumbLink,
  BreadcrumbList,
  BreadcrumbPage,
  BreadcrumbSeparator,
} from "@/components/ui/breadcrumb"
import { Separator } from "@/components/ui/separator"
import {
  SidebarInset,
  SidebarProvider,
  SidebarTrigger,
} from "@/components/ui/sidebar"
import {
  Card,
  CardContent,
  CardDescription,
  CardFooter,
  CardHeader,
  CardTitle,
} from "@/components/ui/card"
import { Button } from "@/components/ui/button"
import { Dialog, DialogContent, DialogTrigger } from "@/components/ui/dialog"

// Tipo para vantagem
type Vantagem = {
  id: string
  titulo: string
  descricao: string
  imagemUrl: string
}

// Mock de vantagens
const vantagens: Vantagem[] = [
  {
    id: "1",
    titulo: "Desconto na Livraria",
    descricao: "10% de desconto em todos os livros da livraria parceira.",
    imagemUrl: "https://offloadmedia.feverup.com/belohorizontesecreto.com/wp-content/uploads/2023/07/07100858/quixote-1024x768.jpg",
  },
  {
    id: "2",
    titulo: "Café Grátis",
    descricao: "Ganhe um café expresso no Café da Esquina.",
    imagemUrl: "/img/cafe.png",
  },
  {
    id: "3",
    titulo: "Ingresso para Cinema",
    descricao: "1 ingresso para qualquer sessão no CinePUC.",
    imagemUrl: "/img/cinema.png",
  },
]

export default function Page() {
  const [resgatada, setResgatada] = React.useState<Vantagem | null>(null)

  const handleResgatar = (vantagem: Vantagem) => {
    setResgatada(vantagem)
    // Aqui pode chamar API para efetuar a transação
    console.log("Resgatando:", vantagem)
  }

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

        <div className="flex flex-1 flex-col gap-4 p-4">
          <h1 className="text-2xl font-bold">Vantagens Disponíveis</h1>

          <div className="grid grid-cols-1 sm:grid-cols-2 md:grid-cols-3 gap-4">
            {vantagens.map((vantagem) => (
              <Card key={vantagem.id} className="hover:shadow-lg transition">
                <CardHeader>
                  <CardTitle>{vantagem.titulo}</CardTitle>
                  <CardDescription>{vantagem.descricao}</CardDescription>
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
                      <Button variant="default">Resgatar</Button>
                    </DialogTrigger>
                    <DialogContent>
                      <p className="text-lg font-semibold">
                        Deseja resgatar a vantagem:
                      </p>
                      <p className="mb-2">{vantagem.titulo}</p>
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
  )
}
