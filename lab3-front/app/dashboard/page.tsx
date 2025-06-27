"use client"

import { useState } from "react"
import { AppSidebar } from "@/components/app-sidebar"
import { Button } from "@/components/ui/button"
import { Separator } from "@/components/ui/separator"
import {
  SidebarInset,
  SidebarProvider,
  SidebarTrigger,
} from "@/components/ui/sidebar"
import { useApi } from "@/hooks/use-api"

export default function Page() {
  const api = useApi({ withAuth: false })
  const [loading, setLoading] = useState(false)

  async function checkHealth() {
    setLoading(true)
    try {
      const response = await api.get("/auth/health")
      alert(`Status: ${response.status} - ${response.data}`)
      console.log(response.data)
    } catch (error) {
      alert("Erro ao acessar /health")
      console.error(error)
    } finally {
      setLoading(false)
    }
  }

  return (
    <SidebarProvider>
      <AppSidebar role="EMPRESA" />
      <SidebarInset>
        <header className="flex h-16 shrink-0 items-center gap-2 border-b px-4">
          <SidebarTrigger className="-ml-1" />
          <Separator
            orientation="vertical"
            className="mr-2 data-[orientation=vertical]:h-4"
          />
        </header>
        <div className="flex flex-1 flex-col gap-4 p-4">
          <Button
            variant="default"
            className="w-full"
            onClick={checkHealth}
            disabled={loading}
          >
            {loading ? "Verificando..." : "Health"}
          </Button>
        </div>
      </SidebarInset>
    </SidebarProvider>
  )
}
