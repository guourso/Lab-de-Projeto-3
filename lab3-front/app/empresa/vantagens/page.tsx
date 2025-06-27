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
  CardContent,
  CardHeader,
  CardTitle,
} from "@/components/ui/card"
import { Button } from "@/components/ui/button"
import {
  Dialog,
  DialogTrigger,
  DialogContent,
  DialogHeader,
  DialogTitle,
  DialogFooter,
} from "@/components/ui/dialog"
import { Input } from "@/components/ui/input"
import { Textarea } from "@/components/ui/textarea"

// Mock de vantagens
const vantagensMock = [
  {
    id: "1",
    titulo: "Desconto em cursos",
    descricao: "Ganhe 20% de desconto em cursos de tecnologia.",
    imagem: "https://via.placeholder.com/100",
  },
  {
    id: "2",
    titulo: "Voucher alimentação",
    descricao: "Receba R$50 em voucher alimentação para usar em restaurantes parceiros.",
    imagem: "https://via.placeholder.com/100",
  },
]

export default function EmpresaVantagensPage() {
  const [vantagens, setVantagens] = React.useState(vantagensMock)
  const [novaVantagem, setNovaVantagem] = React.useState({
    titulo: "",
    descricao: "",
    imagem: "",
  })

  const handleCriar = () => {
    const nova = {
      id: crypto.randomUUID(),
      ...novaVantagem,
    }
    setVantagens((prev) => [...prev, nova])
    setNovaVantagem({ titulo: "", descricao: "", imagem: "" })
  }

  return (
    <SidebarProvider>
      <AppSidebar role="EMPRESA" />
      <SidebarInset>
        <header className="flex h-16 items-center gap-2 border-b px-4">
          <SidebarTrigger className="-ml-1" />
          <Separator orientation="vertical" className="mr-2 h-4" />
        </header>

        <div className="flex flex-1 flex-col gap-6 p-4">
          <div className="flex justify-between items-center">
            <h1 className="text-2xl font-bold">Vantagens Cadastradas</h1>
            <Dialog>
              <DialogTrigger asChild>
                <Button>Nova Vantagem</Button>
              </DialogTrigger>
              <DialogContent>
                <DialogHeader>
                  <DialogTitle>Nova Vantagem</DialogTitle>
                </DialogHeader>
                <div className="space-y-4 py-4">
                  <Input
                    placeholder="Título"
                    value={novaVantagem.titulo}
                    onChange={(e) =>
                      setNovaVantagem({ ...novaVantagem, titulo: e.target.value })
                    }
                  />
                  <Textarea
                    placeholder="Descrição"
                    value={novaVantagem.descricao}
                    onChange={(e) =>
                      setNovaVantagem({ ...novaVantagem, descricao: e.target.value })
                    }
                  />
                  <Input
                    placeholder="URL da imagem"
                    value={novaVantagem.imagem}
                    onChange={(e) =>
                      setNovaVantagem({ ...novaVantagem, imagem: e.target.value })
                    }
                  />
                </div>
                <DialogFooter>
                  <Button onClick={handleCriar} disabled={!novaVantagem.titulo}>
                    Cadastrar
                  </Button>
                </DialogFooter>
              </DialogContent>
            </Dialog>
          </div>

          <div className="grid grid-cols-1 sm:grid-cols-2 md:grid-cols-3 gap-4">
            {vantagens.map((vantagem) => (
              <Card key={vantagem.id}>
                <CardHeader>
                  <CardTitle>{vantagem.titulo}</CardTitle>
                </CardHeader>
                <CardContent className="space-y-2">
                  <img
                    src={vantagem.imagem}
                    alt={vantagem.titulo}
                    className="w-full h-32 object-cover rounded-md"
                  />
                  <p className="text-sm text-muted-foreground">
                    {vantagem.descricao}
                  </p>
                </CardContent>
              </Card>
            ))}
          </div>
        </div>
      </SidebarInset>
    </SidebarProvider>
  )
}
