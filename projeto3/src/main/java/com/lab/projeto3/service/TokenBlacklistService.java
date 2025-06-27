package com.lab.projeto3.service;

import org.springframework.stereotype.Service;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

@Service
public class TokenBlacklistService {
    private final Set<String> blacklistedTokens = ConcurrentHashMap.newKeySet();

    public void blacklistToken(String token) {
        blacklistedTokens.add(token);
    }

    public boolean isTokenBlacklisted(String token) {
        return blacklistedTokens.contains(token);
    }

    // Método para limpar tokens antigos (pode ser chamado periodicamente)
    public void clearExpiredTokens() {
        // Implementar limpeza de tokens expirados se necessário
        blacklistedTokens.clear();
    }
}
