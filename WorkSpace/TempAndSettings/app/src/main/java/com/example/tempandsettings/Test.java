package com.example.tempandsettings;

public class Test {
    //인스턴스멤버 3개만들기
    //변수 2, 메소드1

    int iV1, iV2;
    void iMethod(){
        this.sV1=10;
        sV2=20; //this는 안써도 괜찮음.
    }

    // 스태틱 멤버 3개
    // 변수 2, 메소드 1
    static int sV1, sV2;
    static void sMethod(){
        // iV1=1; //왜 오류인가?
        // => static이 먼저 생기기때문에 인스턴스인 iV1은 더 나중에 선언되서 아직 iV1이 없는 상태임.

        Test t = new Test();
        t.iV1=10;
        //스태틱은 먼저 메모리에 올라가기 때문에 일반적으로는 접근이 불가하ㅏㄷ
        // 스태틱이 메모리에 올라갈때 인스턴스화해서 가지고 가야함.
    }

    //lClass 에 있는 모든 멤버사용하기
    //수단방법 가리지 않고
    //왜 이렇게 쓰는지?
    void lMethod(){
        class lClass{
            String lV;
            void lMethod() {
            }
        }
        // 메소드속에서 선언된 lClass는 로컬멤버이기 때문에 메소드 실행 후에
        // 사라져버리기 때문에
        // 로컬 안에서만 쓸 수 있다.

        // 리턴이 필요한 이유를 생각하자!=> 메소드 사용후 결과값을 전해주기위함!

        // !! 메소드내부에서 만든 모든 것은 지역멤버 로컬멤버라고한다.(지역밖에서는 사용 x)

        lClass lc = new lClass();
        lc.lV="lClass";
        lc.lMethod();

    }

    int lMethod2(){ // return은 모든 내가아는것들이 올수있음. return이필요한이유는
        //메소드는 메소드가 끝나고 나서 내부에 있는 모든것들을 메모리에서 비움.
        //따라서 메소드가 실행되고나서 결과를 받고싶다면 반드시 return이 필요하다.
        class lClass{
            int a , b;
        }
        lClass lc = new lClass();
        lc.a = 10;
        lc.b = 20;
        return lc.a + lc.b;
    }

    class Sub{
        String sub_v1;

        void subMethod(){

        }
    }

    static class sSub{
        static int subV2;
        static void subMethod2(){

        }
        String subV1;
        void subMethod(){

        }
    }

}
