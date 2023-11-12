/**
 * 작성자 : JNYLee
 * 마지막 수정 : 23.11.13
 * 설명 : 아이템의 최상위 클래스, 이미지 정보 포함.
 **/

public class Item {
    private String imgLink; // 아이템의 이미지 주소를 저장할 변수

    public String getImgLink() {
        return imgLink;
    }

    public void setImgLink(String imgLink) {
        this.imgLink = imgLink;
    }
}
