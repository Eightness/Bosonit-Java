/**
 * @author Albert Lozano Blasco
 * @version 13.0
 */

package com.bosonit.block7crudvalidation.security;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AuthenticationResponse {
    // Attributes
    private String token;
}
