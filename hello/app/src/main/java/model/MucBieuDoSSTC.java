package model;

public class MucBieuDoSSTC {
    private String time;
    private double income, expense, residual;

    public MucBieuDoSSTC(String time, double income, double expense, double residual) {
        this.time = time;
        this.income = income;
        this.expense = expense;
        this.residual = residual;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public double getIncome() {
        return income;
    }

    public void setIncome(double income) {
        this.income = income;
    }

    public double getExpense() {
        return expense;
    }

    public void setExpense(double expense) {
        this.expense = expense;
    }

    public double getResidual() {
        return residual;
    }

    public void setResidual(double residual) {
        this.residual = residual;
    }
}
