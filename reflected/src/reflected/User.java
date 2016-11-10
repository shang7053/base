/**   
 *
 * @Title: User.java 
 * @Package reflected 
 * @Description: TODO(用一句话描述该文件做什么) 
 * @author scc
 * @date 2016年11月8日 上午10:41:21   
 */
package reflected;

import java.util.List;

/**
 *
 * @ClassName: User
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author scc
 * @date 2016年11月8日 上午10:41:21
 * 
 */
public class User {

    private List<User> users;

    /**
     * @return the users
     * @author A18ccms a18ccms_gmail_com
     * @date 2016年11月8日 上午10:41:40
     */
    public List<User> getUsers() {
        return this.users;
    }

    /**
     * @author A18ccms a18ccms_gmail_com
     * @date 2016年11月8日 上午10:41:40
     * @param users the users to set
     */
    public void setUsers(List<User> users) {
        this.users = users;
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
        return "User [users=" + this.users + "]";
    }

}
