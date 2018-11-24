package com.vtoroe.vtoroe.domain;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.text.SimpleDateFormat;
import java.util.*;

@Entity
@Table(name="data")
public class User implements UserDetails {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;
    private String username;
    private String password;
    private boolean active;
    private String DateReg;
    private String DateLastSeen;

    private String email;
    private String activationCode;

    @ElementCollection(targetClass=Rol.class, fetch=FetchType.EAGER)
    @CollectionTable(name="user_role", joinColumns = @JoinColumn(name="user_id"))
    @Enumerated(EnumType.STRING)
    private Set<Rol> roles;

    @Override
    public boolean equals(Object o){
        if(this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(id,user.id);
    }

    @ManyToMany
    @JoinTable(
            name="Comment",
            joinColumns = @JoinColumn(name="user_id"),
            inverseJoinColumns = {@JoinColumn(name="summary_id")}
    )
    private List<Summ> summs;

    public List<Summ> getSumms() {
        return summs;
    }

    public void setSumms(List<Summ> summs) {
        this.summs = summs;
    }

    public Long getId() {return id;}
    public void setId(Long id) {this.id = id;}
    public String getUsername() {return username;}
    @Override
    public boolean isAccountNonExpired(){
        return true;
    }
    @Override
    public boolean isAccountNonLocked(){
        return true;
    }
    @Override
    public boolean isCredentialsNonExpired(){
        return true;
    }
    @Override
    public boolean isEnabled(){
        return active;
    }
    public void setUsername(String username) {this.username = username;}
    @Override
    public Collection<?extends GrantedAuthority> getAuthorities(){
        return getRoles();
    }
    public String getPassword() {return password;}
    public void setPassword(String password) {this.password = password;}
    public boolean isActive() {return active;}
    public void setActive(boolean active) {this.active = active;}
    public Set<Rol> getRoles() {return roles;}
    public void setRoles(Set<Rol> roles) {this.roles = roles;}

    public String getDateReg() {
        return DateReg;
    }

    public void setDateReg(Date dateReg) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MM-yyyy HH-mm-ss");
        this.DateReg=simpleDateFormat.format(dateReg);
    }

    public String getDateLastSeen() {
        return DateLastSeen;
    }

    public void setDateLastSeen(Date dateLastSeen) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MM-yyyy HH-mm-ss");
        this.DateLastSeen=simpleDateFormat.format(dateLastSeen);
    }

    public String getActivationCode() {
        return activationCode;
    }

    public void setActivationCode(String activationCode) {
        this.activationCode = activationCode;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

}