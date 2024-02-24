//package com.tokenService.Config;
//
//import com.tokenService.Services.TokenService;
//import jakarta.servlet.FilterChain;
//import jakarta.servlet.ServletException;
//import jakarta.servlet.ServletRequest;
//import jakarta.servlet.ServletResponse;
//import jakarta.servlet.http.HttpServletRequest;
//import jakarta.servlet.http.HttpServletResponse;
//import org.bson.types.ObjectId;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.web.filter.GenericFilterBean;
//
//import java.io.IOException;
//
//@Configuration
//public class JWTFilter extends GenericFilterBean {
//
//    private TokenService tokenservice;
//
//    public JWTFilter(TokenService tokenservice) {
//        this.tokenservice=tokenservice;
//    }
//
//    @Override
//    public void doFilter(ServletRequest req,
//                         ServletResponse res,
//                         FilterChain filterchain) throws IOException, ServletException {
//
//        HttpServletRequest httpservletrequest=(HttpServletRequest) req;
//        HttpServletResponse httpservletresponse=(HttpServletResponse) res;
//
//        String token=httpservletrequest.getHeader("Authorization");
//        if("OPTIONS".equalsIgnoreCase(httpservletrequest.getMethod())){
//            httpservletresponse.setStatus(HttpServletResponse.SC_OK);
//            return;
//        }
//        if(allowRequestWithoutToken(httpservletrequest)){
//            httpservletresponse.setStatus(HttpServletResponse.SC_OK);
//            filterchain.doFilter(req,res);
//
//        }
//        else{
//            String userId= tokenservice.getUserIdFromToken(token);
//            httpservletrequest.setAttribute("userId",userId);
//            filterchain.doFilter(req,res);
//        }
//
//
//    }
//
//    public boolean allowRequestWithoutToken(HttpServletRequest httpServletRequest){
//        // System.out.println(httpServletRequest.getRequestURI());
//        String[] matches=new String[]
//                {"/login","/registration","/products","/categories","/getallusers","/users","/consumer","token"};
//        for(String s:matches) {
//            if (httpServletRequest.getRequestURI().contains(s) && !httpServletRequest.getRequestURI().contains("/delete"))
//                return true;
//        }
//        return false;
//    }
//}
