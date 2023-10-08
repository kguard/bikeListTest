package com.kguard.bikelisttest.util

enum class FetchState {
    BAD_INTERNET, // 인터넷 연결 실패
    PARSE_ERROR, // 입력 오류
    WRONG_CONNECTION, // WRONG_CONNECTION 오류
    SOCKET_TIMEOUT_EXCEPTION , // 연결 시간 초과
    IllegalStateException, // 서버 리턴값 받기 오류
    FAIL //
}