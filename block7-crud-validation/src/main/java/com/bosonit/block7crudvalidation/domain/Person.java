/**
 * @author Albert Lozano Blasco
 * @version 13.0
 */

package com.bosonit.block7crudvalidation.domain;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.Date;
import java.util.List;

/**
 * Person class. Defines a person.
 */
@Entity
@Table(name = "Person")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Person implements UserDetails {
    // Enum
    public enum Role {
        USER,
        ADMIN
    }

    // Attributes
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long personId;

    @Size(min = 6, max = 10)
    @NotNull
    private String login;

    @NotNull
    private String password;

    @NotNull
    private String name;

    private String surname;

    @NotNull
    private String companyEmail;

    @NotNull
    private String personalEmail;

    @NotNull
    private String city;

    @NotNull
    private Boolean active;

    @NotNull
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdDate;

    private String imageUrl;

    @Temporal(TemporalType.TIMESTAMP)
    private Date terminationDate;

    @Enumerated(EnumType.STRING)
    private Role role;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(new SimpleGrantedAuthority(role.name()));
    }

    @Override
    public String getUsername() {
        return login;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
