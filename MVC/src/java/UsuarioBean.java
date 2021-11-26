/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.util.List;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import usuario.Usuario;
import usuario.UsuarioRN;


@Named
@RequestScoped
public class UsuarioBean  {
    
    private Usuario usuario = new Usuario();
    private String confirmaSenha;
    private List<Usuario> lista;
    private String destinoSalvar;

    public void setDestinoSalvar(String destinoSalvar) {
        this.destinoSalvar = destinoSalvar;
    }

    public String getDestinoSalvar() {
        return destinoSalvar;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public String getConfirmaSenha() {
        return confirmaSenha;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public void setConfirmaSenha(String confirmaSenha) {
        this.confirmaSenha = confirmaSenha;
    }
    
    public String novo(){
            this.destinoSalvar = "usuarioSucesso";
            this.usuario = new Usuario();
            this.usuario.setAtivo(true);
            return "usuario";
    }
    
    public String salvar(){
        FacesContext context = FacesContext.getCurrentInstance();
        
        String senha = this.usuario.getSenha();
        if(!senha.equals(this.confirmaSenha)){
                FacesMessage facesMessage = new FacesMessage("A senha não foi confirmada corretamente");
                context.addMessage(null, facesMessage);
                return null;
        }
        UsuarioRN usuarioRN = new UsuarioRN();
        usuarioRN.salvar(this.usuario);
        
        return this.destinoSalvar;
    }
    
    public List<Usuario> getLista(){
        if(this.lista == null){
            UsuarioRN usuarioRN = new UsuarioRN();
            this.lista = usuarioRN.listar();
        }
        return this.lista;
    }
    
    public String editar(){
        this.confirmaSenha = this.usuario.getSenha();
        return "Publico/usuario";
    }
    
    public String excluir(){
        UsuarioRN usuarioRN = new UsuarioRN();
        usuarioRN.excluir(this.usuario);
        this.lista = null;
        return null;
    }
    
    public String ativar(){
        if(this.usuario.isAtivo()){
            this.usuario.setAtivo(false);
        }else{
            this.usuario.setAtivo(true);
        }
        
        UsuarioRN usuarioRN = new UsuarioRN();
        usuarioRN.salvar(this.usuario);
        return null;
    }
    
}
