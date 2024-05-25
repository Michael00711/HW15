import java.lang.reflect.Field;

class A {
    private String id = "123";
    private String name = "A";

    private A() {
    }

    @Override
    public String toString() {
        return "A{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}

public class Main {
    public static void main(String[] args) throws Exception {
        java.lang.reflect.Constructor<A> constructor = A.class.getDeclaredConstructor();

        constructor.setAccessible(true);

        A instance = constructor.newInstance();

        Field idField = A.class.getDeclaredField("id");
        Field nameField = A.class.getDeclaredField("name");

        idField.setAccessible(true);
        nameField.setAccessible(true);

        idField.set(instance, "456");
        nameField.set(instance, "B");

        System.out.println(instance);
    }
}
