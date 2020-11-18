package custom;

/**
 * @author qihaodong
 */
public class CustomTest {

    private void testService() {
        CustomService<String> service = (s1, s2) -> {
            return s1 + s2;
        };
        System.out.println(service.oneParamMethod("aaa", "bbb"));
    }

    private void testClass() {
        CustomClass<String> customClass = new CustomClass<>();
        customClass.forEach((s1, s2) -> {
            return s1 + s2;
        });
    }

}