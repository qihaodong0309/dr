package custom;

import java.util.List;

/**
 * @author qihaodong
 */
public class CustomClass<T> {

    private List<T> list;

    public void forEach(CustomService<T> service) {
        for (T t : list) {
            service.oneParamMethod(t, t);
        }
    }

}