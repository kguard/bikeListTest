package com.kguard.bikelisttest.util

object FetchStateHandler { //Static 처럼 사용
    operator fun invoke(state: Pair<Throwable, FetchState>): String{ // 함수 호출 없이 사용할 수 있는 연산자
        return when(state.second){
            FetchState.BAD_INTERNET -> "인터넷 연결 실패"
            FetchState.PARSE_ERROR -> "입력 오류"
            FetchState.SOCKET_TIMEOUT_EXCEPTION -> "연결 시간 초과"
            FetchState.WRONG_CONNECTION -> "Wrong Connection 오류"
            FetchState.IllegalStateException -> "서버 리턴값 받기 오류"
            else -> "저장 안된 오류 ${state.first.message}"
        }
    }
}