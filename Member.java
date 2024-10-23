
package netflix;

import java.util.Scanner;


import java.util.Calendar;

public class Member {
    private static Member m;
    public static Member getInstance(){
        if(m == null){
            m = new Member();
        }
        return m;
    }
    public static void freeInstance(){
        m=null;
    }
    Member(){}
    String name;
    String personalYY;
    String personalMM;
    String personalDD;
    String email;
    String pw;
    public void memberGuide(){
        Scanner sc = new Scanner(System.in);
        System.out.println("안녕하세요. 넷플릭스입니다.\n"
                + "이용권 구매를 위해선 회원가입이 필요합니다.\n"
                + "회원가입을 진행하시겠습니까?\n"
                +"[1]예\t[2]아니요");

        String answer = "";
        for(;;){
            answer = sc.next();
            if(answer.equals("1") || answer.equals("예")){
                personalData();
                break;
            }else if(answer.equals("2")||answer.equals("아니오")){
                System.out.println("회원이 아니면 구매할 수 없습니다.");
                System.exit(0);
            }else{
                System.out.println("잘못된 입력입니다. 다시 입력해주세요.");
            }
        }
    }
    private void personalData() {
        Scanner sc = new Scanner(System.in);
        System.out.println("================================================");
        System.out.println("회원가입을 위해 아래의 양식을 채워주세요.");
        System.out.print("이름 : ");
        this.name = sc.next();
        //미성년자 가입시 연령제한 프로그램 시청 x -> 키즈채널
        int personalYYnum = 0;

        Calendar cal = Calendar.getInstance();
        int yy = cal.get(Calendar.YEAR); //현재년도

        for(;;){
            System.out.print("태어난 연도 : ");
            this.personalYY = sc.next();

            personalYYnum = Integer.parseInt(personalYY);

            if(personalYYnum == yy || personalYYnum > yy - 20 && personalYYnum < yy){
                System.out.println("[키즈채널]로 안내 도와드리겠습니다.");
                break;
            }else if(personalYYnum < 1900 || personalYYnum > yy){
                System.out.println("잘못된 입력입니다.");
            }else{
                System.out.println("[일반채널]로 안내 도와드리겠습니다.");
                break;
            }
        }


        System.out.print("결제 비밀번호 : ");
        sc.nextLine();
        this.pw = sc.next();

        System.out.println("회원가입이 완료되었습니다.");
        System.out.println("================================================");
    }

}
