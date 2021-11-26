/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package usuario;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;



@Entity
@Table(name = "usuario")
public class Usuario implements Serializable {

@Id
@GeneratedValue
@Column(name = "codigo", nullable = false)
private Integer codigo;
@Column(name = "nome")
private String nome;
@Column(name = "email")
private String email;
@Column(name = "login")
@org.hibernate.annotations.NaturalId
private String login;
@Column(name = "senha")
private String senha;
@Column(name = "nascimento")
private Date nascimento;
@Column(name = "celular")
private String celular;
@Column(name = "ativo")
private boolean ativo;

@ElementCollection(targetClass = String.class)
@JoinTable(
        name = "usuario_permissao",
        uniqueConstraints = {
            @UniqueConstraint(columnNames = {"usuario", "permissao"})},
        joinColumns = @JoinColumn(name = "usuario"))
@Column(name = "permissao", length = 50)
private Set<String> permissao = new HashSet<String>();

    public Integer getCodigo() {
        return codigo;
    }

    public String getNome() {
        return nome;
    }

    public String getEmail() {
        return email;
    }

    public String getLogin() {
        return login;
    }

    public String getSenha() {
        return senha;
    }

    public Date getNascimento() {
        return nascimento;
    }

    public String getCelular() {
        return celular;
    }

    public boolean isAtivo() {
        return ativo;
    }

    public Set<String> getPermissao() {
        return permissao;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public void setNascimento(Date nascimento) {
        this.nascimento = nascimento;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public void setAtivo(boolean ativo) {
        this.ativo = ativo;
    }

    public void setPermissao(Set<String> permissao) {
        this.permissao = permissao;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 23 * hash + Objects.hashCode(this.codigo);
        hash = 23 * hash + Objects.hashCode(this.nome);
        hash = 23 * hash + Objects.hashCode(this.email);
        hash = 23 * hash + Objects.hashCode(this.login);
        hash = 23 * hash + Objects.hashCode(this.senha);
        hash = 23 * hash + Objects.hashCode(this.nascimento);
        hash = 23 * hash + Objects.hashCode(this.celular);
        hash = 23 * hash + (this.ativo ? 1 : 0);
        hash = 23 * hash + Objects.hashCode(this.permissao);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Usuario other = (Usuario) obj;
        if (this.ativo != other.ativo) {
            return false;
        }
        if (!Objects.equals(this.nome, other.nome)) {
            return false;
        }
        if (!Objects.equals(this.email, other.email)) {
            return false;
        }
        if (!Objects.equals(this.login, other.login)) {
            return false;
        }
        if (!Objects.equals(this.senha, other.senha)) {
            return false;
        }
        if (!Objects.equals(this.celular, other.celular)) {
            return false;
        }
        if (!Objects.equals(this.codigo, other.codigo)) {
            return false;
        }
        if (!Objects.equals(this.nascimento, other.nascimento)) {
            return false;
        }
        if (!Objects.equals(this.permissao, other.permissao)) {
            return false;
        }
        return true;
    }


}


