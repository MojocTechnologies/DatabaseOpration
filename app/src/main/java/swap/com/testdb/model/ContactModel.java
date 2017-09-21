package swap.com.testdb.model;

/**
 * Created by pranaydalal on 21/09/17.
 */

public class ContactModel {

    private String srNo;
    private String name;
    private String mobile;

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSrNo() {
        return srNo;
    }

    public void setSrNo(String srNo) {
        this.srNo = srNo;
    }
}
