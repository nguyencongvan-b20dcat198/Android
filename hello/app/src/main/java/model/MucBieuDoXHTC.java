package model;

public class MucBieuDoXHTC {
    private String lable;
    private double percent, totalAmount;
    private int color;

    public MucBieuDoXHTC(String lable, double percent, double totalAmount, int color) {
        this.lable = lable;
        this.percent = percent;
        this.totalAmount = totalAmount;
        this.color = color;
    }

    public String getLable() {
        return lable;
    }

    public void setLable(String lable) {
        this.lable = lable;
    }

    public double getPercent() {
        return percent;
    }

    public void setPercent(double percent) {
        this.percent = percent;
    }

    public double getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(double totalAmount) {
        this.totalAmount = totalAmount;
    }

    public int getColor() {
        return color;
    }

    public void setColor(int color) {
        this.color = color;
    }
}
