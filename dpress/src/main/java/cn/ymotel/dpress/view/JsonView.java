package cn.ymotel.dpress.view;

import cn.ymotel.dactor.Constants;
import cn.ymotel.dactor.async.web.view.CustomHttpView;
import cn.ymotel.dactor.message.Message;
import cn.ymotel.dactor.message.ServletMessage;
import com.alibaba.fastjson.JSON;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.util.AntPathMatcher;
import org.springframework.util.PathMatcher;
import run.halo.app.exception.AbstractHaloException;
import run.halo.app.model.support.CommentPage;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
@Component
public class JsonView  implements CustomHttpView<ServletMessage> {


    @Override
    public void successRender(ServletMessage message, String viewName) {
        Object obj=message.getContextData(Constants.CONTENT);
        if(obj instanceof  String){
            writeString(message,(String)obj,null);
            return;
        }
        Map rtnMap=new HashMap();
        if(obj instanceof Page){
            Page page=(Page)obj;
            Map dataMap=new HashMap();
            dataMap.put("content",page.getContent());
            dataMap.put("pages",page.getTotalPages());
            dataMap.put("total",page.getTotalElements());
            dataMap.put("page",page.getNumber());
            dataMap.put("rpp",page.getSize());
            dataMap.put("hasNext",page.hasNext());
            dataMap.put("hasPrevious",page.hasPrevious());
            dataMap.put("isFirst",page.isFirst());
            dataMap.put("isLast",page.isLast());
            dataMap.put("isEmpty",page.isEmpty());
            dataMap.put("hasContent",page.hasContent());
            if (obj instanceof CommentPage) {
                CommentPage commentPage = (CommentPage) page;
                dataMap.put("commentPage",commentPage.getCommentCount());
            }
            rtnMap.put("data", dataMap);

        }else {
            rtnMap.put("data", obj);
        }

        rtnMap.put("status",HttpStatus.OK.value());
        rtnMap.put("message",HttpStatus.OK.getReasonPhrase());
       String json= JSON.toJSONString(rtnMap);
        writeString(message,json,null);

    }

    @Override
    public void exceptionRender(ServletMessage message, String viewName) {
        HttpStatus status=HttpStatus.BAD_REQUEST;
        Map map=new HashMap();
        if(message.getException() instanceof AbstractHaloException){
            status=((AbstractHaloException)message.getException()).getStatus();
            map.put("data",((AbstractHaloException)message.getException()).getErrorData());
        };
        map.put("message",message.getException().getMessage());
        map.put("status", status.value());
        String json= JSON.toJSONString(map);
        writeString(message,json,status);
    }
    public void writeString(ServletMessage message,String string,HttpStatus status){
        try {
            HttpServletResponse response= (HttpServletResponse)message.getAsyncContext().getResponse();
           if(response.isCommitted()){
               return;
           }
            if(status!=null) {
                response.setStatus(status.value(),status.getReasonPhrase());
            }
            message.getAsyncContext().getResponse().setContentType("application/json;charset=UTF-8");
            message.getAsyncContext().getResponse().getWriter().print(string);
            message.getAsyncContext().getResponse().getWriter().flush();
            message.getAsyncContext().complete();
        } catch (IOException e) {

        }
    }

    @Override
    public List<String> getUrlPatterns() {
        List rtnList=new ArrayList();
        rtnList.add("/api/content/posts/**");
        rtnList.add("/api/content/options/comment");
        rtnList.add("/api/admin/**");
        return rtnList;
    }

//    @Override
//    public String getUrlPattern() {
//        return "/api/admin/**";
//    }

    @Override
    public String getExcludeUrlPattern() {
        return "/api/admin/**/*.json";
    }
    public static void main(String[] args){
        PathMatcher matcher=new AntPathMatcher();
        boolean b=matcher.match("/api/admin/**/*.json","/api/admin/site/list.json");
        System.out.println(b);
    }
}
