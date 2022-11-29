package Model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
public class user {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY) // We use this annotation for generation of user ID automatically
	private int id;
	@NotNull
	private int userRollCode;
	@NotNull                                          // We use this annotation for give a message to the user is value should not be null 
	@Size(min=3,max=15,message="username must be more than 3 chars and upto 15chars")     // Here we add some validation to userName
	String userId;
	@NotNull
	@Size(min=5,max=20,message="password should be more than 5 chars")                    // Here we add some validation to userPassword
	private String userPassword;
	@NotNull
	@Pattern(regexp="[0-9]{10}",message="phone numbers must be of 10 digits")
	private String phoneNumber;
	@NotNull
	private String firstName,lastName;
	private String dateOfBirth;
	private String gender;
	private String email;
	private String bloodGroup;
	private int age;
	private String joiningDate;
	private String qualification;;
	private String city;
	private String specialization;
	private String Address;
	private String Deceased;
	private String maritialStatus;
	
	@OneToMany(cascade=CascadeType.ALL,mappedBy="doctor") //cascade=CascadeType.ALL,   ,mappedBy="student
	private List<Patient> patients = new ArrayList<>();
	
//	@OneToMany(cascade=CascadeType.ALL)
//	private List<Patient> apList = new ArrayList<>();
	
}
