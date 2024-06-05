package com.sparta.fifteen.entity;

import jakarta.persistence.*;
import lombok.*;


@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class RefreshToken {
    @Id
    private String id;
    private String refreshToken;

    private Long expiration;

    public static RefreshToken from(String username, String refreshToken, Long expirationTime){
        return RefreshToken.builder()
                .id(username)
                .refreshToken(refreshToken)
                .expiration(expirationTime / 1000)
                .build();
    }

    public RefreshToken(String refreshToken){
        this.refreshToken = refreshToken;
    }

    public void updateRefreshToken(String refreshToken){
        this.refreshToken = refreshToken;
    }

    public Boolean validRefreshToken(String refreshToken){
        return this.refreshToken.equals(refreshToken);
    }
}