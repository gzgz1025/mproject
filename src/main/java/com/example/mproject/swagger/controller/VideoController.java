package com.example.mproject.swagger.controller;

import io.swagger.annotations.*;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * 只有在类上使用@Api注解标注并且在方法上使用@ApiOperation注解才会暴露给swagger，这种方式没有包名的限制，可以将需要暴露的接口分散到各个包里，
 * 只要类上有@Api注解方法上有@ApiOperation注解就能暴露出来，如果不想暴露出来就不用使用这两个注解
 */
@RequestMapping("/api/v1.0/video")
@RestController
@Api(value = "video API", tags = "video", description = "视频相关接口")
public class VideoController {

    /**
     * @ApiOperation(value = “接口方法的名称”, notes = “备注说明”)
     * @ApiParam(name = “参数名称”, value = “备注说明”, required = 是否必须)：标注在方法的参数上 用于描述参数的名称、备注、是否必须等信息
     * @ApiImplicitParams： 用于包含多个@ApiImplicitParam
     * @ApiResponse(code = 0, message = “success”),
     *
     * code：响应码，例如400
     * message：信息，一般是对code的描述
     * response：抛出异常的类
     * @param secret_key
     * @param token
     * @param type
     * @return
     *
     *
     * @ApiImplicitParam用于描述方法的参数，标注在方法上，和@ApiParam功能一样，只是标注的位置不同而已
     *
     * paramType：参数类型，即参数放在哪个地方
     * header–>请求参数的获取：@RequestHeader，参数放在请求头
     * query–>请求参数的获取：@RequestParam，参数追加在url后面
     * path（用于restful接口）–>请求参数的获取：@PathVariable
     * body 使用@RequestBody接收数据 POST有效，参数放在请求体中
     * name：参数名
     * dataType：参数的数据类型
     * required：参数是否必须传
     * value：参数的描述
     * defaultValue：参数的默认值
     * @ApiImplicitParams： 用于包含多个@ApiImplicitParam
     */
    @ApiOperation(value = "获取视频流", notes = "获取视频流信息")
    @ApiResponses({
            @ApiResponse(code = 200, message = "success"),
            @ApiResponse(code = 10001, message = "secret_key与token不符合"),
            @ApiResponse(code = 10002, message = "视频流类型错误", response = Exception.class)
    })
    @PostMapping("/getVideo")
    public String getVideo(@ApiParam(name = "secret_key", value = "秘钥", required = true) @RequestParam String secret_key,
                           @ApiParam(name = "token", value = "token", required = true) @RequestParam String token,
                           @ApiParam(name = "type", value = "流类型", required = true) @RequestParam String type){
        return "{'type': " + type + ", 'url': 'rtmp://localhost/video', 'urlHD': 'rtmp://localhost/hd/video'}";
    }

    /**
     * @ApiModel：描述一个Model的信息（这种一般用在post创建的时候，使用@RequestBody这样的场景，请求参数无法使用@ApiImplicitParam注解进行描述的时候）
     * @ApiModelProperty：描述一个model的属性
     *
     * value 参数名称
     * required 是否必须 boolean
     * hidden 是否隐藏 boolean
     * @ApiIgnore：用于或略该接口，不生成该接口的文档
     */
    @ApiModelProperty(value = "当前页", required = true)
    private Integer page;

    @ApiModelProperty(value = "每页记录数", required = true)
    private Integer pageSize;


}
