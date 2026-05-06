package org.bjm.dtos;

/**
 *
 * @author user
 */
public class VidhanSabhaDto {
    
    private String stateCode;
    private String constituency;

    public VidhanSabhaDto(String stateCode, String constituency) {
        this.stateCode = stateCode;
        this.constituency = constituency;
    }

    public String getStateCode() {
        return stateCode;
    }

    public void setStateCode(String stateCode) {
        this.stateCode = stateCode;
    }

    public String getConstituency() {
        return constituency;
    }

    public void setConstituency(String constituency) {
        this.constituency = constituency;
    }
    
}
