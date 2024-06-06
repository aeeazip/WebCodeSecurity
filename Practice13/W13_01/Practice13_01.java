// 컴퓨터학과, 20201019, 정채원
package Practice13.W13_01;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

public class Practice13_01 {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException {
        /*
         * 필요한 정보
         *
         * 1. 클래스 이름
         * 2. 소속 변수의 이름과 타입, 접근 제어자
         * 3. 소속 메소드의 메소드 시그니처
         * 4. 생성자 시그니처
         */

        Class<?> cls = Class.forName("Date");

        // 메소드 정보 얻기
        Method[] mlist = cls.getDeclaredMethods();
        for(Method m: mlist) {
            System.out.println("클래스명 : " + m.getDeclaringClass()); // 1. 클래스 이름
            System.out.println("소속 메소드 시그니처 : " + m.toString()); // 3. 메소드 시그니처
        }

        // 필드 정보 얻기
        Field[] flist = cls.getDeclaredFields();
        for(Field f : flist) {
            System.out.println(
                    "클래스 필드명 : " + f.getName() +
                    " 클래스 필드 타입 : " + f.getType() +
                    " 클래스 필드 접근제어자 : " + Modifier.toString(f.getModifiers())
            ); // 2. 소속 변수의 이름과 타입, 접근 제어자
        }

        // 생성자 정보 얻기
        Constructor<?>[] clist = cls.getDeclaredConstructors();
        for(Constructor<?> c : clist) {
            System.out.println("생성자 시그니처 : " + c.toString()); // 4. 생성자 시그니처
        }
    }
}