import { useMemo } from "react"
import axios, { AxiosInstance } from "axios"

export function useApi(): AxiosInstance {
  const api = useMemo(() => {
    const instance = axios.create({
      baseURL: "https://lab-3-latest.onrender.com/api",
      headers: {
        "Content-Type": "application/json",
      },
    })

    const token = localStorage.getItem("token") 
    if (token) {
      instance.defaults.headers.common["Authorization"] = `Bearer ${token}`
    }

    return instance
  }, [])

  return api
}
