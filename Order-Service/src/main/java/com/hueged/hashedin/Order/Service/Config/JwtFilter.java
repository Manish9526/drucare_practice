//package com.hueged.hashedin.Order.Service.Config;
//
//
//import java.io.IOException;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
//import org.springframework.security.core.context.SecurityContextHolder;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
//import org.springframework.stereotype.Component;
//import org.springframework.web.filter.OncePerRequestFilter;
//
//import com.hueged.hashedin.Order.Service.Service.OrderService;
//
//import jakarta.servlet.FilterChain;
//import jakarta.servlet.ServletException;
//import jakarta.servlet.http.HttpServletRequest;
//import jakarta.servlet.http.HttpServletResponse;
//
//@Component
//public class JwtFilter extends OncePerRequestFilter {
//
//	@Autowired
//	OrderService defaultUserService;
//
//	@Autowired
//	JwtGeneratorValidator jwtgenVal;
//	@Override
//	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
//	        throws ServletException, IOException {
//	    String jwtToken = extractJwtFromRequest(request);
//
//	    if (jwtToken != null && SecurityContextHolder.getContext().getAuthentication() == null) {
//	        String userName = jwtgenVal.extractUsername(jwtToken);
//	        UserDetails userDetails = defaultUserService.loadUserByUsername(userName);
//
//	        if (jwtgenVal.validateToken(jwtToken, userDetails)) {
//	            UsernamePasswordAuthenticationToken auth = jwtgenVal.getAuthenticationToken(jwtToken, SecurityContextHolder.getContext().getAuthentication(), userDetails);
//	            auth.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
//	            SecurityContextHolder.getContext().setAuthentication(auth);
//	        }
//	    }
//	    filterChain.doFilter(request, response);
//	}
//
//	private String extractJwtFromRequest(HttpServletRequest request) {
//	    String bearerToken = request.getHeader("Authorization");
//	    if (bearerToken != null && bearerToken.startsWith("Bearer ")) {
//	        return bearerToken.substring(7);
//	    }
//	    return null;
//	}
//
//	
//}