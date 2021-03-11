package creative.prototype;

/**
 * 原型模式实例
 *
 * @author qihaodong
 */
public class ProtoTypeCitation {

    /*
    原型模式本质就是通过原有模型为模板，克隆出一个新的对象，省去对象初始化一系列繁琐的操作，提高效率。
    JAVA 本身提供 cloneAble 接口方便克隆，这里需要注意深克隆还是浅克隆。
     */

    public static void main(String[] args) throws CloneNotSupportedException {
        Citation citation1 = new Citation("张三", "被评为三好学生。", "学院");
        citation1.display();
        Citation citation2 = (Citation) citation1.clone();
        citation2.setName("李四");
        citation2.display();
    }

    static class Citation implements Cloneable {

        private String name;
        private String info;
        private String school;

        public Citation(String name, String info, String school) {
            this.name = name;
            this.info = info;
            this.school = school;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        private void display() {
            System.out.println(name + info + school);
        }

        @Override
        protected Object clone() throws CloneNotSupportedException {
            System.out.println("克隆成功！");
            return super.clone();
        }

    }

}