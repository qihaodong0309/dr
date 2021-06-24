package creative.builder;

/**
 * @author qihaodong
 */
public class JavaBuilderMode {

    public static void main(String[] args) {
        JavaBuilderMode mode = new Builder(1, "张三").age(10).sex(1).build();
    }

    private int id;
    private String name;
    private int age;
    private int sex;

    private JavaBuilderMode(Builder builder) {
        id = builder.id;
        name = builder.name;
        age = builder.age;
        sex = builder.sex;
    }


    public static final class Builder {
        private int id;
        private String name;
        private int age;
        private int sex;

        public Builder(int id, String name) {
            this.id = id;
            this.name = name;
        }

        public Builder age(int val) {
            age = val;
            return this;
        }

        public Builder sex(int val) {
            sex = val;
            return this;
        }

        public JavaBuilderMode build() {
            return new JavaBuilderMode(this);
        }
    }
}
