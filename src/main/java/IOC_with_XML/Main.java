package IOC_with_XML;

import dependency_injection.Library;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.core.io.ClassPathResource;
import org.springframework.beans.factory.xml.XmlBeanFactory;

public class Main {

    public static void main(String[] args) {

//        ClassPathResource resource = new ClassPathResource("bean_configuration.xml");
//        BeanFactory factory = new XmlBeanFactory(resource);
//
//        Favourite fav=(Favourite) factory.getBean("fav");
//
//        System.out.println(fav);

        ClassPathResource resource = new ClassPathResource("library_book_dependency.xml");
        BeanFactory factory = new XmlBeanFactory(resource);

        Library lib = (Library) factory.getBean("library");

        System.out.println(lib);

    }
}