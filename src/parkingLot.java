import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class parkingLot {
    private Queue<Integer>[] parkingFloors; 

    public parkingLot() {
        parkingFloors = new Queue[5]; 
        for (int i = 0; i < 5; i++) {
            parkingFloors[i] = new LinkedList<>(); 
        }
    }

    public void park(int carNum) {
        boolean parked = false;
        for (Queue<Integer> parkingFloor : parkingFloors) {
            if (parkingFloor.size() < 15) {
                parkingFloor.add(carNum);
                System.out.println(carNum + "가" + (Arrays.asList(parkingFloors).indexOf(parkingFloor) + 1) + "층에 주차되었습니다.");
                parked = true;
                break;
            }
        }
        if (!parked) {
            System.out.println("주차 공간이 없습니다.");
        }
    }

    public int exit() {
        int car = -1;
        for (Queue<Integer> parkingFloor : parkingFloors) {
            if (!parkingFloor.isEmpty()) {
                car = parkingFloor.poll();
                System.out.println(car + "가" + Arrays.asList(parkingFloors).indexOf(parkingFloor) + 1 + "층에서 출차되었습니다.");
                break;
            }
        }
        if (car == -1) {
            System.out.println("주차된 차량이 없습니다.");
        }
        return car;
    }

    public static void main(String[] args) {
        parkingLot parkingtower = new parkingLot();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("1. 차량 입차하기");
            System.out.println("2. 차량 출차하기");
            System.out.println("3. 종료하기");
            System.out.println("원하는 작업의 번호를 입력하세요");
            int num = scanner.nextInt();
            if (num == 1) {
                System.out.println("보관할 차량의 번호를 입력하세요");
                int carNum = scanner.nextInt();
                parkingtower.park(carNum);
            } else if (num == 2) {
                parkingtower.exit();
            } else if (num == 3) {
                System.out.println("주차프로그램을 종료합니다.");
                break;
            } else {
                System.out.println("잘못된 입력입니다. 다시 입력해주세요.");
            }
            System.out.println();
        }
    }
}
