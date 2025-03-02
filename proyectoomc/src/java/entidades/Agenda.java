/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import org.codehaus.jackson.annotate.JsonIgnore;

/**
 *
 * @author Santiago
 */
@Entity
@Table(name = "agenda")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Agenda.findAll", query = "SELECT a FROM Agenda a")
    , @NamedQuery(name = "Agenda.findByIdAgenda", query = "SELECT a FROM Agenda a WHERE a.idAgenda = :idAgenda")
    , @NamedQuery(name = "Agenda.findByFechaProgramada", query = "SELECT a FROM Agenda a WHERE a.fechaProgramada = :fechaProgramada")
    , @NamedQuery(name = "Agenda.findByNovedades", query = "SELECT a FROM Agenda a WHERE a.novedades = :novedades")})
public class Agenda implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_agenda")
    private Integer idAgenda;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fecha_programada")
    @Temporal(TemporalType.DATE)
    private Date fechaProgramada;
    @Size(max = 300)
    @Column(name = "novedades")
    private String novedades;
    @Basic(optional = false)
    @NotNull
    @Lob
    @Size(min = 1, max = 16383)
    @Column(name = "foto")
    private String foto;
    @OneToMany(mappedBy = "idAgenda", fetch = FetchType.LAZY)
    private List<AuditoriaMantenimiento> auditoriaMantenimientoList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "agendaIdAgenda", fetch = FetchType.LAZY)
    private List<Mantenimiento> mantenimientoList;
    @JoinColumn(name = "empleado_id_empleado", referencedColumnName = "id_empleado")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Empleado empleadoIdEmpleado;
    @JoinColumn(name = "alquiler_id_alqu", referencedColumnName = "id_alquiler")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Alquiler alquilerIdAlqu;

    public Agenda() {
    }

    public Agenda(Integer idAgenda) {
        this.idAgenda = idAgenda;
    }

    public Agenda(Integer idAgenda, Date fechaProgramada, String foto) {
        this.idAgenda = idAgenda;
        this.fechaProgramada = fechaProgramada;
        this.foto = foto;
    }

    public Integer getIdAgenda() {
        return idAgenda;
    }

    public void setIdAgenda(Integer idAgenda) {
        this.idAgenda = idAgenda;
    }

    public Date getFechaProgramada() {
        return fechaProgramada;
    }

    public void setFechaProgramada(Date fechaProgramada) {
        this.fechaProgramada = fechaProgramada;
    }

    public String getNovedades() {
        return novedades;
    }

    
    public void setNovedades(String novedades) {
        this.novedades = novedades;
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }

    @XmlTransient
    @JsonIgnore
    public List<AuditoriaMantenimiento> getAuditoriaMantenimientoList() {
        return auditoriaMantenimientoList;
    }

    public void setAuditoriaMantenimientoList(List<AuditoriaMantenimiento> auditoriaMantenimientoList) {
        this.auditoriaMantenimientoList = auditoriaMantenimientoList;
    }

    @XmlTransient
    @JsonIgnore
    public List<Mantenimiento> getMantenimientoList() {
        return mantenimientoList;
    }

    public void setMantenimientoList(List<Mantenimiento> mantenimientoList) {
        this.mantenimientoList = mantenimientoList;
    }

    public Empleado getEmpleadoIdEmpleado() {
        return empleadoIdEmpleado;
    }

    public void setEmpleadoIdEmpleado(Empleado empleadoIdEmpleado) {
        this.empleadoIdEmpleado = empleadoIdEmpleado;
    }

    public Alquiler getAlquilerIdAlqu() {
        return alquilerIdAlqu;
    }

    public void setAlquilerIdAlqu(Alquiler alquilerIdAlqu) {
        this.alquilerIdAlqu = alquilerIdAlqu;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idAgenda != null ? idAgenda.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Agenda)) {
            return false;
        }
        Agenda other = (Agenda) object;
        if ((this.idAgenda == null && other.idAgenda != null) || (this.idAgenda != null && !this.idAgenda.equals(other.idAgenda))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.Agenda[ idAgenda=" + idAgenda + " ]";
    }
    
}
