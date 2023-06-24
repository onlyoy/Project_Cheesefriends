package mul.cam.a.dto;

public class AttendanceRequest {
    private String userId;
    private String eduCode;
    private String subCode;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getEduCode() {
        return eduCode;
    }

    public void setEduCode(String eduCode) {
        this.eduCode = eduCode;
    }

    public String getSubCode() {
        return subCode;
    }

    public void setSubCode(String subCode) {
        this.subCode = subCode;
    }
}
