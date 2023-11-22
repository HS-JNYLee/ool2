public class Character {
    private static int Hp = 100; // 체력
    private int Fullness; // 포만감
    private int Water; // 수분
    int Atk; // 공격력
    private int Def; // 방어력

    public void SetFullness(int fullness) {
        Fullness += fullness; // 포만감 증가
    }

   public void SetWater(int water) {
        Water += water; // 수분 증가
    }

    void setAtk(int atk) {
        Atk = atk; // 공격력 설정
    }

    void setDef(int def) {
        Def = def; // 방어력 설정
    }

    static void decreaseHp(int hp) {
        Hp -= hp;
    }
}
