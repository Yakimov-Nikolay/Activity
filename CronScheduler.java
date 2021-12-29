package activity.activity;

import activity.activity.repository.PictureCloudRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class CronScheduler {
    private final PictureCloudRepository pictureCloudRepository;

    private final Logger LOGGER = LoggerFactory.getLogger(CronScheduler.class);

    public CronScheduler(PictureCloudRepository pictureCloudRepository) {
        this.pictureCloudRepository = pictureCloudRepository;
    }

    @Scheduled(cron = "${schedulers.cron}")
    public void deletePicture() {
        pictureCloudRepository.deleteAll();
        LOGGER.info("The task was successful ended at {}", LocalDateTime.now());
    }
}
