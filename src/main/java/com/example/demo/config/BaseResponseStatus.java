package com.example.demo.config;

import lombok.Getter;

/**
 * 에러 코드 관리
 */
@Getter
public enum BaseResponseStatus {
    /**
     * 1000 : 요청 성공
     */
    SUCCESS(true, 1000, "요청에 성공하였습니다."),


    /**
     * 2000 : Request 오류
     */
    // Common
    REQUEST_ERROR(false, 2000, "입력값을 확인해주세요."),
    EMPTY_JWT(false, 2001, "JWT를 입력해주세요."),
    INVALID_JWT(false, 2002, "유효하지 않은 JWT입니다."),
    INVALID_USER_JWT(false,2003,"권한이 없는 유저의 접근입니다."),
    NULL_ERROR(false,2004,"공백을 허용하지 않습니다."),
    EMPTY_USER(false,2005,"존재하지 않는 유저입니다."),
    EMPTY_STORE(false,2006,"존재하지 않는 식당입니다."),
    EMPTY_REVIEW(false,2007,"존재하지 않는 리뷰입니다."),
    INVALID_FILE(false,2008,"잘못된 형식의 파일입니다."),
    EMPTY_CATEGORY(false, 2009, "존재하지 않는 카테고리입니다."),


    // users
    USERS_EMPTY_USER_ID(false, 2010, "유저 아이디 값을 확인해주세요."),
    EMPTY_PAGE(false,2011, "잘못된 페이지 요청입니다."),
    EMPTY_PAGE_SIZE(false, 2012, "잘못된 페이지 사이즈 요청입니다."),

    // [POST] /users
    POST_USERS_EMPTY_EMAIL(false, 2015, "존재하지 않는 이메일입니다."),
    POST_USERS_INVALID_EMAIL(false, 2016, "이메일 형식을 확인해주세요."),
    POST_USERS_EXISTS_EMAIL(false,2017,"중복된 이메일입니다."),
    POST_USERS_EXISTS_NICKNAME(false,2018,"중복된 닉네임입니다."),
    POST_USERS_EXISTS_PHONENUMBER(false,2019,"중복된 휴대폰 번호 입니다."),
    POST_USERS_INVALID_PASSWORD(false,2020,"비밀번호 형식을 확인해주세요."),
    POST_USERS_INVALID_NICKNAME(false, 2021,"닉네임 형식을 확인해주세요."),
    POST_USERS_INVALID_PHONENUMBER(false,2022,"휴대폰 번호 형식을 확인해주세요."),
    POST_USERS_INACTIVE_ACCOUNT(false,2023,"탈퇴한 계정입니다. 다시 회원가입을 진행해주세요."),

    //[PATCH] /users
    PATCH_USERS_EMPTY_PASSWORD(false,2024, "비밀번호를 입력해주세요"),

    // search
    SEARCH_EMPTY_KEYWORD(false, 2030, "검색할 키워드를 입력해주세요."),
    NO_RESULT_FOUND(false, 2031, "검색 결과가 없습니다."),
    SEARCH_EMPTY_TAG_ID(false, 2032, "해시태그 아이디 값을 확인해주세요"),
    EMPTY_TAG(false, 2033, "존재하지 않는 해시태그 입니다."),

    // store
    POST_STORE_EMPTY_CATEGORY(false,2040,"카테고리를 선택해주세요."),
    POST_STORE_EMPTY_RESTAURANT(false,2041,"식당을 선택해주세요."),
    POST_STORE_EXISTS_RESTAURANT(false,2042,"이미 저장된 식당입니다."),
    POST_STORE_EMPTY_STAR(false,2043,"식당에 점수를 매겨주세요."),
    POST_STORE_EMPTY_CONTENTS(false,2044,"내용을 입력해주세요."),
    STORES_EMPTY_STORE_ID(false,2045,"식당 아이디 값을 확인해주세요."),
    STORE_EMPTY_CATEGORY_ID(false, 2046, "카테고리 아이디 값을 확인해주세요"),
    STORE_INVALID_STAR_RATING(false, 2047, "starRating 값을 확인해주세요."),
    STORE_INVALID_DELIVERY_SERVICE(false, 2048, "deliveryService 값을 확인해주세요."),

    //reviews
    REVIEWS_EMPTY_REVIEW_ID(false,2050,"리뷰 아이디 값을 확인해주세요."),
    PATCH_REVIEW_EMPTY_STARRATE(false, 2051, "별점을 설정해주세요."),
    PATCH_REVIEW_EMPTY_CONTENTS(false, 2052, "내용을 입력해주세요."),

    // [PATCH] / users
    PATCH_USERS_STATUS_INVALID_PASSWORD(false,2060, "비밀번호가 틀렸습니다."),


    // auth
    GET_AUTH_EXPIRED_CERTNUMBER(false, 2070, "인증번호가 존재하지 않거나 인증시간이 초과했습니다."),
    GET_AUTH_INVALID_CERTNUMBER(false, 2071, "인증번호가 일치하지 않습니다."),
    POST_AUTH_FAIL_SMS(false, 2072, "인증문자 전송에 실패했습니다 관리자에게 문의해주세요."),
    AUTH_INVALID_PHONENUMBER(false,2073,"올바른 휴대폰번호를 입력해주세요."),
    EMPTY_CERT_NUMBER(false, 2074, "인증번호를 입력해 주세요."),




    /**
     * 3000 : Response 오류
     */
    // Common
    RESPONSE_ERROR(false, 3000, "값을 불러오는데 실패하였습니다."),

    // [POST] /users
    DUPLICATED_EMAIL(false, 3013, "중복된 이메일입니다."),
    FAILED_TO_LOGIN(false,3014,"비밀번호가 틀렸습니다."),

    // [GET] /reviews
    EMPTY_RECENT_REVIEWS(false, 3015, "최근리뷰가 존재하지 않습니다."),
    EMPTY_REVIEWS(false,3016, "리뷰가 존재하지 않습니다."),

    /**
     * 4000 : Database, Server 오류
     */
    DATABASE_ERROR(false, 4000, "데이터베이스 연결에 실패하였습니다."),
    SERVER_ERROR(false, 4001, "서버와의 연결에 실패하였습니다."),


    PASSWORD_ENCRYPTION_ERROR(false, 4011, "비밀번호 암호화에 실패하였습니다."),
    PASSWORD_DECRYPTION_ERROR(false, 4012, "비밀번호 복호화에 실패하였습니다."),

    // review
    EDIT_FAIL_REVIEW(false, 4021, "리뷰 수정에 실패하였습니다.");



    // 5000 : 필요시 만들어서 쓰세요
    // 6000 : 필요시 만들어서 쓰세요


    private final boolean isSuccess;
    private final int code;
    private final String message;

    private BaseResponseStatus(boolean isSuccess, int code, String message) {
        this.isSuccess = isSuccess;
        this.code = code;
        this.message = message;
    }
}