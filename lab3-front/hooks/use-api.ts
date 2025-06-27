import { useMemo } from "react";
import axios, { AxiosInstance } from "axios";

type UseApiOptions = {
  withAuth?: boolean;
};

export function useApi({ withAuth = true }: UseApiOptions = {}): AxiosInstance {
  const api = useMemo(() => {
    const instance = axios.create({
      // baseURL: "https://lab-3-latest.onrender.com/api",
      baseURL: "https://localhost:8080/api",
      headers: {
        "Content-Type": "application/json",
      },
    });

    if (withAuth) {
      const token = localStorage.getItem("token");
      if (token) {
        instance.defaults.headers.common["Authorization"] = `Bearer ${token}`;
      }
    }

    return instance;
  }, [withAuth]);

  return api;
}
