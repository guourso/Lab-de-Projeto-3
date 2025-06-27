package com.lab.projeto3.controller;

import com.lab.projeto3.dto.LoginRequestDTO;
import com.lab.projeto3.dto.LoginResponseDTO;
import com.lab.projeto3.service.AuthService;
import com.lab.projeto3.util.InsertData;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;



@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthService authService;
    private final InsertData insertData;

    @PostMapping("/login")
    public ResponseEntity<LoginResponseDTO> login(@RequestBody @Valid LoginRequestDTO dto) {
        return ResponseEntity.ok(authService.autenticar(dto));
    }
    @GetMapping("health")
    public ResponseEntity<String> healthCheck() {
        return ResponseEntity.ok("OK");
    }
    
    @PostMapping("/init")
    public ResponseEntity<Void> init() {
        insertData.insertData();
        return ResponseEntity.ok().build();
    }
    
}
