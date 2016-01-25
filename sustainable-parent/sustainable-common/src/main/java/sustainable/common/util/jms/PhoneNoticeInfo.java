/**   
* @Title: PhoneNoticeInfo.java 
* @Package sustainable.common.util.jms 
* @Description: TODO(用一句话描述该文件做什么) 
* @author scc
* @date 2016年1月22日 下午6:15:32   
*/
package sustainable.common.util.jms;

import java.io.Serializable;

/**
 * @ClassName: PhoneNoticeInfo
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author scc
 * @date 2016年1月22日 下午6:15:32
 * 
 */
public class PhoneNoticeInfo implements Serializable {

    /**
     * @Fields serialVersionUID : TODO(用一句话描述这个变量表示什么)
     * @author scc
     * @date 2016年1月22日 下午6:16:07
     */
    private static final long serialVersionUID = -4058326894040988094L;

    /**
     * <p>
     * Title:
     * </p>
     * <p>
     * Description:
     * </p>
     * 
     * @author scc
     * @date 2016年1月22日 下午6:15:32
     */
    public PhoneNoticeInfo() {
        // TODO Auto-generated constructor stub
    }

    /** 消息标题 */
    public String noticeTitle;
    /** 消息内容 */
    public String noticeContent;
    /** 接收者 */
    public String receiver;
    /** 接收手机号 */
    public String receiverPhone;

    public String getNoticeTitle() {
        return this.noticeTitle;
    }

    public void setNoticeTitle(String noticeTitle) {
        this.noticeTitle = noticeTitle;
    }

    public String getNoticeContent() {
        return this.noticeContent;
    }

    public void setNoticeContent(String noticeContent) {
        this.noticeContent = noticeContent;
    }

    public String getReceiver() {
        return this.receiver;
    }

    public void setReceiver(String receiver) {
        this.receiver = receiver;
    }

    public String getReceiverPhone() {
        return this.receiverPhone;
    }

    public void setReceiverPhone(String receiverPhone) {
        this.receiverPhone = receiverPhone;
    }
}
