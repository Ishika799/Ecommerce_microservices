package com.apiGateway.Config;

import com.apiGateway.Controllers.TokenController;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.bson.types.ObjectId;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.filter.GenericFilterBean;

import java.io.IOException;

@Configuration
public class JWTFilter extends GenericFilterBean {

    private TokenController tokenController;

    public JWTFilter(TokenController tokenController) {
        this.tokenController=tokenController;
    }

    @Override
    public void doFilter(ServletRequest req,
                         ServletResponse res,
                         FilterChain filterchain) throws IOException, ServletException {

        HttpServletRequest httpservletrequest=(HttpServletRequest) req;
        HttpServletResponse httpservletresponse=(HttpServletResponse) res;

        String token=httpservletrequest.getHeader("Authorization");
        if("OPTIONS".equalsIgnoreCase(httpservletrequest.getMethod())){
            httpservletresponse.setStatus(HttpServletResponse.SC_OK);
            return;
        }
        if(allowRequestWithoutToken(httpservletrequest)){
            httpservletresponse.setStatus(HttpServletResponse.SC_OK);
            filterchain.doFilter(req,res);

        }
        else{
            String userId= tokenController.getUserIdFromToken(token);
            httpservletrequest.setAttribute("userId",userId);
            filterchain.doFilter(req,res);
        }


    }

    public boolean allowRequestWithoutToken(HttpServletRequest httpServletRequest){
//        if(!httpServletRequest.getRequestURI().contains("/shop")) return true;
        if(httpServletRequest.getRequestURI().contains("/consumer/login")) return true;
        else if(httpServletRequest.getRequestURI().contains("/consumer/registration")) return true;
        else if(httpServletRequest.getRequestURI().contains("/consumer/getallusers")) return true;
        else if(httpServletRequest.getRequestURI().contains("/consumer/get-token/")) return true;
        else if(httpServletRequest.getRequestURI().contains("/consumer/get-userId-from-token/")) return true;
        else if(httpServletRequest.getRequestURI().contains("/shop/")) return true;
        else return false;
    }
}

