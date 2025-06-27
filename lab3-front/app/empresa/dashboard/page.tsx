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
  CardHeader,
  CardTitle,
  CardContent,
} from "@/components/ui/card"

import {
  ChartContainer,
  ChartTooltip,
  ChartLegend,
  ChartLegendContent,
  ChartConfig,
  ChartTooltipContent,
} from "@/components/ui/chart"
import { AreaChart, Area, XAxis, YAxis, CartesianGrid } from "recharts"

const totalResgates = 128

const data = [
  { mes: "Junho", "PUC Minas": 52, "UFMG": 38, "UNI-BH": 22, "Newton Paiva": 16 },
]

const chartConfig = {
  "PUC Minas": { label: "PUC Minas", color: "var(--chart-1)" },
  "UFMG": { label: "UFMG", color: "var(--chart-2)" },
  "UNI-BH": { label: "UNI-BH", color: "var(--chart-3)" },
  "Newton Paiva": { label: "Newton Paiva", color: "var(--chart-4)" },
} satisfies ChartConfig

export default function EmpresaDashboardPage() {
  return (
    <SidebarProvider>
      <AppSidebar role="EMPRESA" />
      <SidebarInset>
        <header className="flex h-16 items-center gap-2 border-b px-4">
          <SidebarTrigger className="-ml-1" />
          <Separator orientation="vertical" className="mr-2 h-4" />
        </header>

        <div className="flex flex-1 flex-col gap-6 p-4">
          <h1 className="text-2xl font-bold">Dashboard da Empresa</h1>

          <Card>
            <CardHeader>
              <CardTitle>Total de Resgates no Mês</CardTitle>
            </CardHeader>
            <CardContent>
              <p className="text-4xl font-bold text-primary">{totalResgates}</p>
            </CardContent>
          </Card>

          <Card>
            <CardHeader>
              <CardTitle>Resgates por Instituição</CardTitle>
            </CardHeader>
            <CardContent>
              <ChartContainer
                config={chartConfig}
                className="min-h-[250px] w-full"
              >
                <AreaChart data={data} margin={{ top: 20, right: 30, left: 0, bottom: 0 }}>
                  <CartesianGrid strokeDasharray="3 3" />
                  <XAxis dataKey="mes" />
                  <YAxis allowDecimals={false} />
                  <ChartTooltip content={<ChartTooltipContent nameKey="" />} />
                  {Object.keys(chartConfig).map((key) => (
                    <Area
                      key={key}
                      type="monotone"
                      dataKey={key}
                      stroke={chartConfig[key as keyof typeof chartConfig].color}
                      fill={chartConfig[key as keyof typeof chartConfig].color}
                      fillOpacity={0.2}
                    />
                  ))}
                </AreaChart>
                <ChartLegend content={<ChartLegendContent payload={undefined} />} />
              </ChartContainer>
            </CardContent>
          </Card>
        </div>
      </SidebarInset>
    </SidebarProvider>
  )
}
