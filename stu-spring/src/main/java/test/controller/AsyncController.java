/**   
 *
 * @Title: AsyncController.java 
 * @Package test.controller 
 * @Description: TODO(用一句话描述该文件做什么) 
 * @author scc
 * @date 2017年4月25日 下午4:05:35   
 */
package test.controller;

import java.util.concurrent.Callable;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @ClassName: AsyncController
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author scc
 * @date 2017年4月25日 下午4:05:35
 * 
 */
@Controller
public class AsyncController {

    @RequestMapping("/testasync")
    public Callable<String> callable() {

        return new Callable<String>() {
            @Override
            public String call() throws Exception {
                Thread.sleep(2000);
                return "index2";
            }
        };
    }

}
