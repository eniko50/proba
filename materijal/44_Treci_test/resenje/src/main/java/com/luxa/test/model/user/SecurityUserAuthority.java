package com.luxa.test.model.user;

import javax.persistence.*;

@Entity
public class SecurityUserAuthority {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(cascade = CascadeType.REFRESH, fetch = FetchType.EAGER)
    private SecurityUser user;

    @ManyToOne(cascade = CascadeType.REFRESH, fetch = FetchType.EAGER)
    private SecurityAuthority authority;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public SecurityUser getUser() {
        return user;
    }

    public void setUser(SecurityUser user) {
        this.user = user;
    }

    public SecurityAuthority getAuthority() {
        return authority;
    }

    public void setAuthority(SecurityAuthority authority) {
        this.authority = authority;
    }
}
