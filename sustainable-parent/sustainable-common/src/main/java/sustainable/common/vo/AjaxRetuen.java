/**   
* @Title: AjaxRetuen.java 
* @Package sustainable.common.vo 
* @Description: TODO(用一句话描述该文件做什么) 
* @author scc
* @date 2016年1月25日 下午5:56:51   
*/
package sustainable.common.vo;

/**
 * @ClassName: AjaxRetuen
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author scc
 * @date 2016年1月25日 下午5:56:51
 * 
 */
public class AjaxRetuen {

    /**
     * <p>
     * Title:
     * </p>
     * <p>
     * Description:
     * </p>
     * 
     * @author scc
     * @date 2016年1月25日 下午5:56:51
     */
    public AjaxRetuen() {
        // TODO Auto-generated constructor stub
    }

    private String data;
    private String status;

    /**
     * @return the data
     * @author A18ccms a18ccms_gmail_com
     * @date 2016年1月25日 下午5:57:18
     */
    public String getData() {
        return this.data;
    }

    /**
     * @author A18ccms a18ccms_gmail_com
     * @date 2016年1月25日 下午5:57:18
     * @param data the data to set
     */
    public void setData(String data) {
        this.data = data;
    }

    /**
     * @return the status
     * @author A18ccms a18ccms_gmail_com
     * @date 2016年1月25日 下午5:57:18
     */
    public String getStatus() {
        return this.status;
    }

    /**
     * @author A18ccms a18ccms_gmail_com
     * @date 2016年1月25日 下午5:57:18
     * @param status the status to set
     */
    public void setStatus(String status) {
        this.status = status;
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
        return "AjaxRetuen [data=" + this.data + ", status=" + this.status + "]";
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
     * @date 2016年1月25日 下午5:57:23
     * @param data
     * @param status
     */
    public AjaxRetuen(String data, String status) {
        super();
        this.data = data;
        this.status = status;
    }
}
