package com.example.mproject.email;

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
}
