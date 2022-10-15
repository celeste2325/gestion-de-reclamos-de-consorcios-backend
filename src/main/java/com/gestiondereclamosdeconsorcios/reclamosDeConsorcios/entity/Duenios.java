package com.gestiondereclamosdeconsorcios.reclamosDeConsorcios.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;

@Entity
public class Duenios {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id", nullable = false)
    private Integer id;
    @Basic
    @Column(name = "identificador", nullable = false)
    private Integer identificador;
    @Basic
    @Column(name = "documento", nullable = false, length = 20,updatable = false,insertable = false)
    private String documento;
    @ManyToOne
    @JoinColumn(name = "documento", referencedColumnName = "documento", nullable = false)
    @JsonBackReference("personas_dueno")
    private Personas personasByDocumento;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getIdentificador() {
        return identificador;
    }

    public void setIdentificador(Integer identificador) {
        this.identificador = identificador;
    }

    public String getDocumento() {
        return documento;
    }

    public void setDocumento(String documento) {
        this.documento = documento;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Duenios duenios = (Duenios) o;

        if (id != null ? !id.equals(duenios.id) : duenios.id != null) return false;
        if (identificador != null ? !identificador.equals(duenios.identificador) : duenios.identificador != null)
            return false;
        if (documento != null ? !documento.equals(duenios.documento) : duenios.documento != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (identificador != null ? identificador.hashCode() : 0);
        result = 31 * result + (documento != null ? documento.hashCode() : 0);
        return result;
    }

    public Personas getPersonasByDocumento() {
        return personasByDocumento;
    }

    public void setPersonasByDocumento(Personas personasByDocumento) {
        this.personasByDocumento = personasByDocumento;
    }
}