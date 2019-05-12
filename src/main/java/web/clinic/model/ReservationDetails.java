package web.clinic.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "reservation_details")
public class ReservationDetails {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	@Column(name="symptons")
	private String symptons;
	
	@Column(name="food_allergies")
	private String foodAllergies;
	
	@Column(name="medicine_allergies")
	private String medicineAllergies;
	
	@OneToOne
	@JoinColumn(name = "user_username", referencedColumnName = "username")
	private User user;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getSymptons() {
		return symptons;
	}

	public void setSymptons(String symptons) {
		this.symptons = symptons;
	}

	public String getFoodAllergies() {
		return foodAllergies;
	}

	public void setFoodAllergies(String foodAllergies) {
		this.foodAllergies = foodAllergies;
	}

	public String getMedicineAllergies() {
		return medicineAllergies;
	}

	public void setMedicineAllergies(String medicineAllergies) {
		this.medicineAllergies = medicineAllergies;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
	
	
}
