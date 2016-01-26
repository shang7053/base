/**   
* @Title: User.java 
* @Package sustainable.interactive.vo 
* @Description: TODO(用一句话描述该文件做什么) 
* @author scc
* @date 2016年1月22日 下午5:45:12   
*/
package sustainable.common.po;

import java.io.Serializable;

/**
 * @ClassName: User
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author scc
 * @date 2016年1月22日 下午5:45:12
 * 
 */
public class User implements Serializable {
    /**
     * @Fields serialVersionUID : TODO(用一句话描述这个变量表示什么)
     * @author scc
     * @date 2016年1月22日 下午5:46:00
     */
    private static final long serialVersionUID = 8421883022318297623L;
    private Integer uid;
    private String uname;
    private String password;

    /**
     * <p>
     * Title:
     * </p>
     * <p>
     * Description:
     * </p>
     * 
     * @author scc
     * @date 2016年1月22日 下午5:45:50
     */
    public User() {
        // TODO Auto-generated constructor stub
    }

    /**
     * <p>
     * Title:
     * </p>
     * <p>
     * Description:
     * </p>
     * 
     * @author scc
     * @date 2016年1月22日 下午5:45:55
     * @param uname
     * @param password
     */
    public User(String uname, String password) {
        super();
        this.uname = uname;
        this.password = password;
    }

    /**
     * @return the uname
     * @author A18ccms a18ccms_gmail_com
     * @date 2016年1月22日 下午5:45:40
     */
    public String getUname() {
        return this.uname;
    }

    /**
     * @author A18ccms a18ccms_gmail_com
     * @date 2016年1月22日 下午5:45:40
     * @param uname the uname to set
     */
    public void setUname(String uname) {
        this.uname = uname;
    }

    /**
     * @return the password
     * @author A18ccms a18ccms_gmail_com
     * @date 2016年1月22日 下午5:45:40
     */
    public String getPassword() {
        return this.password;
    }

    /**
     * @author A18ccms a18ccms_gmail_com
     * @date 2016年1月22日 下午5:45:40
     * @param password the password to set
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /*
     * (非 Javadoc)
     * <p>Title: toString</p>
     * <p>Description: </p>
     * 
     * @return
     * 
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return "User [uid=" + this.uid + ", uname=" + this.uname + ", password=" + this.password + "]";
    }

    /**
     * @return the uid
     * @author A18ccms a18ccms_gmail_com
     * @date 2016年1月26日 上午9:43:35
     */
    public Integer getUid() {
        return this.uid;
    }

    /**
     * @author A18ccms a18ccms_gmail_com
     * @date 2016年1月26日 上午9:43:35
     * @param uid the uid to set
     */
    public void setUid(Integer uid) {
        this.uid = uid;
    }

}
