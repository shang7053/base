/**   
 *
 * @Title: SpelTest.java 
 * @Package test.spel 
 * @Description: TODO(用一句话描述该文件做什么) 
 * @author scc
 * @date 2016年8月1日 下午5:30:47   
 */
package test.spel;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 *
 * @ClassName: SpelTest
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author scc
 * @date 2016年8月1日 下午5:30:47
 * 
 */
@Component
public class SpelTest {
    @Value("true")
    private Boolean flag;

    /**
     *
     * <p>
     * Title:
     * </p>
     * <p>
     * Description:
     * </p>
     * 
     * @author scc
     * @date 2016年8月1日 下午5:30:47
     */
    public SpelTest() {
        // TODO Auto-generated constructor stub
    }

    public String getflag() {
        return this.flag.toString();
    }
}
