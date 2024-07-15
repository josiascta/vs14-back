package model;

import java.util.Arrays;

public enum QuestionType {

    MULTIPLE_CHOICE(1),
    COMPLETING(2);

    private Integer type;

    QuestionType(Integer type) {
        this.type = type;
    }

    public Integer getType() {
        return type;
    }

    public static QuestionType ofTipo(Integer type){ //
        return Arrays.stream(QuestionType.values())
                .filter(tp -> tp.getType().equals(type))
                .findFirst()
                .get();
    }
}
