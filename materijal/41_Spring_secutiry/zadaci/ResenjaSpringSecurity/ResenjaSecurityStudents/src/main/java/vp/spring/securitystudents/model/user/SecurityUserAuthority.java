package vp.spring.securitystudents.model.user;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * Mapping table between User and Authority
 * @author Goran
 *
 */
@Entity
@Table(catalog = "db_security_students", name = "security_user_authority") 
public class SecurityUserAuthority {
	@Id
	@GeneratedValue
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
