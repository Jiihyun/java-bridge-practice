# 기능 목록

### bridgeGame
- move()
    - 위아래 둘 중 하나의 칸만 가능 (예외처리) []
- retry()
    - 만약 X 나오면 retry 호출 []
        - 다리 정답은 그대로며, 사용자 인풋만 처음부터 받기 []

### bridgeMaker

- 사이즈 받아서 스트링 리스트인 다리 정답 만들기 [o]

### bridgeResult

- 시도한 횟수 []
- 게임 성공 여부 (성공 못하고 Q할시 실패) []

### inputView

- 다리 사이즈 입력받기
    - 3이상~20이하 예외처리 [o]
    - 숫자 아닌 것들 예외처리 [o]
- readMoving()
    - U, D 중 어느 다리로 한 칸 이동할지 입력받기 []
    - U,D 외 예외처리 []
- readGameCommand()
    - 게임 재시작/종료 여부 []
    - R(재시작), Q(종료) 외 예외처리 []

### OutView

- printMap()
    - 다리 결과 OX []
- printResult()
    - 게임 성공 여부 및 시도한 횟수 출력 []