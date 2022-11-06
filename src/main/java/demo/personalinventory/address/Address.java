package demo.personalinventory.address;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import demo.personalinventory.contact.Contact;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "addresses")
@Getter
@Setter
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "address_id")
    private Long id;
    @Column(name = "address_city")
    private String city;
    @Column(name = "address_street")
    private String street;
    @OneToMany(mappedBy = "address")
    private List<Contact> contactList;
}
