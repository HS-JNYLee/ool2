public class Lose {
    //public String getImgLink() {
      // return imgLink;
    //} //패배시 이미지 삽입



    public boolean MonWin(Character1 c, Monster m) {   //mon가 Atk이 더 높아 플레이어가 졌을 시
// 지면true 이기면 false
        if(c.attack<m.attack){
            //여기서 Character Hp 감소
            c.decreaseHp(10); //지면 체력 10 감소
            return true;                //Mon.Atk-Cha.Atk으로 변경 가능(하스처럼)
        }
        else
            return false;
    }


}
