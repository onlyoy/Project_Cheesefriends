package mul.cam.a;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling // 스케쥴링 실행하기 위한 어노테이션
public class CheesefriendsBackApplication {

	public static void main(String[] args) {
		SpringApplication.run(CheesefriendsBackApplication.class, args);
	}

}