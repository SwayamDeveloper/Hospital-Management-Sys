package Model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;


@Entity
@Getter                       // We use this annotation for get values
@Setter                       // We use this annotation for set values
@ToString
public class Patient {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY) // We use this annotation for generation of user ID automatically
	private int PatientId;
	@NotNull
	private String firstName,lastName;
	@NotNull
	@Pattern(regexp="[0-9]{10}",message="phone numbers must be of 10 digits")
	private String phoneNumber;
	@NotNull
	private String doctorFirstName;
	@NotNull
	private String doctorLastName;
	private String dateOfBirth;
	private String gender;
	private String email;
	private String bloodGroup;
	private int age;
	private String city;
	private String Deceased;
	private String Address;
	private String maritialStatus;
	@NotNull
	private String appointmentDate;
	@NotNull
	private String time;
	
	
	@ManyToOne
	private user doctor;	

}
