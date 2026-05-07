package org.bjm.dtos;

import jakarta.servlet.http.Part;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import java.util.List;


/**
 *
 * @author user
 */
public class UserDto {
    
    @NotNull
    @Email(message = "Invalid Email")
    private String email;
    @NotNull
    @Size(min = 2, max = 75, message = "Invalid First Name")
    private String firstName;
    @NotNull
    @Size(min = 2, max = 75, message = "Invalid First Name")
    private String lastName;
    @NotNull
    private String gender;
    @NotNull
    @Pattern(regexp = "dd/dd/dddd")
    private String dob;
    @Pattern(regexp = "dd/dd/dddd")
    private String mobile;
    @Pattern(regexp = "dd/dd/dddd")
    private String phone;
    @Pattern(regexp = "xx")
    private String stateCode;
    private String stateName;
    private String lokSabhaConstituency;
    private String vidhanSabhaConstituency;
    private Part profileFile;
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

    public Part getProfileFile() {
        return profileFile;
    }

    public void setProfileFile(Part profileFile) {
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
