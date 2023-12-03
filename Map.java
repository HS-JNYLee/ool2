//서울, 부천, 수원, 평택, 대전, 대구, 부산, 제주도
public class Map {
    private String name;  // 지역 이름
    private Monster monster;  // 해당 지역의 몬스터

    public Map(String name, Monster monster) {  // 맵 생성 (지역 이름, 몬스터)
        this.name = name;
        this.monster = monster;
    }

    // getter & setter
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Monster getMonster() {
        return monster;
    }

    public void setMonster(Monster monster) {
        this.monster = monster;
    }
}
