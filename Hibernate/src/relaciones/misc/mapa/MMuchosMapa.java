package relaciones.misc.mapa;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Proxy;

/**
 * @author Demián Gutierrez
 * @author Alejandro Salas 
 * <br> Created on Jul 1, 2008
 */
@Entity
@Table(name = "t_muchos_mapa")
@Proxy(lazy = false)
public class MMuchosMapa {

  private int id;
  private int codigo;
  private MUnoMapa unoMapaRef;

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public int getCodigo() {
    return codigo;
  }

  public void setCodigo(int codigo) {
    this.codigo = codigo;
  }

  @ManyToOne
  public MUnoMapa getUnoMapaRef() {
    return unoMapaRef;
  }

  public void setUnoMapaRef(MUnoMapa unoRef) {
    this.unoMapaRef = unoRef;
  }
}
