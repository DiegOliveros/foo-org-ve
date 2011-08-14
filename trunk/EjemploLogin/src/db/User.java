package db;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Proxy;

/**
 * @author Anna Lezama
 * @author Demián Gutierrez
 */
@Entity
@Table(name = "t_user")
@Proxy(lazy = false)
public class User {

  private int id;

  private String nick;
  private String pass;
  private String name;
  private String mail;

  // --------------------------------------------------------------------------------

  public User() {
    // Empty
  }

  // --------------------------------------------------------------------------------

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  // --------------------------------------------------------------------------------

  public String getNick() {
    return nick;
  }

  public void setNick(String nick) {
    this.nick = nick;
  }

  // --------------------------------------------------------------------------------

  public String getPass() {
    return pass;
  }

  public void setPass(String pass) {
    this.pass = pass;
  }

  // --------------------------------------------------------------------------------

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  // --------------------------------------------------------------------------------

  public String getMail() {
    return mail;
  }

  public void setMail(String mail) {
    this.mail = mail;
  }
}
