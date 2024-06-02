public class Persong {
    private String username;
    private String password;
    private String idCardNumber;
    private String cellPhone;

    public Persong() {
    }

    public Persong(String username, String password, String idCardNumber, String cellPhone) {
        this.username = username;
        this.password = password;
        this.idCardNumber = idCardNumber;
        this.cellPhone = cellPhone;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getIdCardNumber() {
        return idCardNumber;
    }

    public String getCellPhone() {
        return cellPhone;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setIdCardNumber(String idCardNumber) {
        this.idCardNumber = idCardNumber;
    }

    public void setCellPhone(String cellPhone) {
        this.cellPhone = cellPhone;
    }
}
