package test.clon.restapi.security;

import lombok.Getter;
import lombok.Setter;
import test.clon.restapi.model.User;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;
@Getter
@Setter
public class CustomUserDetails implements UserDetails {

    private final User user;

    public CustomUserDetails(User user) {
        this.user = user;
    }
    public Integer getBin() {
        return user.getBin();
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        // Here we assign role based on the usertype
        return List.of(new SimpleGrantedAuthority("ROLE_" + user.getUsertype()));
    }

    @Override
    public String getPassword() {
        return user.getPassword(); // Return the user's password
    }

    @Override
    public String getUsername() {
        return user.getEmail(); // Use email as username
    }

    @Override
    public boolean isAccountNonExpired() {
        return true; // Customize according to your requirements
    }

    @Override
    public boolean isAccountNonLocked() {
        return true; // Customize according to your requirements
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true; // Customize according to your requirements
    }

    @Override
    public boolean isEnabled() {
        return true; // Customize according to your requirements
    }
}
