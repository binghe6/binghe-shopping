package com.binghe.shopping.manage.common.bean.resp;

import lombok.Data;
import lombok.experimental.Accessors;

@Data(staticConstructor="of")
@Accessors(chain=true)
public class PicUploadResp {
    
    private Integer error;// 0-上传成功，1-上传失败
    
    private String url;// 上传后的图片的路径
    
    private String width;
    
    private String height;

}
