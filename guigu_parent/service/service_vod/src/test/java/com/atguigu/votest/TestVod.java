package com.atguigu.votest;

import com.aliyun.vod.upload.impl.UploadVideoImpl;
import com.aliyun.vod.upload.req.UploadVideoRequest;
import com.aliyun.vod.upload.resp.UploadVideoResponse;
import com.aliyuncs.DefaultAcsClient;
import com.aliyuncs.vod.model.v20170321.*;

import java.util.List;

public class TestVod {
    public static void main(String[] args) throws Exception {
//        String accessKeyId = "LTAI4GFvGubEGdzPbfDbZ1Vs";
//        String accessKeySecret = "kegHPxMHfh9fIFcH5AqG2H0ygVW1HC";
//        String title = "刘诗诗";
//        String fileName = "/Users/jkl/Desktop/liushishi.mp4";
//        UploadVideoRequest request = new UploadVideoRequest(accessKeyId, accessKeySecret, title, fileName);
//        request.setPartSize(2 * 1024 * 1024L);
//        request.setTaskNum(1);
//
//        UploadVideoImpl uploader = new UploadVideoImpl();
//        UploadVideoResponse response = uploader.uploadVideo(request);
//
//        if (response.isSuccess()) {
//            System.out.print("VideoId=" + response.getVideoId() + "\n");
//        } else {
//            /* 如果设置回调URL无效，不影响视频上传，可以返回VideoId同时会返回错误码。其他情况上传失败时，VideoId为空，此时需要根据返回错误码分析具体错误原因 */
//            System.out.print("VideoId=" + response.getVideoId() + "\n");
//            System.out.print("ErrorCode=" + response.getCode() + "\n");
//            System.out.print("ErrorMessage=" + response.getMessage() + "\n");
//        }
        getPlayAuth();
    }

    public static void getPlayAuth() throws Exception {
        DefaultAcsClient client = InitObject.initVodClient("LTAI4GFvGubEGdzPbfDbZ1Vs", "kegHPxMHfh9fIFcH5AqG2H0ygVW1HC");
        GetVideoPlayAuthRequest request = new GetVideoPlayAuthRequest();
        GetVideoPlayAuthResponse response = new GetVideoPlayAuthResponse();
        request.setVideoId("62b08d2517124635bca817472be0e8b3");
        response = client.getAcsResponse(request);
        System.out.println("playAuth:" + response.getPlayAuth());
    }

    public static void getPlayUrl() throws Exception {
        // 1. 根据视频id 获取视频的播放地址
        DefaultAcsClient client = InitObject.initVodClient("LTAI4GFvGubEGdzPbfDbZ1Vs", "kegHPxMHfh9fIFcH5AqG2H0ygVW1HC");
        GetPlayInfoRequest request = new GetPlayInfoRequest();
        GetPlayInfoResponse response = new GetPlayInfoResponse();
        request.setVideoId("fd9a60c19df94bacb8749fd41d27f410");
        response = client.getAcsResponse(request);

        List<GetPlayInfoResponse.PlayInfo> playInfoList = response.getPlayInfoList();
        for (GetPlayInfoResponse.PlayInfo playInfo : playInfoList) {
            System.out.println("PlayInfo.PlayUrl = " + playInfo.getPlayURL() + "\n");
        }

        System.out.println("VideoBase.Title" + response.getVideoBase().getTitle() + "\n");
    }
}
