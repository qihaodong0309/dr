package custom;

/**
 * 自定义函数接口测试 Lambda
 *
 * @author qihaodong
 */
public interface CustomService<T> {

    /**
     * 两个参数的方法
     *
     * @param t1
     * @param t2
     * @return
     */
    String oneParamMethod(T t1, T t2);

}