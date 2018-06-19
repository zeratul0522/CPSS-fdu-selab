package cn.edu.fudan.selab.smartHomeController.user;

import org.apache.catalina.servlet4preview.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import java.io.IOException;
import java.util.logging.Filter;
import java.util.logging.LogRecord;

@Component
public class TokenFilter implements Filter{

    private JWTService jwtService;

    public TokenFilter(@Autowired JWTService jwtService){
        this.jwtService = jwtService;
    }

    @Override
    public boolean isLoggable(LogRecord record) {
        return false;
    }

//    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException{
//        HttpServletRequest
//    }
}
