package structure.facade;

/**
 * 外观模式
 *
 * @author qihaodong
 */
public class Facade {

    public static void main(String[] args) {
        Facade test = new Facade();
        FacadeTest facade = test.new FacadeTest();
        facade.method1();
        facade.method2();
        facade.method3();
    }

    /**
     * 外观角色
     */
    class FacadeTest {

        private SubSystem01 subSystem01 = new SubSystem01();
        private SubSystem02 subSystem02 = new SubSystem02();
        private SubSystem03 subSystem03 = new SubSystem03();

        public void method1() {
            subSystem01.method1();
        }

        public void method2() {
            subSystem02.method2();
        }

        public void method3() {
            subSystem03.method3();
        }
    }

    class SubSystem01 {
        public void method1() {
            System.out.println("子系统01的method1()被调用");
        }
    }

    class SubSystem02 {
        public void method2() {
            System.out.println("子系统02的method2()被调用");
        }
    }

    class SubSystem03 {
        public void method3() {
            System.out.println("子系统03的method3()被调用");
        }
    }

}
