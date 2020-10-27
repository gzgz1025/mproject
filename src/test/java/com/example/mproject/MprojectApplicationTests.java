package com.example.mproject;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@RunWith(SpringRunner.class)
class MprojectApplicationTests {

    @Test
    void contextLoads() {
    }
    @Test
    public void test(){
        Integer number = new Integer(8);
        for(int i=1;i<=number;i++) {
            for(int m=0;m<number-i;m++) {
                System.out.print(" ");
            }
            if(i==1) {
                System.out.println("*");
            }
            else if(i==number) {
                for(int n=1;n<=2*number-1;n++) {
                    System.out.print("*");
                }
                System.out.println("\n");
            }
            else {
                System.out.print("*");
                for(int p=1;p<=2*i-3;p++) {
                    System.out.print(" ");
                }
                System.out.println("*");
            }
        }

    }
}
