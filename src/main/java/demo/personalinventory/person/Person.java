package demo.personalinventory.person;


import demo.personalinventory.address.Address;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "persons")
@Getter
@Setter
public class Person {
    @Id
    @Column(name = "person_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "person_name")
    private String name;
    @OneToOne(cascade = CascadeType.PERSIST)
    private Address temporaryAddress;
    @OneToOne(cascade = CascadeType.ALL)
    private Address permanentAddress;
}
