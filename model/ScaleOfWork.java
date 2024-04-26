package model;

public class ScaleOfWork {
  private String arrivalTime;
  private String breakTime;
  private String departureTime;

  public ScaleOfWork(String arrivalTime, String breakTime, String departureTime) {
    this.arrivalTime = arrivalTime;
    this.breakTime = breakTime;
    this.departureTime = departureTime;
  }
  public ScaleOfWork() {
  }
  public String getArrivalTime() {
    return arrivalTime;
  }
  public void setArrivalTime(String arrivalTime) {
    this.arrivalTime = arrivalTime;
  }
  public String getBreakTime() {
    return breakTime;
  }
  public void setBreakTime(String breakTime) {
    this.breakTime = breakTime;
  }
  public String getDepartureTime() {
    return departureTime;
  }
  public void setDepartureTime(String departureTime) {
    this.departureTime = departureTime;
  }
  @Override
  public String toString() {
    return "ScaleOfWork [arrivalTime=" + arrivalTime + ", breakTime=" + breakTime + ", departureTime=" + departureTime
        + "]";
  }
}
