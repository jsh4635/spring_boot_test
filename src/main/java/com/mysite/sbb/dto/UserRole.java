package com.mysite.sbb.dto;

import lombok.Getter;

/**
 * @author shjung
 * @since 24. 12. 11.
 */
@Getter
public enum UserRole {
    ADMIN("ROLE_ADMIN"),
    USER("ROLE_USER");

    UserRole(String value){
        this.value = value;
    }

    private String value;
}
