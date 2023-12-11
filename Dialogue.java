import src.main.inventory.Weapon;

/**
 * 작성자 : JNYLee
 * 마지막 수정 : 23.11.13
 * 설명 : 게임 이벤트 상호작용으로 나오는 메세지 클래스
 **/

public class Dialogue {
    public String getReward(String itemName, int count) { // 보상을 획득했을 때 나오는 메서드
        return "승리! \n"+ itemName + "을(를) " + count + "개 획득하였습니다.";
    }

    public String selectRegion() { // 하루가 넘어가고 지역을 선택 단계임을 알려주는 메서드
        return "다음 지역을 선택하세요.";
    }

    public String getMonster(int attckStatus) { // 몬스터와 조우했을 때 몬스터의 정보를 알려주는 메서드
        return "공격력: " + attckStatus;
    }

    public String getWeapon(int attackStatus, int remainNumber) { // 무기 아이템에 마우스를 올렸을 때 알려주는 정보
        return "공격력: " + attackStatus + ", 사용 가능 횟수: " + remainNumber + "회 남음";
    }

    public String useItem(String item) {
        return item + "을(를) 사용하였습니다.";
    } // 해당 아이템을 사용했을 때 사용했음을 알려주는 메서드

    public String changeWeapon(Weapon beforeWeapon, Weapon afterWeapon) { // 무기를 교체했음을 알려주는 메서드
        return beforeWeapon.getName() + "을(를) " + afterWeapon.getName() + "로 교체하였습니다.";
    }

    public String arriveRegion() {
        return "해당 지역에 도착하였습니다.";
    } // 선택한 지역으로 이동했음을 알려주는 메서드

    public String noticeNight() { // 밤 시간이 되었음을 알려주는 메서드
        return "밤이 되었습니다.\n 몬스터가 랜덤하게 출몰하기 시작합니다.";
    }
}
