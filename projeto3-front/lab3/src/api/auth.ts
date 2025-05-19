import axios from 'axios'

const api = axios.create({
    baseURL: 'http://localhost:8081',
})

interface LoginCredentials {
    email: string
    senha: string
}

export const authApi = {
    login: async (credentials: LoginCredentials): Promise<string> => {
        const { data } = await api.post('/auth/authenticate', credentials)
        return data.token
    },
}