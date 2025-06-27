"use client";

import { useAuth } from "@/hooks/use-auth";
import { usePathname, useRouter } from "next/navigation";
import { useEffect } from "react";

const publicRoutes = ["/login"];
const roleRoutes = {
  ALUNO: ["/aluno"],
  PROFESSOR: ["/professor"],
  EMPRESA: ["/empresa"],
};

export default function AuthLayout({
  children,
}: {
  children: React.ReactNode;
}) {
  const { user } = useAuth();
  const pathname = usePathname();
  const router = useRouter();

  useEffect(() => {
    // Se está em uma rota pública, não precisa verificar
    if (publicRoutes.some((route) => pathname.startsWith(route))) {
      // Se já está logado, redireciona para a dashboard apropriada
      if (user) {
        const basePath = `/${user.role.toLowerCase()}/dashboard`;
        router.push(basePath);
      }
      return;
    }

    // Se não está logado e não está em uma rota pública
    if (!user) {
      router.push("/login");
      return;
    }

    // Verifica se o usuário tem acesso à rota atual
    const userRole = user.role;
    const allowedPaths = roleRoutes[userRole as keyof typeof roleRoutes] || [];
    const hasAccess = allowedPaths.some((path) => pathname.startsWith(path));

    if (!hasAccess) {
      const basePath = `/${userRole.toLowerCase()}/dashboard`;
      router.push(basePath);
    }
  }, [pathname, user, router]);

  return children;
}
