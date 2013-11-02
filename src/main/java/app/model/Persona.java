
package app.model;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

public class Persona implements Serializable{
    
    @Id
    @GeneratedValue
    @Column(name = "id")
    private Long id;

    @Column(name = "email")
    private String email;

    @Column(name = "nombres")
    private String nombres;

    @Column(name = "paterno")
    private String paterno;

    @Column(name = "materno")
    private String materno;

    @Column(name = "celular")
    private String celular;

    @Column(name = "sexo")
    private String sexo;

    @Column(name = "direccion")
    private String direccion;

    @OneToMany(mappedBy = "socio", fetch = FetchType.LAZY)
    private List<SolicitudAlquiler> solicitudAlquiler;

    public Persona() {}

    public Persona(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }	

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }	

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNombres() {
        return nombres;
    }	

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getPaterno() {
        return paterno;
    }	

    public void setPaterno(String paterno) {
        this.paterno = paterno;
    }

    public String getMaterno() {
        return materno;
    }	

    public void setMaterno(String materno) {
        this.materno = materno;
    }

    public String getCelular() {
        return celular;
    }	

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public String getSexo() {
        return sexo;
    }	

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getDireccion() {
        return direccion;
    }	

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public List<SolicitudAlquiler> getSolicitudAlquiler() {
           return solicitudAlquiler;
    }

    public void setSolicitudAlquiler(List<SolicitudAlquiler> solicitudAlquiler) {
        this.solicitudAlquiler = solicitudAlquiler;
    }
    
}