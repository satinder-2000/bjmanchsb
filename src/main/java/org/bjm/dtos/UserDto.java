package org.bjm.dtos;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

import java.io.Serializable;
import java.util.List;

import org.bjm.utils.RequireMobileOrPhone;
import org.springframework.web.multipart.MultipartFile;


/**
 *
 * @author user
 */
@RequireMobileOrPhone
public class UserDto implements Serializable {
    
	@NotBlank(message = "Email is required")
    @Email(message = "Invalid Email")
    private String email;
	
	@NotBlank(message = "First Name is required")
    @Size(min = 2, max = 75, message = "Invalid First Name")
    private String firstName;
    
	@NotBlank(message = "Last Name is required")
    @Size(min = 2, max = 75, message = "Invalid First Name")
    private String lastName;
    
	@NotBlank(message = "Gender is required")
	@Pattern(regexp="Male|Female", message="Invalid Gender")
    private String gender;
    
	@NotBlank(message = "Date of birth is required")
    @Pattern(
        regexp = "^\\d{2}/\\d{2}/\\d{4}$",
        message = "Date must be in dd/MM/yyyy format"
    )
    private String dob;
    
	//Validation of mobile and phone moved to Controller because only one number is required
	
	@Pattern(regexp="^0([1-6][0-9]{8,10}|7[0-9]{9})$", message="Invalid Mobile Number")
	private String mobile;
	@Pattern(regexp="^0([1-6][0-9]{8,10}|7[0-9]{9})$", message="Invalid Phone Number")
	private String phone;
	
	@NotBlank(message = "State of residence is required")
    @Pattern(regexp = "^[A-Z]{2}$", message = "Invalid State")
    private String stateCode;
    private String stateName;
    @NotBlank(message = "Lok Sabha Constituency is required")
    @Size(min = 4, max = 100, message = "Invalid Lok Sabha Constituency")
    private String lokSabhaConstituency;
    @NotBlank(message = "Vidhan Sabha Constituency is required")
    @Size(min = 3, max = 100, message = "Invalid Vidhan Sabha Constituency")
    private String vidhanSabhaConstituency;
    private MultipartFile profileFile;
    private String profileImageType;
    private byte[] profileImage;
    
    //DTOs here
    List<StateDto> stateDtos;
    List<LokSabhaDto> lokSabhaDtos;
    List<VidhanSabhaDto> vidhanSabhaDtos;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    

    public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
    	this.dob = dob;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getStateCode() {
        return stateCode;
    }

    public void setStateCode(String stateCode) {
        this.stateCode = stateCode;
    }

    public String getStateName() {
        return stateName;
    }

    public void setStateName(String stateName) {
        this.stateName = stateName;
    }

    public String getLokSabhaConstituency() {
        return lokSabhaConstituency;
    }

    public void setLokSabhaConstituency(String lokSabhaConstituency) {
        this.lokSabhaConstituency = lokSabhaConstituency;
    }

    public String getVidhanSabhaConstituency() {
        return vidhanSabhaConstituency;
    }
    
    public void setVidhanSabhaConstituency(String vidhanSabhaConstituency) {
        this.vidhanSabhaConstituency = vidhanSabhaConstituency;
    }

    public MultipartFile getProfileFile() {
		return profileFile;
	}

	public void setProfileFile(MultipartFile profileFile) {
		this.profileFile = profileFile;
	}

	public String getProfileImageType() {
        return profileImageType;
    }

    public void setProfileImageType(String profileImageType) {
        this.profileImageType = profileImageType;
    }

    public byte[] getProfileImage() {
        return profileImage;
    }

    public void setProfileImage(byte[] profileImage) {
        this.profileImage = profileImage;
    }

    public List<StateDto> getStateDtos() {
        return stateDtos;
    }

    public void setStateDtos(List<StateDto> stateDtos) {
        this.stateDtos = stateDtos;
    }

    public List<LokSabhaDto> getLokSabhaDtos() {
        return lokSabhaDtos;
    }

    public void setLokSabhaDtos(List<LokSabhaDto> lokSabhaDtos) {
        this.lokSabhaDtos = lokSabhaDtos;
    }

    public List<VidhanSabhaDto> getVidhanSabhaDtos() {
        return vidhanSabhaDtos;
    }

    public void setVidhanSabhaDtos(List<VidhanSabhaDto> vidhanSabhaDtos) {
        this.vidhanSabhaDtos = vidhanSabhaDtos;
    }
    
    
    
    
}
