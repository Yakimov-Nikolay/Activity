package activity.activity.service.impl;

import activity.activity.model.entity.LevelEntity;
import activity.activity.model.entity.enums.LevelEnumName;
import activity.activity.repository.LevelRepository;
import activity.activity.service.LevelService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LevelServiceImpl implements LevelService {

    private final LevelRepository levelRepository;

    public LevelServiceImpl(LevelRepository levelRepository) {
        this.levelRepository = levelRepository;
    }

    @Override
    public void initLevel() {
        if (levelRepository.count() != 0) {
            return;
        }
        LevelEntity beginner = new LevelEntity();
        beginner.setLevel(LevelEnumName.BEGINNER);

        LevelEntity medium = new LevelEntity();
        medium.setLevel(LevelEnumName.MEDIUM);

        LevelEntity advanced = new LevelEntity();
        advanced.setLevel(LevelEnumName.ADVANCED);

      levelRepository.saveAll(List.of(beginner, medium, advanced));
    }
}
