package com.qwsite.xxw.bean;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.fileupload.FileUploadBase;
import org.apache.commons.fileupload.servlet.ServletRequestContext;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

public class PostAndPutCommonsMultipartResolver extends CommonsMultipartResolver {

    @Override
    public boolean isMultipart(HttpServletRequest request) {
        if ("POST".equalsIgnoreCase(request.getMethod()) || "PUT".equalsIgnoreCase(request.getMethod())) {
            return FileUploadBase.isMultipartContent(new ServletRequestContext(request));
        }
        return false;
    }

}