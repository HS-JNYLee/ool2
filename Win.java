import java.util.Random;

public class Win {
    public boolean chWin() {
// 이기면true 지면 false
        if(Character.Atk>Mon.Atk){
            return true;
        }
        else
            return false;
    }

    public void Reward() {
        // 승리 시 보상(식량,물,무기)
        Random random = new Random();
        int rewardIndex = random.nextInt(3);

        if (rewardIndex == 0) {
            // 식량 지급

        } else if (rewardIndex == 1) {
            // 물 지급

        } else {
            // 무기 지급
        }



    }
}
