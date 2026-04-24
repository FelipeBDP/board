package br.com.dio.persistence.entity;

public enum BoardColumnKindEnum {

    INITIAL, FINAL, CANCEL, PENDING;

    public static BoardColumnKindEnum findByName(final String name){
        return Enum.valueOf(BoardColumnKindEnum.class, name);
    }

}
