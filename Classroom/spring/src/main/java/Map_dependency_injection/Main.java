package Map_dependency_injection;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;

public class Main {

    public static void main(String[] args) {

        ClassPathResource resource = new ClassPathResource("map_kit.xml");

        BeanFactory factory = new XmlBeanFactory(resource);

        Kit k = (Kit) factory.getBean("kit");

        System.out.println(k);
    }
}