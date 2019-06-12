package com.kovshar.model;

public enum SimpleDataBase {
    FIRST_NOTE("Alex", "Mol", "alexamolodoy"),
    SECOND_NOTE("Ruslan", "Kovshar", "ruslan.kovshar"),
    THIRD_NOTE("Nick", "Wood", "nicwood");

    private String firstName;
    private String secondName;
    private String nickname;

    SimpleDataBase(String firstName, String secondName, String nickname) {
        this.firstName = firstName;
        this.secondName = secondName;
        this.nickname = nickname;
    }

    public static boolean checkNickname(String nickname) {
        for (SimpleDataBase i : SimpleDataBase.values()) {
            if (i.nickname.equals(nickname)) {
                return true;
            }
        }
        return false;
    }
}
