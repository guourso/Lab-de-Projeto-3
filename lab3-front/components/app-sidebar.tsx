import * as React from "react"

import { VersionSwitcher } from "@/components/version-switcher"
import {
  Sidebar,
  SidebarContent,
  SidebarGroup,
  SidebarGroupContent,
  SidebarGroupLabel,
  SidebarHeader,
  SidebarMenu,
  SidebarMenuButton,
  SidebarMenuItem,
  SidebarRail,
} from "@/components/ui/sidebar"

const navByRole = {
  ALUNO: [
    {
      title: "Menu do Aluno",
      url: "#",
      items: [
        { title: "Dashboard", url: "/aluno/dashboard" },
        { title: "Minhas Moedas", url: "/aluno/moedas" },
        { title: "Perfil", url: "/aluno/perfil" },
      ],
    },
  ],
  PROFESSOR: [
    {
      title: "Menu do Professor",
      url: "#",
      items: [
        { title: "Dashboard", url: "/professor/dashboard" },
        { title: "Gerenciar Alunos", url: "/professor/alunos" },
        { title: "Perfil", url: "/professor/perfil" },
      ],
    },
  ],
  EMPRESA: [
    {
      title: "Menu da Empresa",
      url: "#",
      items: [
        { title: "Dashboard", url: "/empresa/dashboard" },
        { title: "Recompensas", url: "/empresa/vantagens" },
      ],
    },
  ],
  DEFAULT: [
    {
      title: "Navegação",
      url: "#",
      items: [
        { title: "Home", url: "/" },
        { title: "Perfil", url: "/perfil" },
      ],
    },
  ],
}


type UserRole = "ALUNO" | "PROFESSOR" | "EMPRESA" | string

interface AppSidebarProps extends React.ComponentProps<typeof Sidebar> {
  role: UserRole
}

export function AppSidebar({ role, ...props }: AppSidebarProps) {
  const navData = navByRole[role as keyof typeof navByRole] || navByRole.DEFAULT

  return (
    <Sidebar {...props}>
      <SidebarHeader>
        <VersionSwitcher />
      </SidebarHeader>
      <SidebarContent>
        {navData.map((group) => (
          <SidebarGroup key={group.title}>
            <SidebarGroupLabel>{group.title}</SidebarGroupLabel>
            <SidebarGroupContent>
              <SidebarMenu>
                {group.items.map((item) => (
                  <SidebarMenuItem key={item.title}>
                    <SidebarMenuButton asChild>
                      <a href={item.url}>{item.title}</a>
                    </SidebarMenuButton>
                  </SidebarMenuItem>
                ))}
              </SidebarMenu>
            </SidebarGroupContent>
          </SidebarGroup>
        ))}
      </SidebarContent>
      <SidebarRail />
    </Sidebar>
  )
}