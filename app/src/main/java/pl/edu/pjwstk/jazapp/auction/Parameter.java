package pl.edu.pjwstk.jazapp.auction;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "parameter")
public class Parameter {

    @Id
    private int id;

    private String name;
}
