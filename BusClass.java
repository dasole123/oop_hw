import java.text.SimpleDateFormat;
import java.util.Date;

public class BusClass {

    static String status = "운행";
    static int maxNum = 30;
    static int oil = 0;
    static int passCnt = 0;
    static int currentSpeed = 0;

    public static void main(String[] args) {
        /**
         * 1. 최대승객수
         * 2. 현재승객수
         * 3. 요금
         * 4. 버스 번호
         * 5. 주유량
         * 6. 현재속도
         * 7. 상태
         */

        String msg="";
        //TODO 속도는 입력받아서 사용
        int velocity =60;

        //test용
        oil = 60;

        // 버스생성
        String busNum = makeBus();

        // 버스상태변경
        msg = changeBus();

        // 승객 탑승
        addPasssenger();

        // 속도변경
        msg = changeSpeed(velocity);

        if(msg != null) {
            System.out.println(msg);
        }

        System.out.println("버스번호 : "+ busNum);
        System.out.println("버스상태 : "+ status);
        System.out.println("버스속도 : "+ currentSpeed);
        System.out.println("현재승객수 : "+passCnt);
        System.out.println("주유량 : "+oil);

    }
    /**
     * 고유값을 갖는 버스 생성
     * @return uID
     */
    public static String makeBus() {


        SimpleDateFormat sdf = new SimpleDateFormat("YYYYMMDDHHMMSS");
        Date sysDt = new Date();
        String busID = sdf.format(sysDt);
        busID = busID.substring(busID.length()-2, busID.length());
        int rdNum = (int) (Math.random()*10);
        String uniqueNum = Integer.toString(rdNum).substring(0,1);
        busID = busID.concat(uniqueNum);

        if(busID.startsWith("0")) {
            busID = busID.substring(1);
        }

        return busID;
    }

    /**
     * 버스 상태변경
     *
     */
    public static String changeBus() {
        String msg ="";

        if(oil < 10) {
            msg = "주유량을 확인해 주세요.";
            status = "차고지행";
        }
        return msg;

    }

    /**
     * 승객탑승
     */

    public static void addPasssenger() {

        //상태가 운행중일때 && 승객수가 최대 승객수 보다 작을 때만 승객을 태울 수 있다.
        if("운행".equals(status) && passCnt < maxNum) {
            //0~10 사이의 숫자 random으로 승객이 탐
            passCnt +=(int) (Math.random()*10);

            //승객수가 최대 승객수보다 높으면 최대승객수로 set
            if(passCnt > maxNum) {
                passCnt = maxNum;
            }
        }
    }

    /**
     * 속도변경
     */
    public static String changeSpeed(int velocity) {
        String msg="";
        if(oil < 10) {
            msg = "주유량을 확인해 주세요.";
            status = "차고지행";
        }
        currentSpeed = currentSpeed + velocity;

        return msg;
    }

}
