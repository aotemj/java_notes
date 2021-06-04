import com.test03.MyService;
import com.test03.impl.Class2;

module Module1 {
    exports com.test01;
    exports com.test02;
    exports com.test03;
    // 服务的具体实现类
    provides MyService with Class2;
}