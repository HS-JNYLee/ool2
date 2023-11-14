public class Character {
    private static int Hp=100; //체력
    private int Fullness; //포만감
    private int Water;//수분
    public static int Atk;//공격력
    private int Def;//방어력

    void SetFullnes(int fullness){
    Fullness+=fullness;      //포만감 증가
    }
    void SetWater(int water){
    Water+=water;           //수분 증가
    }
     static void deacreaseHp(int hp){
        Hp-=hp;
    }

}
