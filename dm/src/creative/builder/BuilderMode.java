package creative.builder;

/**
 * 建造者模式
 *
 * @author qihaodong
 */
public class BuilderMode {

    /*
    构建者模式实际上就是将复杂对象的创建包装起来，对外只提供简单接口，隐藏具体初始化细节。
    好处是一旦业务上需要做修改时，只需要修改对应包装类，不用在代码中寻找所有初始化对象的代码块修改
    一般类初始化比较简单时采用工厂模式，初始化复杂才使用建造者模式
     */

    public static void main(String[] args) {
        Builder builderA = new BuilderA();
        Builder builderB = new BuilderB();
        Director director = new Director(builderA);
        director.createModel().display();
        director.setBuilder(builderB);
        director.createModel().display();
    }

    public static class Model {

        private String name;
        private String info;

        public void setName(String name) {
            this.name = name;
        }

        public void setInfo(String info) {
            this.info = info;
        }

        public void display() {
            System.out.println(name + "---" + info);
        }

    }

    public static abstract class Builder {

        Model model = new Model();

        /**
         * 建造 Name 属性
         */
        public abstract void buildName();

        /**
         * 建造 Info 属性
         */
        public abstract void buildInfo();

        public Model getResult() {
            return model;
        }
    }

    public static class BuilderA extends Builder {

        @Override
        public void buildName() {
            model.setName("张三");
        }

        @Override
        public void buildInfo() {
            model.setInfo("BuilderA 构造器创建");
        }
    }

    public static class BuilderB extends Builder {

        @Override
        public void buildName() {
            model.setName("李四");
        }

        @Override
        public void buildInfo() {
            model.setInfo("BuilderB 构造器创建");
        }
    }

    /**
     * 指挥器
     */
    public static class Director {

        private Builder builder;

        public Director(Builder builder) {
            this.builder = builder;
        }

        public void setBuilder(Builder builder) {
            this.builder = builder;
        }

        public Model createModel() {
            builder.buildName();
            builder.buildInfo();
            return builder.getResult();
        }

    }

}
