package onpoint.beans;

import java.io.Serializable;

import javax.persistence.*;

import org.hibernate.annotations.Check;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component("users")
@Scope("prototype")
@Entity
@Table(name="OP_USERS")
@Check(constraints = "USER_TYPE IN ('USER','ADMIN')")

@NamedQueries({
	@NamedQuery(
			name = "namedQueryGetUserByUsername",
			query = "from Users u where u.username = :username" //use class name and not table 
			)
})
public class Users implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="opUsersSequence")
	@SequenceGenerator(allocationSize=1,name="opUsersSequence",sequenceName="SQ_OP_USERS_PK")
	@Column(name="USER_ID")
	private int id;
	
	@Column(name="USERNAME", unique = true, nullable = false)
	private String username;
	
	@Column(name="PASSWORD", nullable = false)
	private String password;
	
	@Column(name="USER_TYPE", nullable = false)
	private String user_type;
	
	@Column(name="EMAIL", unique = true, nullable = false)
	private String email;
	
	@Column(name="PHONE_NUMBER", unique = true, nullable = false)
	private String phone_number;
	
	@Column(name="LOCATION_LAT")
	private double location_lat;
	
	@Column(name="LOCATION_LON")
	private double location_lon;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getUser_type() {
		return user_type;
	}
	public void setUser_type(String user_type) {
		this.user_type = user_type;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhone_number() {
		return phone_number;
	}
	public void setPhone_number(String phone_number) {
		this.phone_number = phone_number;
	}
	public double getLocation_lat() {
		return location_lat;
	}
	public void setLocation_lat(double location_lat) {
		this.location_lat = location_lat;
	}
	public double getLocation_lon() {
		return location_lon;
	}
	public void setLocation_lon(double location_lon) {
		this.location_lon = location_lon;
	}
	public Users() {
		super();
	}
	public Users(int id, String username, String password, String user_type, String email, String phone_number,
			double location_lat, double location_lon) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
		this.user_type = user_type;
		this.email = email;
		this.phone_number = phone_number;
		this.location_lat = location_lat;
		this.location_lon = location_lon;
	}
	@Override
	public String toString() {
		return "Users [id=" + id + ", username=" + username + ", password=" + password + ", user_type=" + user_type
				+ ", email=" + email + ", phone_number=" + phone_number + ", location_lat=" + location_lat
				+ ", location_lon=" + location_lon + "]";
	}
	
	
	
	
	
	
}
