package thoaldo.forum_hub.forumhub.service;

import thoaldo.forum_hub.forumhub.model.User;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;

public class UserDetailsImpl implements UserDetails {

    private final User user;

    public UserDetailsImpl(User user) {
        this.user = user;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        // Retornar as autoridades do usuário. Pode ser uma lista vazia se não houver roles.
        return null;
    }

    @Override
    public String getPassword() {
        return user.getPassword();
    }

    @Override
    public String getUsername() {
        return user.getUsername();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true; // Você pode adicionar lógica para verificar se a conta expirou
    }

    @Override
    public boolean isAccountNonLocked() {
        return true; // Você pode adicionar lógica para verificar se a conta está bloqueada
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true; // Você pode adicionar lógica para verificar se as credenciais expiraram
    }

    @Override
    public boolean isEnabled() {
        return true; // Você pode adicionar lógica para verificar se a conta está habilitada
    }
}
