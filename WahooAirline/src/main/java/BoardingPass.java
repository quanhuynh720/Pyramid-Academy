public class BoardingPass {

    private int boardingPassNumber;
    private float price;
    private String  ETA = "2 hours";

    public int getBoardingPassNumber() {
        return boardingPassNumber;
    }

    public float getPrice() {
        return price;
    }

    public String getETA() {
        return ETA;
    }

    public void setBoardingPassNumber(int boardingPassNumber) {
        this.boardingPassNumber = boardingPassNumber;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public void setETA(String ETA) {
        this.ETA = ETA;
    }


}
