/**
 * @author Albert Lozano Blasco
 * @version 13.0
 */

package com.bosonit.block7crudvalidation.security;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AuthenticationRequest {
    // Attributes
    private String username;
    private String password;
}
