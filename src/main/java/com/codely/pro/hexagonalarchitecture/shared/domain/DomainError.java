package com.codely.pro.hexagonalarchitecture.shared.domain;

import lombok.Getter;

@Getter
public class DomainError extends RuntimeException {
    private final String errorCode;
    private final String errorMessage;

    public DomainError(String errorCode, String message) {
        super(message);
        this.errorCode = errorCode;
        this.errorMessage = message;
    }
}
