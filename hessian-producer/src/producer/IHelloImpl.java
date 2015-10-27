package producer;

import com.caucho.hessian.server.HessianServlet;

public class IHelloImpl extends HessianServlet implements IHello {

    @Override
    public String sayHello() {
        // TODO Auto-generated method stub
        return "Hello,I from HessianService";
    }

}
