package com.example.mproject.emailtest;

import com.example.mproject.email.service.SendMail;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
//SpringBootTest在启动的时候不会启动服务器，所以WebSocket自然会报错，这个时候需要添加选项webEnvironment，以便提供一个测试的web环境
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@RunWith(SpringRunner.class)
public class SendMailTest {
    @Autowired
    private SendMail mailService;
    private String toEmail = "1024262077@qq.com";		// 填写你的qq邮箱号

    @Test
    public void sendTextMail() {
        mailService.sendTextMail(toEmail,"主题","测试内容");
    }

    @Test
    public void sendAttachmentMail() {
        mailService.sendAttachmentMail(toEmail,"这是带附件的邮件","有附件","D:\\笔记整理\\使用spring boot实现发送邮件功能.md");
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
    @Test
    public void testxx(){
        float x, y;
        for (y = (float)1.5; y > -1.5; y -= 0.1) {
            for (x = (float)-1.5; x < 1.5; x += 0.05) {
                float a = x * x + y * y - 1;
                if ((a * a * a - x * x * y * y * y) <= 0.0) {
                    System.out.print("*");
                } else {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
    }
}
