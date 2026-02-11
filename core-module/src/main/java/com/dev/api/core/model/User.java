package com.dev.api.core.model;

import lombok.*;

/**
 * <pre>
 *
 * </pre>
 *
 * @author its11
 */
@Getter @Setter
@NoArgsConstructor
public class User {
    private Long id;
    private String username;
    private String password;
    private String role;
}
