package com.kovshar.model;

public class NotUniqueNicknameException extends Exception {
    private String nickname;

    NotUniqueNicknameException(String nickname) {
        this.nickname = nickname;
    }

    public String getNickname() {
        return nickname;
    }

    @Override
    public String toString() {
        return "Not Unique nickname: " + nickname;
    }
}