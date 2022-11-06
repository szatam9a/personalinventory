package demo.personalinventory.contact;

import demo.personalinventory.address.Address;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "contacts")
@Getter
@Setter
public class Contact {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "contact_id")
    private Long id;
    @Column(name = "contact_email_address")
    private String emailAddress;
    @Column(name = "contact_phone_number")
    private String phoneNumber;
    @ManyToOne
    @JoinColumn(name = "contact_address_id")
    private Address address;
}
