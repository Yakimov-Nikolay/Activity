package activity.activity.model.entity;


import activity.activity.model.entity.enums.LevelEnumName;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Table;

@Entity
@Table(name = "levels")
public class LevelEntity extends BaseEntity {

    private LevelEnumName levelName;

    public LevelEntity() {
    }

    @Enumerated(EnumType.STRING)
    public LevelEnumName getLevel() {
        return levelName;
    }

    public LevelEntity setLevel(LevelEnumName levelName) {
        this.levelName = levelName;
        return this;
    }
}
