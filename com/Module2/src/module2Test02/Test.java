package module2Test02;

import com.test03.MyService;

import java.util.ServiceLoader;

public class Test {
    public static void main(String[] args) {
        // 加载服务
        ServiceLoader<MyService> services = ServiceLoader.load(MyService.class);
        for (MyService service : services) {
            service.service();
        }
    }
}
