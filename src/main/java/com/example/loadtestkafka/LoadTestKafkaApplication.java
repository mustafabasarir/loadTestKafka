package com.example.loadtestkafka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class LoadTestKafkaApplication {


	public  static Long userId;
	private static ApplicationContext applicationContext;

	public LoadTestKafkaApplication() {
		userId = (long) 1L;
	}

	public static void main(String[] args){
	applicationContext =SpringApplication.run(LoadTestKafkaApplication.class, args);
	displayAllBeans();
	}


	public static void displayAllBeans() {

		String[] allBeanNames = applicationContext.getBeanDefinitionNames();
		int i =0;
		for (String beanName : allBeanNames) {
			i++;

			if (beanName.indexOf("kafka") != -1) System.out.println("***************  " + beanName);
			if (beanName.indexOf("myDemo") != -1) System.out.println("-----------------   "+beanName);
			//     System.out.println(i+ "       beanName :       " + beanName);
			//     applicationContext.getBean("myDemoTopic1").

		}
	}

}
