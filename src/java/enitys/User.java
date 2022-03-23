
package enitys;

import java.io.Serializable;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class User implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String login;
    private String password;
    private String firtName;
    private String sureName;
    private String phone;
    private String salt;
    @OneToOne(orphanRemoval = true, cascade = CascadeType.ALL)
    private List<Product> listProducts;
    

}
