package study.spring.file.event;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import study.spring.file.service.FilesStorageService;

@Component
public class ApplicationEventListener implements ApplicationListener<ContextRefreshedEvent> {

	@Autowired
	private FilesStorageService storageService;

	@Override
	public void onApplicationEvent(ContextRefreshedEvent event) {
		storageService.init();
	}

}
