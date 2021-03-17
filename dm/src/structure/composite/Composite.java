package structure.composite;

import java.util.ArrayList;
import java.util.List;

/**
 * 组合模式
 *
 * @author qihaodong
 */
public class Composite {

    public static void main(String[] args) {
        Composite test = new Composite();
        Component c0 = test.new CompositeTest();
        Component c1 = test.new CompositeTest();
        Component l1 = test.new Leaf("叶子结点(1)");
        Component l2 = test.new Leaf("叶子结点(2)");
        Component l3 = test.new Leaf("叶子结点(3)");
        c0.add(l1);
        c0.add(c1);
        c1.add(l2);
        c1.add(l3);
        c0.operation();
    }

    /**
     * 抽象构件
     */
    interface Component {

        void add(Component c);

        void remove(Component c);

        Component getChild(int i);

        void operation();

    }

    /**
     * 树叶构件
     */
    class Leaf implements Component {

        String name;

        public Leaf(String name) {
            this.name = name;
        }

        @Override
        public void add(Component c) {

        }

        @Override
        public void remove(Component c) {

        }

        @Override
        public Component getChild(int i) {
            return null;
        }

        @Override
        public void operation() {
            System.out.println("树叶" + name + "被访问");
        }

    }

    class CompositeTest implements Component {

        private List<Component> children = new ArrayList<>();

        @Override
        public void add(Component c) {
            children.add(c);
        }

        @Override
        public void remove(Component c) {
            children.remove(c);
        }

        @Override
        public Component getChild(int i) {
            return children.get(i);
        }

        @Override
        public void operation() {
            for (Component c : children) {
                c.operation();
            }
        }
    }


}
