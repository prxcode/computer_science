class Bike{
    final void run(){
        System.out.prinln("running");
    }
}
class Honda extends Bike{
  void run(){
    Systen.out.println("running safely with 100kmph");
  }
  public static void main(String args[]){
    Honda honda = new Honda();
    honda.run();
  }
}
